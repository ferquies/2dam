#Reproducción de audio

1. Guardar el fichero (mp3, ogg, wav, etc.) en /res/raw
2. Crear el objeto reproductor:

`MediaPlayer rep = MediaPlayer.create(this, R.raw.file);`

###Metodos:

`rep.start();` --> Inicia la reproducción

`rep.release();` --> Liberar recurso

`rep.pause();` --> Parar la reproducción

`rep.getCurrentPosition();` --> Devuelve el punto actual

`rep.seekTo(position);` --> Busca un punto de reproducción

`rep.setLooping(boolean);` --> Reproducción en bucle

`rep.getDuration();` --> Obtiene la duración

`rep.isLooping();` --> Obtiene si esta o no en bucle

`rep.isPlaying();` --> Obtiene si se esta reproduciendo

`rep.selectTrack(int);` --> Cambia el fichero

`rep.setVolume(float Izq, float Der);` --> Cambia el volúmen
