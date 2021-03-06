package com.webcheckers.model;

/**
 * Created by yoits on 10/15/2017.
 */
public class Piece {

    // ----------
    // Attributes
    // ----------

    private String color;
    private String type;

    // ------------
    // Constructors
    // ------------

    public Piece(String color, String type){
        this.color = color;
        this.type = type;
    }

    // -------
    // Methods
    // -------

    /*
    Returns the piece's type
     */
    public String getType(){
        return type;
    }

    /*
    Returns the piece's color
     */
    public String getColor(){
        return color;
    }

    /*
    Sets the type of the piece to king
     */
    public void setKing()
    {
        this.type = "king";
    }
}
