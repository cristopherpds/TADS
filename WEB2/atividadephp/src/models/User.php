<?php
namespace App\Models;

class User {
    private $id;
    private $name;
    private $email;
    private $password;
    private $imageUrl;
    private $linkedinUrl;
    private $role;

    public function __construct($name, $email, $password, $imageUrl, $linkedinUrl, $role = 'user') {
        $this->name = $name;
        $this->email = $email;
        $this->password = $password;
        $this->imageUrl = $imageUrl;
        $this->linkedinUrl = $linkedinUrl;
        $this->role = $role;
    }

    // Getters
    public function getId() { return $this->id; }
    public function getName() { return $this->name; }
    public function getEmail() { return $this->email; }
    public function getPassword() { return $this->password; }
    public function getImageUrl() { return $this->imageUrl; }
    public function getLinkedinUrl() { return $this->linkedinUrl; }
    public function getRole() { return $this->role; }

    // Setters
    public function setId($id) { $this->id = $id; }
    public function setName($name) { $this->name = $name; }
    public function setEmail($email) { $this->email = $email; }
    public function setPassword($password) { $this->password = $password; }
    public function setImageUrl($imageUrl) { $this->imageUrl = $imageUrl; }
    public function setLinkedinUrl($linkedinUrl) { $this->linkedinUrl = $linkedinUrl; }
    public function setRole($role) { $this->role = $role; }
}