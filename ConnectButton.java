import javafx.scene.control.Button;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * buttons that will be used in the GUI
 * @author vijay
 */
public class ConnectButton extends Button {
    
    /**
     * row of the button
     */
     private int row;
    /**
     * column of the button
     */
    private int column;
    
    /**
     * Default constructor
     * @param label label of the button
     * @param row row that the button is on
     * @param column column that the button is on
     */
    public ConnectButton(String label, int row, int column) {
        Button button = new Button(label);
        this.row = row;
        this.column = column;
    }
    /**
     * determines the row of the button
     * @return integer value of the row
     */
    public int getRow() {
        return this.row;
    }
    /**
     * determines the column of the button
     * @return integer value of the row
     */
    public int getColumn() {
        return this.column;
    }
    /**
     * string representation of the button 
     * @return string of the row and column the button is located
     */
    public String toString() {
        return "(" + this.row + "," + this.column + ")";
    }
}
