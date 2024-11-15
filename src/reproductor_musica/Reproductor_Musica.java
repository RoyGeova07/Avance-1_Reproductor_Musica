/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reproductor_musica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * s
 *
 * @author royum
 */
public class Reproductor_Musica extends Application {

    private static Stage stage;

    @Override //funcion por default de javafx
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Scene escena = new Scene(new VentanaPrincipal(), 600, 500);
        stage.setScene(escena);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);

    }

    public static Stage getStage() {

        return stage;

    }

}
