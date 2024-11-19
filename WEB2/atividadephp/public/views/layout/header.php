<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portal de Vagas</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
    <nav class="bg-white shadow-lg">
        <div class="max-w-7xl mx-auto px-4">
            <div class="flex justify-between h-16">
                <div class="flex">
                    <a href="/" class="flex items-center">
                        <span class="text-xl font-bold text-gray-800">Portal de Vagas</span>
                    </a>
                </div>
                <div class="flex items-center">
                    <?php if (isset($_SESSION['user'])): ?>
                        <?php if ($_SESSION['user']['role'] === 'admin'): ?>
                            <a href="/jobs/create" class="text-gray-600 hover:text-gray-900 px-3 py-2">Publicar Vaga</a>
                        <?php endif; ?>
                        <a href="/profile" class="text-gray-600 hover:text-gray-900 px-3 py-2">Perfil</a>
                        <a href="/logout" class="text-gray-600 hover:text-gray-900 px-3 py-2">Sair</a>
                    <?php else: ?>
                        <a href="/login" class="text-gray-600 hover:text-gray-900 px-3 py-2">Entrar</a>
                        <a href="/register" class="bg-blue-500 hover:bg-blue-600 text-white px-4 py-2 rounded-md ml-3">Cadastrar</a>
                    <?php endif; ?>
                </div>
            </div>
        </div>
    </nav>
    <main class="max-w-7xl mx-auto py-6 sm:px-6 lg:px-8">