package Control;

import javax.swing.SwingUtilities;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Configration.GameConfig;

public final class GameController{
    private GameDrawManager drawManager;
    private VisualCell[][] boardCells;  
    private int cellsCount ;
    private int minesCount;
    private int safeCellsCount;
    private boolean gameOver = false;

    public GameController(){
        drawManager = new GameDrawManager();
    }

    public void run(){  
        drawManager.draw();
        initializeBoardCells();
        CellsManager.mineCells(boardCells ,minesCount);
    }
    
    private void initializeBoardCells(){

        cellsCount = GameConfig.BOARD_WIDTH  * GameConfig.BOARD_WIDTH;
        minesCount = (int) Math.ceil( cellsCount * GameConfig.MINES_RATIO);
        safeCellsCount = cellsCount - minesCount;

        boardCells = drawManager.getDrawnCells();   
        for(int i = 0 ; i < boardCells.length ; i++){
            for(int j = 0 ; j < boardCells[i].length ; j++){     
                
                final int row = i;
                final int col = j;
                var cell = boardCells[row][col];
                cell.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            checkClickedCell(new Point(row,col));
                        }
                        else if (SwingUtilities.isRightMouseButton(e)) {
                            cell.toggleFlag();
                        }
                    }
                });
            }
        }
    }

    private void checkClickedCell(Point clickedCellPos){
        if(gameOver)return;
        
        VisualCell cell = boardCells[clickedCellPos.x][clickedCellPos.y];

        if (cell.cellStatus() != VisualCell.Status.Hidden)
            return;

        //if clicked on a mine 
        if(cell.hasMine()){  
            cell.reveal();
            CellsManager.revealAllMine(boardCells);
            drawManager.displayLoseScreen();
            gameOver = true;
            return;
        }
 
        //if you don't click on a mine the game continues
        safeCellsCount -= CellsManager.revealEmptyAdjacentCells(boardCells,clickedCellPos);     
        
        if(safeCellsCount == 0)
        {
            drawManager.displayWinScreen();
            gameOver = true;
        }
        
    }
    
}