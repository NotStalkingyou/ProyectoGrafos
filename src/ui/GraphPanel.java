/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

/**
 * Panel personalizado para dibujar un grafo simple.
 * Permite agregar nodos (personas) y aristas (relaciones) y los dibuja en pantalla.
 */
public class GraphPanel extends JPanel {
    private final Map<String, int[]> vertices;  // Mapa para almacenar las posiciones de los nodos
    private final Map<String, String[]> edges;  // Mapa para almacenar las relaciones (aristas) entre nodos

    /**
     * Constructor. Inicializa las estructuras de datos para nodos y aristas.
     */
    public GraphPanel() {
        this.vertices = new HashMap<>();
        this.edges = new HashMap<>();
    }

    /**
     * Agrega un nodo (persona) al grafo en una posición aleatoria.
     * @param name Nombre de la persona/nodo
     */
    public void addVertex(String name) {
        if (!vertices.containsKey(name)) {
            int x = (int) (Math.random() * (getWidth() > 0 ? getWidth() - 60 : 500));
            int y = (int) (Math.random() * (getHeight() > 0 ? getHeight() - 60 : 300));
            vertices.put(name, new int[] {x + 30, y + 30});
            repaint();
        }
    }

    /**
     * Agrega una arista (relación) entre dos personas/nodos existentes.
     * @param person1 Nombre de la primera persona
     * @param person2 Nombre de la segunda persona
     */
    public void addEdge(String person1, String person2) {
        if (vertices.containsKey(person1) && vertices.containsKey(person2)) {
            String key = person1 + "-" + person2;
            if (!edges.containsKey(key)) {
                edges.put(key, new String[] {person1, person2});
                repaint();
            }
        }
    }

    /**
     * Dibuja los nodos y las aristas del grafo.
     * @param g Objeto Graphics para dibujar
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar las aristas
        g.setColor(Color.BLACK);
        for (String[] edge : edges.values()) {
            int[] point1 = vertices.get(edge[0]);
            int[] point2 = vertices.get(edge[1]);
            g.drawLine(point1[0], point1[1], point2[0], point2[1]);
        }

        // Dibujar los nodos (personas)
        for (Map.Entry<String, int[]> entry : vertices.entrySet()) {
            int[] point = entry.getValue();
            g.setColor(Color.RED);
            g.fillOval(point[0] - 15, point[1] - 15, 30, 30);
            g.setColor(Color.WHITE);
            g.drawString(entry.getKey(), point[0] - 15, point[1] + 5);
        }
    }
}
