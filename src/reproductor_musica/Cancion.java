/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductor_musica;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

/**
 *
 * @author royum
 */
public class Cancion {
    
    private static Media archivo;
    private static MediaPlayer reproductor;
    private String Titulo,Artista,Album,RutaArchivo;
    private String Duracion;
    
    public Cancion(Media archivo){
        Cancion.archivo=archivo;
        reproductor=new MediaPlayer(archivo);
        BarraTiempo.setCancion(reproductor);//llamamos aqui la cancion con su barra tiempo, para que se mueva cuando la musica se reprodusca
        reproductor.setOnReady(()->{    //aqui se usa una llave por que son varias instrucciones, norecibe parametros
            Titulo=(String) archivo.getMetadata().get("title");
            Artista=(String) archivo.getMetadata().get("artist");
            Album=(String) archivo.getMetadata().get("album");
            RutaArchivo= archivo.getSource();// Esto devuelve la URL del archivo de medios
            
           int duracionSegundos = (int) archivo.getDuration().toSeconds();
            int minutos = duracionSegundos / 60;
            int segundos = duracionSegundos % 60;
            Duracion = String.format("%02d:%02d", minutos, segundos);
            //System.out.println("Titulo: "+Titulo+"\n"+"Album: "+Album+"\n"+"Artista: "+Artista+"\n"+"RutaArchivo: "+RutaArchivo+"\n"+"Duracion: "+Duracion);
            Image caratula=(Image)archivo.getMetadata().get("image");
            InfoCancion.ActualizarInformacion(Titulo, Artista, Album, caratula);
            
        });
        reproductor.setOnEndOfMedia(() ->reproductor.stop());//este hace que despues que pare la musica, cuando le vuelva a dar play ponga de nuevo la musica 
        
    }
    
    public static void Play(){
        if(archivo !=null){
          reproductor.play();   
        }
        
    }
    
    public static void pause(){
        
        if(archivo !=null&&reproductor.getStatus()==Status.PLAYING){//si esto es igual a status playing quiere decir que la cancion esta sonando la puedo pausar 
            reproductor.seek(reproductor.getCurrentTime());//seek me ayuda a forzar a que se pause la musica en el momento exacto
          reproductor.pause();
        }
        
        
    }
    
     public static void stop(){
        
        if(archivo !=null&&(reproductor.getStatus()==Status.PLAYING
                ||reproductor.getStatus()==Status.PAUSED )){//si esto es igual a status playing quiere decir que la cancion esta sonando la puedo pausar 
          reproductor.stop();
        }//
        
        
    }
     
     public static void setVolumen(double volumen){
         
         reproductor.setVolume(volumen);
         
     }
    
}
