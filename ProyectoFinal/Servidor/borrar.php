<?php
    for($i = 0; $i < count($_POST['archivo']); $i++) {
        if(unlink($_POST['archivo'][$i])) {
            echo $_POST['archivo'][$i]." eliminado correctamente.<br>";
        } else {
            echo "Error al eliminar ".$_POST['archivo'][$i];
        }
    }
?>

<html>
    <head>
        <meta http-equiv='refresh' content='2;url=index.php'>
    </head>
</html>