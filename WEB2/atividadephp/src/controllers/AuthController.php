<?php
namespace App\Controllers;

use App\DAO\UserDAO;
use App\Models\User;
use PDO;

class AuthController {
    private $db;
    private $userDAO;

    public function __construct(PDO $db) {
        $this->db = $db;
        $this->userDAO = new UserDAO($db);
    }

    public function login() {
        $email = $_POST['email'] ?? '';
        $password = $_POST['password'] ?? '';

        $user = $this->userDAO->findByEmail($email);

        if ($user && password_verify($password, $user['password'])) {
            $_SESSION['user'] = $user;
            header('Location: /');
            exit;
        }

        $_SESSION['error'] = 'Email ou senha inválidos';
        header('Location: /login');
        exit;
    }

    public function register() {
        $name = $_POST['name'] ?? '';
        $email = $_POST['email'] ?? '';
        $password = $_POST['password'] ?? '';
        $imageUrl = $_POST['image_url'] ?? '';
        $linkedinUrl = $_POST['linkedin_url'] ?? '';

        $user = new User($name, $email, $password, $imageUrl, $linkedinUrl);
        
        if ($this->userDAO->create($user)) {
            $_SESSION['success'] = 'Cadastro realizado com sucesso!';
            header('Location: /login');
        } else {
            $_SESSION['error'] = 'Erro ao realizar cadastro';
            header('Location: /register');
        }
        exit;
    }

    public function logout() {
        session_destroy();
        header('Location: /');
        exit;
    }
}