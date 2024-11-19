<?php
namespace App\DAO;

use PDO;
use App\Models\User;

class UserDAO {
    private $db;

    public function __construct(PDO $db) {
        $this->db = $db;
    }

    public function create(User $user) {
        $sql = "INSERT INTO users (name, email, password, image_url, linkedin_url, role) 
                VALUES (:name, :email, :password, :image_url, :linkedin_url, :role)";
        
        $stmt = $this->db->prepare($sql);
        return $stmt->execute([
            'name' => $user->getName(),
            'email' => $user->getEmail(),
            'password' => password_hash($user->getPassword(), PASSWORD_DEFAULT),
            'image_url' => $user->getImageUrl(),
            'linkedin_url' => $user->getLinkedinUrl(),
            'role' => $user->getRole()
        ]);
    }

    public function findByEmail($email) {
        $sql = "SELECT * FROM users WHERE email = :email";
        $stmt = $this->db->prepare($sql);
        $stmt->execute(['email' => $email]);
        return $stmt->fetch(PDO::FETCH_ASSOC);
    }
}