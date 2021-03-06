package com.webcheckers.appl;

import com.webcheckers.model.CheckersGame;
import com.webcheckers.model.Movement.PossibleMoves;


import com.webcheckers.model.Player;

/**
 * Orchestrates the turns of the players. This class oscillates between each player
 * as they make their moves.
 *
 * @author Anorwen - - - edc8230@rit.edu
 */
public class TurnAdministrator {

    // ----------
    // Attributes
    // ----------

    private final Player red;
    private final Player white;
    private PossibleMoves possibleMoves;

    // ------------
    // Constructors
    // ------------

    public TurnAdministrator(Player red, Player white, CheckersGame checkersGame) {
        this.red = red;
        this.white = white;
        this.possibleMoves = new PossibleMoves(this, checkersGame);
    }

    // -------
    // Methods
    // -------

    public Player isOver() {
        if(!possibleMoves.hasMove("red")) {
            return this.white;
        }
        if(!possibleMoves.hasMove("white")) {
            return this.red;
        }
        return null;
    }

    public boolean hasPieces(Player player) {
        if(player.equals(red)) {
            return possibleMoves.hasPiece("red");
        }
        if(player.equals(white)) {
            return possibleMoves.hasPiece("white");
        }
        return false; // Player Does not Exist
    }

    public boolean hasCapture(Player player) {
        if(player.equals(red)) {
            return possibleMoves.hasCaptureMove("red");
        }
        if(player.equals(white)) {
            return possibleMoves.hasCaptureMove("white");
        }
        return false; // Player Does not Exist
    }
}
