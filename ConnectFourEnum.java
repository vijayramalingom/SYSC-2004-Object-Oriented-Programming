/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *enum for connect four
 * @author vijay
 */
public enum ConnectFourEnum {
    IN_PROGRESS ("Game in Progress"), RED ("Red"), BLACK ("Black"), DRAW ("It's a draw!"), EMPTY(" ");
    
    private String value;
    
    ConnectFourEnum( String value) {
        this.value = value;
    }
    
    public String enumToString (ConnectFourEnum name) {
        if (name == IN_PROGRESS)
            return "Game in Progress";
        if (name == RED)
            return "Red";
        if (name == BLACK)
            return "Black";
        if (name == DRAW)
            return "It's a draw!";
        else
            return " ";
    }
}