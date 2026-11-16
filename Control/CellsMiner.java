package Control;

import java.util.Random;

import Configration.GameConfig;

public class CellsMiner {
    private final static Random randomLocation = new Random();  
    

    
    public static void mineCells(VisualCell[][] boardCells , int minesCount){      
        int i , j ;
        
        while(minesCount != 0){
            i = randomLocation.nextInt(0,GameConfig.BOARD_WIDTH);
            j = randomLocation.nextInt(0,GameConfig.BOARD_WIDTH);

            if(!boardCells[i][j].hasMine()){
                boardCells[i][j].mineCell();
                updateAdjacentCells(i ,j);
                minesCount--;
            }
            
        }
    }
     
    private void updateAdjacentCells(int i , int j){
        
        for (VisualCell adjacent : getCellAdjacents(i ,j) ) {
            if(adjacent != null)
                adjacent.increaseMines();
        }
        
    }
 
    public static void revealAllMine(VisualCell[][] boardCells ){
        for (VisualCell[] row : boardCells) {
            for (VisualCell cell : row) {
                if(cell.hasMine())
                    cell.reveal();
            }
        }
    }

    public static VisualCell[] getCellAdjacents (VisualCell[][] boardCells  ,int i , int j){
        VisualCell[] adjacents = new VisualCell[8];
        //Top Left
        if(i-1 >= 0 && j-1 >= 0){
            adjacents[0] = boardCells[i-1][j-1];
        }
        //Left
        if(j-1 >= 0){
            adjacents[1] =boardCells[i][j-1];
        }
        //Bottom left
        if(i+1 < boardCells.length && j-1 >= 0){
            adjacents[2] = boardCells[i+1][j-1];
        }
        //Top
        if(i-1 >= 0){
            adjacents[3] = boardCells[i-1][j];
        }
        //Bottom
        if(i+1 < boardCells.length){
            adjacents[4] = boardCells[i+1][j];            
        }
        //Top right 
        if(i-1 >= 0 && j+1 < boardCells.length){
            adjacents[5] = boardCells[i-1][j+1];
        }
        //Right
        if(j+1 < boardCells.length){
            adjacents[6] = boardCells[i][j+1];            
        }
        //Bottom Right
        if(i+1 < boardCells.length && j+1 < boardCells.length){
            adjacents[7] = boardCells[i+1][j+1];            
        }
        return adjacents;
    }   


}
