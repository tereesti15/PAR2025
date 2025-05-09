<?php
session_start();
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cálculo del factorial</title>
</head>
<body>
    <h1>Cálculo del factorial</h1>

    <!-- Formulario que solicita al usuario el número a usar en el cálculo -->
    <form action="" method="get">
        <p>Número: <input type="text" name="numero">
        <input type="submit" value="Calcular"></p>
    </form>

    <?php
    if (isset($_GET['numero'])) {
        $numeroGet = $_GET['numero'];
        $error = false;
        $factorial = 1;

        if (!is_numeric($numeroGet) || intval($numeroGet) < 1) {
            $error = true;
        } else {
            $numero = intval($numeroGet);
            for ($i = $numero; $i > 1; $i--) {
                $factorial *= $i;
            }
        }

        if ($error) {
            echo "<p>Debe indicar un número entero mayor que 0</p>";
        } else {
            echo "<p>Resultado: $numero! = $factorial</p>";
        }
    }

    // Uso de la sesión para contar ejecuciones
    if (!isset($_SESSION['contadorVisitas'])) {
        $_SESSION['contadorVisitas'] = 0;
    }

    if ($_SESSION['contadorVisitas'] != 0) {
        echo "<p>Ejecuciones de la aplicación en esta sesión: " . $_SESSION['contadorVisitas'] . "</p>";
    }

    $_SESSION['contadorVisitas']++;
    ?>
</body>
</html>
