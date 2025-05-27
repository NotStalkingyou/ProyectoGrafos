/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;
import java.awt.*;
/**
 *
 * @author salacomputocentro.ba
 */
public class Vertex {
 public int x, y;
    public String label;

    public Vertex(int x, int y, String label) {
        this.x = x;
        this.y = y;
        this.label = label;
    }

    public boolean contains(Point p) {
        return new Rectangle(x - 15, y - 15, 30, 30).contains(p);
    }
}
