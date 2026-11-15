package Control;

import java.util.Random;

import Configration.GameConfig;

public final class GameController{
    private GameDrawManager drawManager;
    private VisualCell[][] boardCells;
    private Random randomLocation;    

    public GameController(){
        drawManager = new GameDrawManager();
        randomLocation = new Random();
    }

    public void run(int boardSize){
        drawManager.draw(boardSize);
        initializeBoardCells();
        MineCells(boardSize);
    }
    
    private void initializeBoardCells(){
        boardCells = drawManager.getDrawnCells();   
        for (VisualCell[] row : boardCells) {
            for (VisualCell cell : row) {
                cell.addActionListener((e) -> checkGameLoss(cell));
            }
        }
    }

    private void MineCells(int boardSize){
        int minesCount = (int) Math.ceil(boardSize * boardSize * GameConfig.MINES_RATIO);
        int i , j;
        while(minesCount != 0){
            i = randomLocation.nextInt(0,boardSize);
            j = randomLocation.nextInt(0,boardSize);
            
            if(!boardCells[i][j].hasMine()){
                boardCells[i][j].mineCell();
                updateAdjacentCells(i ,j);
                minesCount--;
            }
            
        }
    }
    
    private void updateAdjacentCells(int i , int j){
        
        //Top Left
        if(i-1 >= 0 && j-1 >= 0){
            boardCells[i-1][j-1].increaseMines();
        }
        //Left
        if(j-1 >= 0){
            boardCells[i][j-1].increaseMines();
        }
        //Bottom left
        if(i+1 < boardCells.length && j-1 >= 0){
            boardCells[i+1][j-1].increaseMines();
        }
        //Top
        if(i-1 >= 0){
            boardCells[i-1][j].increaseMines();
        }
        //Bottom
        if(i+1 < boardCells.length){
            boardCells[i+1][j].increaseMines();            
        }
        //Top right 
        if(i-1 >= 0 && j+1 < boardCells.length){
            boardCells[i-1][j+1].increaseMines();
        }
        //Right
        if(j+1 < boardCells.length){
            boardCells[i][j+1].increaseMines();            
        }
        //Bottom Right
        if(i+1 < boardCells.length && j+1 < boardCells.length){
            boardCells[i+1][j+1].increaseMines();            
        }
    }
 
    private void checkGameLoss(VisualCell cell){
        if(cell.hasMine() && cell.cellStatus() != VisualCell.Status.Flaged ){
            revealAllMine();
            drawManager.displayLoseScreen();
        }
    }
   
    private void revealAllMine(){
        for (VisualCell[] row : boardCells) {
            for (VisualCell cell : row) {
                if(cell.hasMine())
                    cell.reveal();
            }
        }
    }

}