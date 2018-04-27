/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author martin
 */
public class Order {
    private int id;
    private int width;
    private int length;
    private int roofId;
    private int roofPitch;
    private int shedWidth;
    private int shedLength;
    private int userId;
    private int status;
    private String comment;
    private Boolean isConfirmed;


    public Order(int width, int length, int roofId, int roofPitch, int shedWidth, int shedLength, int userId, int status, Boolean isConfirmed, String comments) {
        this.width = width;
        this.length = length;
        this.roofId = roofId;
        this.roofPitch = roofPitch;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
        this.userId = userId;
        this.status = status;
        this.isConfirmed = isConfirmed;
        this.comment = comments;
    }
    
    public Order(int id, int width, int length, int roofId, int shedWidth, int shedLength, int userId, int status, String comment) {
        this.id = id;
        this.width = width;
        this.length = length;
        this.roofId = roofId;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
        this.userId = userId;
        this.status = status;
        this.comment = comment;
    }

    public int getRoofPitch() {
        return roofPitch;
    }

    public void setRoofPitch(int roofPitch) {
        this.roofPitch = roofPitch;
    }

    

    public Boolean getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(Boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public String getComments() {
        return comment;
    }

    public void setComments(String comments) {
        this.comment = comments;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getRoofId() {
        return roofId;
    }

    public void setRoof(int roofId) {
        this.roofId = roofId;
    }

    public int getShedWidth() {
        return shedWidth;
    }

    public void setShedWidth(int shedWidth) {
        this.shedWidth = shedWidth;
    }

    public int getShedLength() {
        return shedLength;
    }

    public void setShedLength(int shedLength) {
        this.shedLength = shedLength;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}
