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
public class OrderEntity {

    public OrderEntity(int id, int height, int length, int width, String status) {
        this.id = id;
        this.height = height;
        this.length = length;
        this.width = width;
        this.status = status;
    }

    public OrderEntity(int id, int height, int length, int width, String status, String email) {
        this.id = id;
        this.height = height;
        this.length = length;
        this.width = width;
        this.status = status;
        this.email = email;
    }

    public OrderEntity(int height, int length, int width) {
        this.height = height;
        this.length = length;
        this.width = width;
    }

    private int id, height, length, width;
    private String status, email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "OrderEntity{" + "id=" + id + ", height=" + height + ", length=" + length + ", width=" + width + ", status=" + status + ", email=" + email + '}';
    }

}
