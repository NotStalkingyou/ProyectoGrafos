/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package visualizadorgrafos;

import forms.VisualizadorGrafosUI;

/**
 * Clase principal para iniciar la aplicación de visualización de grafos.
 */
public class VisualizadorGrafos {

    /**
     * Método principal. Lanza la interfaz gráfica de usuario.
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            VisualizadorGrafosUI frame = new VisualizadorGrafosUI();
            frame.setVisible(true);
        });
    }
}
