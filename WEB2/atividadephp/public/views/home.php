<?php require 'layout/header.php'; ?>

<div class="bg-white shadow-xl rounded-lg p-6 mb-8">
    <h1 class="text-3xl font-bold text-gray-900 mb-4">Encontre sua Próxima Oportunidade</h1>
    <p class="text-gray-600">Explore nossa lista de vagas em empresas de destaque.</p>
</div>

<div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
    <?php 
    // Asegúrate de que $jobs esté definido y sea un array
    if (!isset($jobs) || !is_array($jobs)) {
        $jobs = [];
        
    }
    foreach ($jobs as $job): ?>
    <div class="bg-white rounded-lg shadow-md overflow-hidden">
        <img src="<?php echo htmlspecialchars($job['image_url']); ?>" 
             alt="<?php echo htmlspecialchars($job['company']); ?>" 
             class="w-full h-48 object-cover">
        <div class="p-6">
            <h2 class="text-xl font-semibold text-gray-900 mb-2">
                <?php echo htmlspecialchars($job['title']); ?>
            </h2>
            <p class="text-gray-600 mb-4">
                <?php echo htmlspecialchars($job['company']); ?> • 
                <?php echo htmlspecialchars($job['location']); ?>
            </p>
            <p class="text-gray-700 mb-4">
                <?php echo htmlspecialchars(substr($job['description'], 0, 150)) . '...'; ?>
            </p>
            <div class="flex justify-between items-center">
                <a href="/jobs/<?php echo $job['id']; ?>" 
                   class="bg-blue-500 hover:bg-blue-600 text-white px-4 py-2 rounded-md">
                    Ver Detalhes
                </a>
                <span class="text-gray-500 text-sm">
                    Publicada em <?php echo date('d/m/Y', strtotime($job['created_at'])); ?>
                </span>
            </div>
        </div>
    </div>
    <?php endforeach; ?>
</div>
<?php require 'layout/footer.php'; ?>