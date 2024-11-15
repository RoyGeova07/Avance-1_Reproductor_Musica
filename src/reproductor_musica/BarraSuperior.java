/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductor_musica;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 *
 * @author royum
 */
public class BarraSuperior extends MenuBar { //aqui barra vacia

    private Menu menuArchivo;
    private MenuItem iAbrir, iSalir;

    public BarraSuperior() {

        menuArchivo = new Menu("Archivo");
        iAbrir = new MenuItem("Abrir");
        iSalir = new MenuItem("Salir");
        prepararListener();
        prepararMenus();

    }

    private void prepararMenus() {
        //este nos devuelve una lista de todos los items
        menuArchivo.getItems().addAll(iAbrir, iSalir);
        this.getMenus().add(menuArchivo);

    }

    private void prepararListener() {

        iAbrir.setOnAction(e -> ExploradorArchivos.SeleccionarArchivo());
        iSalir.setOnAction(e -> Reproductor_Musica.getStage().close());// aqui cerrara la ventana y terminar la ejecucion/

    }

}
