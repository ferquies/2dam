<!DOCTYPE html>
<html>
  <head>
    <title>Prueba</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
  </head>
  <body>
    <div class="row">
        <div class="col-md-4">
            <h3>Subir ficheros</h3>
            <form action="subida.php" method="post" enctype="multipart/form-data">
                <input name="userfile" type="file">
                <br>
                <input type="submit" value="Enviar">
            </form> 
        </div>
        <h3>Listado de archivos</h3>
        <div class="col-md-4">
            <?php
                $file = fopen("vids.txt","w") or die("Error al abrir el fichero vids.txt");
                $directorio = './Videos/'; 
                function ordenar($a,$b){ 
                    global $directorio; 
                    $a = filemtime($directorio.$a); 
                    $b = filemtime($directorio.$b); 
                    if ($a == $b) { 
                        return 0; 
                    } 
                    return ($a < $b) ? -1 : 1; 
                } 
                $dir=opendir($directorio); 
                while($arch=readdir($dir)) $ars[] = $arch; 
                closedir($dir); 
                usort($ars, "ordenar"); 
                foreach($ars as $ar) {
                    if(!is_dir($ar)) {
                        echo "$ar"."<br>";
                        fputs($file, $ar."\n");
                    }
                }
                fclose($file);
            ?>
        </div>
    </div>
  </body>
</html>