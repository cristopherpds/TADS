<?php require 'layout/header.php'; ?>

<div class="max-w-4xl mx-auto">
    <h2 class="text-2xl font-bold text-gray-800 mb-8">Candidatos para a Vaga</h2>

    <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
        <?php foreach ($applications as $application): ?>
        <div class="bg-white rounded-lg shadow-md overflow-hidden">
            <div class="p-6">
                <div class="flex items-center">
                    <img src="<?php echo htmlspecialchars($application['image_url']); ?>" 
                         alt="<?php echo htmlspecialchars($application['name']); ?>"
                         class="w-16 h-16 rounded-full object-cover">
                    <div class="ml-4">
                        <h3 class="text-xl font-semibold text-gray-900">
                            <?php echo htmlspecialchars($application['name']); ?>
                        </h3>
                        <p class="text-gray-600">
                            <?php echo htmlspecialchars($application['email']); ?>
                        </p>
                        <a href="<?php echo htmlspecialchars($application['linkedin_url']); ?>"
                           target="_blank"
                           class="text-blue-500 hover:text-blue-700">
                            Perfil LinkedIn
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <?php endforeach; ?>
    </div>
</div>

<?php require 'layout/footer.php'; ?>