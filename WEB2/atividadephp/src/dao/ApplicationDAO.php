<?php
namespace App\DAO;

use PDO;

class ApplicationDAO {
    private $db;

    public function __construct(PDO $db) {
        $this->db = $db;
    }

    public function apply($userId, $jobId) {
        $sql = "INSERT INTO applications (user_id, job_id, applied_at) 
                VALUES (:user_id, :job_id, NOW())";
        
        $stmt = $this->db->prepare($sql);
        return $stmt->execute([
            'user_id' => $userId,
            'job_id' => $jobId
        ]);
    }

    public function getApplicationsByJob($jobId) {
        $sql = "SELECT u.name, u.email, u.image_url, u.linkedin_url 
                FROM applications a 
                JOIN users u ON a.user_id = u.id 
                WHERE a.job_id = :job_id";
        
        $stmt = $this->db->prepare($sql);
        $stmt->execute(['job_id' => $jobId]);
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
}