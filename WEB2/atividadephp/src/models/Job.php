<?php
namespace App\Models;

class Job {
    private $id;
    private $title;
    private $description;
    private $company;
    private $location;
    private $requirements;
    private $contactEmail;
    private $imageUrl;
    private $isActive;
    private $createdAt;

    public function __construct($title, $description, $company, $location, $requirements, 
                              $contactEmail, $imageUrl, $isActive = true) {
        $this->title = $title;
        $this->description = $description;
        $this->company = $company;
        $this->location = $location;
        $this->requirements = $requirements;
        $this->contactEmail = $contactEmail;
        $this->imageUrl = $imageUrl;
        $this->isActive = $isActive;
    }

    // Getters
    public function getId() { return $this->id; }
    public function getTitle() { return $this->title; }
    public function getDescription() { return $this->description; }
    public function getCompany() { return $this->company; }
    public function getLocation() { return $this->location; }
    public function getRequirements() { return $this->requirements; }
    public function getContactEmail() { return $this->contactEmail; }
    public function getImageUrl() { return $this->imageUrl; }
    public function isActive() { return $this->isActive; }
    public function getCreatedAt() { return $this->createdAt; }

    // Setters
    public function setId($id) { $this->id = $id; }
    public function setTitle($title) { $this->title = $title; }
    public function setDescription($description) { $this->description = $description; }
    public function setCompany($company) { $this->company = $company; }
    public function setLocation($location) { $this->location = $location; }
    public function setRequirements($requirements) { $this->requirements = $requirements; }
    public function setContactEmail($contactEmail) { $this->contactEmail = $contactEmail; }
    public function setImageUrl($imageUrl) { $this->imageUrl = $imageUrl; }
    public function setIsActive($isActive) { $this->isActive = $isActive; }
    public function setCreatedAt($createdAt) { $this->createdAt = $createdAt; }
}