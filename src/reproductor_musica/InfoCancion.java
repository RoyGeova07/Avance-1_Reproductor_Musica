/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductor_musica;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author royum
 */
public class InfoCancion extends VBox{
    
    private static Label etTitulo, etArtista,etAlbum;
    private static ImageView imagenCaratula;
    
    public InfoCancion(){
        
        etTitulo=new Label("Titulo: No disponible.");
        etArtista=new Label("Artista: No disponible.");
        etAlbum=new Label("Album: No disponible.");
        imagenCaratula=new ImageView();
        
        etTitulo.setFont(new Font(18));
        etArtista.setFont(new Font(18));
        etAlbum.setFont(new Font(18));
        
        imagenCaratula.setFitWidth(150);
        imagenCaratula.setFitHeight(150);
        
        imagenCaratula.setPreserveRatio(true);//conserve el ratio de aspecto de la imagen
        
        setAlignment(Pos.CENTER);
        setPadding(new Insets(20));
        this.setSpacing(10);
        
        getChildren().addAll(imagenCaratula,etTitulo,etArtista,etAlbum);
        
    }
    
    //funcion qur cuando elijamso una cancion los datos cambien
    public static void ActualizarInformacion(String titulo,String artista,String album, Image caratula){
        
        //si no tiene metada datos saldra el mensaje no disponible
        etTitulo.setText("Titulo: "+(titulo !=null ? titulo: "No disponible"));
        etArtista.setText("Artista: "+(titulo !=null ? artista: "No disponible"));
        etAlbum.setText("Album: "+(titulo !=null ? album: "No disponible"));
        
        // si la musica no tiene imagen, se le pone una por defecto
        imagenCaratula.setImage(caratula !=null ? caratula : new Image("img/block.png"));
        
    }
    
    
}
