<?php
require_once __DIR__ . '/../vendor/autoload.php';

use App\Config\Database;
use App\Controllers\AuthController;
use App\Controllers\JobController;

session_start();

$dotenv = Dotenv\Dotenv::createImmutable(__DIR__ . '/..');
$dotenv->load();

$db = Database::getInstance()->getConnection();

$uri = parse_url($_SERVER['REQUEST_URI'], PHP_URL_PATH);
$uri = explode('/', $uri);

// Simple routing
switch ($uri[1]) {
    case '':
        require 'views/home.php';
        break;
    case 'login':
        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            (new AuthController($db))->login();
        } else {
            require 'views/login.php';
        }
        break;
    case 'register':
        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            (new AuthController($db))->register();
        } else {
            require 'views/register.php';
        }
        break;
    case 'jobs':
        $jobController = new JobController($db);
        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            $jobController->create();
        } else {
            $jobController->index();
        }
        break;
    default:
        http_response_code(404);
        require 'views/404.php';
        break;
}