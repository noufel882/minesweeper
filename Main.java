
import Control.GameController;

/** Application entry point for the Minesweeper game. */
public class Main {
    /**
     * Creates the game controller and starts the application.
     */
    public static void main(String[] args){
        GameController game = new GameController();
        game.run();  
    }
}