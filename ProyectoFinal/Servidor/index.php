<!DOCTYPE html>
<html>
  <head>
    <title>Prueba</title>
    <link rel="stylesheet" href="./style.css">
    <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css">
  </head>
  <body>
    <div class="row">
        <div class="col-md-4">
            <h3>Subir ficheros</h3>
            <form action="subida.php" method="post" enctype="multipart/form-data">
                <input name="userfile" type="file">
                <br>
                <input type="submit" name='button' value="Subir">
                <input type="submit" name='button' value="Subir alternativo">
            </form> 
        </div>
        <div class="col-md-4">
        <h3>Listado de videos</h3>
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
                ?>
                <form action="borrar.php" method="post" enctype="multipart/form-data">
                <?php
                foreach($ars as $ar) {
                    if(!is_dir($ar)) {
                        echo "<input class='check' name='archivo[]' type='checkbox' value='"."$directorio$ar"."'>"."<a href='"."$directorio$ar"."'>"."$ar"."</a><br>";
                        fputs($file, $ar."\n");
                    }
                }
                ?>
                <input type="submit" name='button' value="Borrar">
                </form>
                <?php
                fclose($file);
            ?>
        </div>
        <div class="col-md-4">
        <h3>Listado de videos alternativos</h3>
            <?php
                $file2 = fopen("vids_alt.txt","w") or die("Error al abrir el fichero vids_alt.txt");
                $directorio2 = './Videos_alt/'; 
                function ordenar2($a2,$b2){ 
                    global $directorio2; 
                    $a2 = filemtime($directorio2.$a2); 
                    $b2 = filemtime($directorio2.$b2); 
                    if ($a2 == $b2) { 
                        return 0; 
                    } 
                    return ($a2 < $b2) ? -1 : 1; 
                } 
                $dir2=opendir($directorio2); 
                while($arch2=readdir($dir2)) $ars2[] = $arch2; 
                closedir($dir2); 
                usort($ars2, "ordenar2");
                ?>
                <form action="borrar.php" method="post" enctype="multipart/form-data">
                <?php
                foreach($ars2 as $ar2) {
                    if(!is_dir($ar2)) {
                        echo "<input class='check' name='archivo[]' type='checkbox' value='"."$directorio2$ar2"."'>"."<a href='"."$directorio2$ar2"."'>"."$ar2"."</a><br>";
                        fputs($file2, $ar2."\n");
                    }
                }
                ?>
                <input type="submit" name='button' value="Borrar">
                </form>
                <?php
                fclose($file2);
            ?>
        </div>
    </div>
  </body>
</html>
