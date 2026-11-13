package GameModels;

public class Board {

    private final Cell[][] cells;
    private int size;
    public Board (int size){
        if(size <= 0)
            throw new IllegalArgumentException("Size must be a positive number !");
        
        this.size = size;
        this.cells = new Cell[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                this.cells[i][j] = new Cell();
            }
        }
    }

    //Cells Getter
    public Cell[][] getCells() {
        return this.cells;
    }

    //Size Getter
    public int getSize() {return this.size;}

}