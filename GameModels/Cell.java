package GameModels;

public class Cell {
    private boolean hasMine;
    private boolean isRevealed;
    private boolean isFlagged;
    private int    adjacentMines;

    public Cell(){
        this.hasMine     = false;
        this.isFlagged = false;
        this.isRevealed = false;
        this.adjacentMines = 0;
    }

    public Cell(boolean hasMine, boolean isFlagged, boolean isRevealed, int adjacentMines){
        this.hasMine     = hasMine;
        this.isFlagged = isFlagged;
        this.isRevealed = isRevealed;
        this.adjacentMines = adjacentMines;
    }
    
    // hasMine Getter & Setter
    public boolean hasMine() {
        return this.hasMine;
    }

    public void setMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    // isRevealed Getter & Setter
    public boolean isRevealed() {
        return this.isRevealed;
    }

    public void setRevealed(boolean isRevealed) {
        this.isRevealed = isRevealed;
    }

    // isFlagged Getter & Setter
    public boolean isFlagged() {
        return this.isFlagged;
    }

    public void setFlagged(boolean isFlagged) {
        this.isFlagged = isFlagged;
    }

    // adjacentMines Getter & Setter
    public int getAdjacentMines() {
        return this.adjacentMines;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }


    public void clear(){
        this.hasMine     = false;
        this.isFlagged = false;
        this.isRevealed = false;
        this.adjacentMines = 0;
    }
}