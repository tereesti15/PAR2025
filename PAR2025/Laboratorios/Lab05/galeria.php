<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Galería de Imágenes</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }
        .galeria {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }
        .imagen {
            margin: 10px;
            border: 1px solid #ccc;
            padding: 5px;
            width: 200px;
        }
        .imagen img {
            width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
    <h1>Galería de Imágenes</h1>
    
    <div class="galeria">
        <?php
        // Directorio donde están las imágenes
        $directorio = "images/";

        // Obtener todos los archivos del directorio
        $imagenes = glob($directorio . "*.{jpg,jpeg,png,gif}", GLOB_BRACE);

        // Verificar si hay imágenes
        if ($imagenes) {
            foreach ($imagenes as $imagen) {
                echo '<div class="imagen">';
                echo '<img src="' . $imagen . '" alt="Imagen">';
                echo '</div>';
            }
        } else {
            echo "<p>No se encontraron imágenes en el directorio.</p>";
        }
        ?>
    </div>
</body>
</html>
