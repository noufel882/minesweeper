package Control;

import java.awt.Point;
import java.util.Random;
import Configration.GameConfig;
import Control.VisualCell.Status;

/** Provides board-wide operations for mine placement and cell revealing. */
public class CellsManager {
    private final static Random randomLocation = new Random();  
      
    /**
     * Randomly places mines in the board and updates adjacent-mine counts.
     *
     * @param boardCells board to modify
     * @param minesCount number of unique mines to place
     */
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
     
    /**
     * Increases the adjacent-mine count of every valid neighbor of a mine.
     *
     * @param boardCells board containing the mine
     * @param cellPos position of the mine
     */
    public static void updateAdjacentCells(VisualCell[][] boardCells , Point cellPos){     
        for (Point adjacentPosition : CellsManager.getCellAdjacents(boardCells,cellPos) ) {
            if(adjacentPosition != null)
                boardCells[adjacentPosition.x][adjacentPosition.y].increaseMines();            
        }      
    }
 
    /**
     * Reveals every mined cell in the board.
     *
     * @param boardCells board to update
     */
    public static void revealAllMine(VisualCell[][] boardCells ){
        for (VisualCell[] row : boardCells) {
            for (VisualCell cell : row) {
                if(cell.hasMine())
                    cell.reveal();
            }
        }
    }

    /**
     * Checks whether a point identifies an existing board cell.
     *
     * @param boardCells board used to establish bounds
     * @param cellPos point whose row and column will be checked
     * @return {@code true} if both coordinates are within the board
     */
    public static boolean isPositionInBound(VisualCell[][] boardCells ,Point cellPos){       
        int i = cellPos.x , j = cellPos.y;
        return 
            (i >= 0 && i < boardCells.length)
            &&
            (j >= 0 && j < boardCells[i].length)
            ;
    }
    
    /**
     * Gets all valid neighboring positions, including diagonal neighbors.
     *
     * @param boardCells board used to establish bounds
     * @param cellPos center-cell position
     * @return array of up to eight neighboring points; unused entries are {@code null}
     */
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
   
    /**
     * Reveals a safe cell and recursively reveals safe adjacent cells with no adjacent mines.
     * Flagged, previously revealed, and mined cells are not revealed.
     *
     * @param boardCells board to update
     * @param cellPos position of the cell to reveal
     * @return number of newly revealed cells
     */
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