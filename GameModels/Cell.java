package GameModels;

public class Cell {
    private boolean hasMine;
    private int adjacentMines;

    public Cell(){
        this.hasMine = false;
        this.adjacentMines = 0;
    }

    public Cell(boolean hasMine, int adjacentMines){
        this.hasMine = hasMine;
        this.adjacentMines = adjacentMines;
    }
    
    // hasMine Getter & Setter
    public boolean hasMine() {
        return this.hasMine;
    }

    public void setMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    // adjacentMines Getter & Setter
    public int getAdjacentMines() {
        return this.adjacentMines;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    public void clear(){
        this.hasMine = false;
        this.adjacentMines = 0;
    }

}