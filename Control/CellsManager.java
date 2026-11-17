package Control;

import java.awt.Point;
import java.util.Random;
import Configration.GameConfig;
import Control.VisualCell.Status;

public class CellsManager {
    private final static Random randomLocation = new Random();  
      
    public static void mineCells(VisualCell[][] boardCells , int minesCount){      
        int i , j ;
        
        while(minesCount != 0){
            i = randomLocation.nextInt(0,GameConfig.BOARD_WIDTH);
            j = randomLocation.nextInt(0,GameConfig.BOARD_WIDTH);

            if(!boardCells[i][j].hasMine()){
                boardCells[i][j].mineCell();
                CellsManager.updateAdjacentCells(boardCells,new Point(i,j));
                minesCount--;
            }
            
        }
    }
     
    public static void updateAdjacentCells(VisualCell[][] boardCells , Point cellPos){     
        for (Point adjacentPosition : CellsManager.getCellAdjacents(boardCells,cellPos) ) {
            if(adjacentPosition != null)
                boardCells[adjacentPosition.x][adjacentPosition.y].increaseMines();            
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

    public static boolean isPositionInBound(VisualCell[][] boardCells ,Point cellPos){       
        int i = cellPos.x , j = cellPos.y;
        return 
            (i >= 0 && i < boardCells.length)
            &&
            (j >= 0 && j < boardCells[i].length)
            ;
    }
    
    public static Point[] getCellAdjacents (VisualCell[][] boardCells  ,Point cellPos){
        Point[] adjacentsCellsLocation = new Point[8];
        int index = 0;
        int i = cellPos.x , j = cellPos.y;
        for (int row = i-1; row <= i+1; row++) {
            for (int col = j-1; col <= j+1; col++){
                if(row == i && col == j)continue;

                if(isPositionInBound(boardCells , new Point(row ,col)))
                    adjacentsCellsLocation[index++]= new Point(row,col);
            }
        }
        return adjacentsCellsLocation;
    }   
   
    public static int revealEmptyAdjacentCells(VisualCell[][] boardCells ,Point cellPos){
        int revealedCells = 0;
        //1 Revealing the currentCell if not flagged or not revealed and it hasn't a mine
        var currentCell = boardCells[cellPos.x][cellPos.y];
        var cellStatus = currentCell.cellStatus();
        if( cellStatus == Status.Flaged || cellStatus == Status.Revealed ||currentCell.hasMine())
            return revealedCells;
        
        //Revealing the current cells 
        currentCell.reveal();
        revealedCells++;

        
        //2 -> Get adjacents cells for current cell .
        var cellAdjacencyList = getCellAdjacents(boardCells,cellPos);
        

        //if the count of adjacent mines is NOT equal to zero we break the execution.
        if(currentCell.adjacentMines() != 0)return revealedCells;

        // if the count of adjacent mines is  equal to zero repeat the same proccess for each adjacents cell .
        else
        {
            for (Point cellPosition : cellAdjacencyList) {
                if(cellPosition != null)
                    revealedCells += revealEmptyAdjacentCells(boardCells , cellPosition);
            }
        }
        return revealedCells;
    }


}