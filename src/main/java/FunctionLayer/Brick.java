/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author juanni420
 */
public class Brick {
    
    int width,length, height;
    String name;

    public Brick(int x, int y, String name) {
        this.width = x;
        this.length = y;
        this.name = name;
    }

    public Brick(int width, int length, int height, String name) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
