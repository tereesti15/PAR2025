<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>PHP Page - Ejemplo Lab05 - 2025</title>
</head>
<body>
    <h1>Ejemplos de expresiones</h1>

    <!-- Mostrar la fecha y hora actual -->
    <?php echo date('Y-m-d H:i:s'); ?><br>

    <!-- Convertir a mayúsculas un String -->
    <?php echo strtoupper("Texto a mayúsculas"); ?><br>

    <!-- Resultado de una expresión aritmética -->
    <?php echo (5 + 2) / 3; ?><br>

    <!-- Generar un número aleatorio -->
    <?php echo rand(0, 99); ?>
</body>
</html>
