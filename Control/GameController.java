package Control;

import java.util.Random;

import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Configration.GameConfig;

public final class GameController{
    private GameDrawManager drawManager;
    private VisualCell[][] boardCells;
    private Random randomLocation;    
    private int cellsCount ;
    private int minesCount;
    private int safeCellsCount;
    private boolean gameOver = false;

    public GameController(){
        drawManager = new GameDrawManager();
        randomLocation = new Random();
    }

    public void run(){  
        drawManager.draw();
        initializeBoardCells();
        mineCells();
    }
    
    private void initializeBoardCells(){

        cellsCount = GameConfig.BOARD_WIDTH  * GameConfig.BOARD_WIDTH;
        minesCount = (int) Math.ceil( cellsCount * GameConfig.MINES_RATIO);
        safeCellsCount = cellsCount - minesCount;

        boardCells = drawManager.getDrawnCells();   
        for (VisualCell[] row : boardCells) {
            for (VisualCell cell : row) {             
                cell.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {

                        if (SwingUtilities.isLeftMouseButton(e)) {
                            checkGameLoss(cell);
                        }
                        else if (SwingUtilities.isRightMouseButton(e)) {
                            cell.toggleFlag();
                        }
                    }
                 });
            }
        }
    }

    private void mineCells(){      
        int i , j ;
        int counter = minesCount;
        while(counter != 0){
            i = randomLocation.nextInt(0,GameConfig.BOARD_WIDTH);
            j = randomLocation.nextInt(0,GameConfig.BOARD_WIDTH);

            if(!boardCells[i][j].hasMine()){
                boardCells[i][j].mineCell();
                updateAdjacentCells(i ,j);
                counter--;
            }
            
        }
    }
    
    private void updateAdjacentCells(int i , int j){
        
        for (VisualCell adjacent : getCellAdjacents(i ,j) ) {
            if(adjacent != null)
                adjacent.increaseMines();
        }
        
    }
 
    private void checkGameLoss(VisualCell cell){
        if(gameOver)return;

        if(cell.cellStatus() != VisualCell.Status.Hidden)return;

        if(cell.hasMine() && cell.cellStatus() != VisualCell.Status.Flaged ){
            revealAllMine();
            drawManager.displayLoseScreen();
            gameOver = true;
        }
        else
            checkGameWin(cell);
    }
   
    private  void checkGameWin(VisualCell cell){
        if(cell.cellStatus() == VisualCell.Status.Hidden){         
            cell.reveal();
            
            if(!cell.hasMine()){
                safeCellsCount--;    
            }
        }
        if(safeCellsCount == 0)
        {
            drawManager.displayWinScreen();
            gameOver = true;
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

    private VisualCell[] getCellAdjacents (int i , int j){
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