package Configration;

public class GameConfig {
      
    public static String WINDOW_TITLE = "Minesweeper";
    //Width and height of the game's window 
    public static int WINDOW_FRAME_WIDTH = 680;
    public static int WINDOW_FRAME_HEIGHT = 650;

    //Set board width 22 (22 x 22) as default 
    public static int BOARD_WIDTH = 22;
    //A rational value from 0 to 1 
    // represents the dansity of mines from the total board cells
    // Example :MINES_RATIO = 0.15 , 100 cells
    //  =>  100 * MINES_RATIO = 15 mines
    // note :
    // -> lower values of MINES_RATIO ==> game harder 
    // -> lower values of MINES_RATIO ==> game easear
    public static final double MINES_RATIO = 0.15f;
}