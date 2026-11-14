import Configration.GameConfig;
import Control.GameController;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        GameController game = new GameController();
        Scanner sc = new Scanner(System.in);

        while(GameConfig.BOARD_WIDTH <= 0){
            System.out.println("Enter Board width : ");
            GameConfig.BOARD_WIDTH = sc.nextInt();
        }

        game.run(GameConfig.BOARD_WIDTH);            


        sc.close();
        game.close();
    }
}