package GameModels;

/** Stores the mine and adjacent-mine state of one board cell. */
public class Cell {
    private boolean hasMine;
    private int adjacentMines;

    /** Creates an empty cell with no mine and zero adjacent mines. */
    public Cell(){
        this.hasMine = false;
        this.adjacentMines = 0;
    }

    /**
     * Creates a cell with the supplied mine state and adjacent-mine count.
     *
     * @param hasMine whether this cell contains a mine
     * @param adjacentMines number of mines in adjacent cells
     */
    public Cell(boolean hasMine, int adjacentMines){
        this.hasMine = hasMine;
        this.adjacentMines = adjacentMines;
    }
    
    /**
     * Checks whether this cell contains a mine.
     *
     * @return {@code true} when this cell contains a mine
     */
    public boolean hasMine() {
        return this.hasMine;
    }

    /**
     * Sets whether this cell contains a mine.
     *
     * @param hasMine {@code true} to place a mine in this cell
     */
    public void setMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    /**
     * Gets the number of mines adjacent to this cell.
     *
     * @return adjacent-mine count
     */
    public int getAdjacentMines() {
        return this.adjacentMines;
    }

    /**
     * Sets the number of mines adjacent to this cell.
     *
     * @param adjacentMines adjacent-mine count
     */
    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    /** Resets this cell to an empty, mine-free state. */
    public void clear(){
        this.hasMine = false;
        this.adjacentMines = 0;
    }
}