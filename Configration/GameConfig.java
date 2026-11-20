package Configration;

/** Central configuration values used to build and run the Minesweeper window and board. */
public class GameConfig {

    /** Title displayed in the game window. */
    public static String WINDOW_TITLE = "Minesweeper";

    /** Width of the game window in pixels. */
    public static int WINDOW_FRAME_WIDTH = 680;

    /** Height of the game window in pixels. */
    public static int WINDOW_FRAME_HEIGHT = 650;

    /** Number of rows and columns in the square game board. */
    public static int BOARD_WIDTH = 22;

    /**
     * Fraction of board cells that contain mines.
     * The value must be from {@code 0} to {@code 1}; for example,
     * {@code 0.15} selects approximately 15 mines for a 100-cell board.
     */
    public static final double MINES_RATIO = 0.15f;
}