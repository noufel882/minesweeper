package Control;

import java.util.Random;
import javax.swing.SwingUtilities;
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
        CellsMiner.mineCells(boardCells ,minesCount);
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

    private void checkGameLoss(VisualCell cell){
        if(gameOver)return;

        if(cell.cellStatus() != VisualCell.Status.Hidden)return;

        if(cell.hasMine() && cell.cellStatus() != VisualCell.Status.Flaged ){
            CellsMiner.revealAllMine(boardCells);
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

    
}