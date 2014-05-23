<?php
    if($_POST['button'] == "Subir") {
        if(move_uploaded_file($_FILES['userfile']['tmp_name'],'Videos/'.$_FILES['userfile']['name'])) {
            echo "Fichero subido correctamente.";
        } else {
            echo "Ha ocurrido un error al subir el fichero.";
        }
    } else if($_POST['button'] == "Subir alternativo") {
        if(move_uploaded_file($_FILES['userfile']['tmp_name'],'Videos_alt/'.$_FILES['userfile']['name'])) {
            echo "Fichero subido correctamente.";
        } else {
            echo "Ha ocurrido un error al subir el fichero.";
        }
    }
?>

<html>
    <head>
        <meta http-equiv='refresh' content='2;url=index.php'>
    </head>
</html>
