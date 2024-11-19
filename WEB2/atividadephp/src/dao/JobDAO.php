<?php
namespace App\DAO;

use PDO;
use App\Models\Job;

class JobDAO {
    private $db;

    public function __construct(PDO $db) {
        $this->db = $db;
    }

    public function create(Job $job) {
        $sql = "INSERT INTO jobs (title, description, company, location, requirements, 
                contact_email, image_url, is_active, created_at) 
                VALUES (:title, :description, :company, :location, :requirements, 
                :contact_email, :image_url, :is_active, NOW())";
        
        $stmt = $this->db->prepare($sql);
        return $stmt->execute([
            'title' => $job->getTitle(),
            'description' => $job->getDescription(),
            'company' => $job->getCompany(),
            'location' => $job->getLocation(),
            'requirements' => $job->getRequirements(),
            'contact_email' => $job->getContactEmail(),
            'image_url' => $job->getImageUrl(),
            'is_active' => $job->isActive()
        ]);
    }

    public function getActiveJobs() {
        $sql = "SELECT * FROM jobs WHERE is_active = 1 ORDER BY created_at DESC";
        $stmt = $this->db->prepare($sql);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    public function toggleStatus($jobId) {
        $sql = "UPDATE jobs SET is_active = NOT is_active WHERE id = :id";
        $stmt = $this->db->prepare($sql);
        return $stmt->execute(['id' => $jobId]);
    }
}