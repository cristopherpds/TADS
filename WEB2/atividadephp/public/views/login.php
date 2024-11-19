<?php require 'layout/header.php'; ?>

<div class="max-w-md mx-auto bg-white rounded-lg shadow-md overflow-hidden mt-8">
    <div class="px-6 py-8">
        <h2 class="text-2xl font-bold text-center text-gray-800 mb-8">Entrar</h2>
        
        <?php if (isset($_SESSION['error'])): ?>
            <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded mb-4">
                <?php 
                echo $_SESSION['error'];
                unset($_SESSION['error']);
                ?>
            </div>
        <?php endif; ?>

        <form action="/login" method="POST">
            <div class="mb-4">
                <label class="block text-gray-700 text-sm font-bold mb-2" for="email">
                    Email
                </label>
                <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                       id="email"
                       type="email"
                       name="email"
                       required>
            </div>
            <div class="mb-6">
                <label class="block text-gray-700 text-sm font-bold mb-2" for="password">
                    Senha
                </label>
                <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"
                       id="password"
                       type="password"
                       name="password"
                       required>
            </div>
            <div class="flex items-center justify-between">
                <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline w-full"
                        type="submit">
                    Entrar
                </button>
            </div>
        </form>
        <p class="text-center text-gray-600 text-sm mt-4">
            Não tem uma conta? <a href="/register" class="text-blue-500 hover:text-blue-700">Cadastre-se</a>
        </p>
    </div>
</div>

<?php require 'layout/footer.php'; ?>