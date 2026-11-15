import Configration.GameConfig;
import Control.GameController;
public class Main {
    public static void main(String[] args){
        GameController game = new GameController();
        
        GameConfig.BOARD_WIDTH = 16; 

        game.run(GameConfig.BOARD_WIDTH);
        
    }
}