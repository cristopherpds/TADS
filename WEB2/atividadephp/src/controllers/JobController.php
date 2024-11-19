<?php
namespace App\Controllers;

use App\DAO\JobDAO;
use App\DAO\ApplicationDAO;
use App\Models\Job;
use PDO;

class JobController {
    private $db;
    private $jobDAO;
    private $applicationDAO;

    public function __construct(PDO $db) {
        $this->db = $db;
        $this->jobDAO = new JobDAO($db);
        $this->applicationDAO = new ApplicationDAO($db);
    }

    public function index() {
        $jobs = $this->jobDAO->getActiveJobs();
        require 'views/home.php';
    }

    public function create() {
        if (!isset($_SESSION['user']) || $_SESSION['user']['role'] !== 'admin') {
            header('Location: /');
            exit;
        }

        $title = $_POST['title'] ?? '';
        $description = $_POST['description'] ?? '';
        $company = $_POST['company'] ?? '';
        $location = $_POST['location'] ?? '';
        $requirements = $_POST['requirements'] ?? '';
        $contactEmail = $_POST['contact_email'] ?? '';
        $imageUrl = $_POST['image_url'] ?? '';

        $job = new Job($title, $description, $company, $location, $requirements, $contactEmail, $imageUrl);
        
        if ($this->jobDAO->create($job)) {
            $_SESSION['success'] = 'Vaga publicada com sucesso!';
        } else {
            $_SESSION['error'] = 'Erro ao publicar vaga';
        }
        
        header('Location: /jobs');
        exit;
    }

    public function toggleStatus($jobId) {
        if (!isset($_SESSION['user']) || $_SESSION['user']['role'] !== 'admin') {
            header('Location: /');
            exit;
        }

        if ($this->jobDAO->toggleStatus($jobId)) {
            $_SESSION['success'] = 'Status da vaga atualizado com sucesso!';
        } else {
            $_SESSION['error'] = 'Erro ao atualizar status da vaga';
        }

        header('Location: /jobs');
        exit;
    }

    public function apply($jobId) {
        if (!isset($_SESSION['user'])) {
            header('Location: /login');
            exit;
        }

        if ($this->applicationDAO->apply($_SESSION['user']['id'], $jobId)) {
            $_SESSION['success'] = 'Candidatura realizada com sucesso!';
        } else {
            $_SESSION['error'] = 'Erro ao realizar candidatura';
        }

        header('Location: /jobs/' . $jobId);
        exit;
    }

    public function viewApplications($jobId) {
        if (!isset($_SESSION['user']) || $_SESSION['user']['role'] !== 'admin') {
            header('Location: /');
            exit;
        }

        $applications = $this->applicationDAO->getApplicationsByJob($jobId);
        require 'views/applications.php';
    }
}