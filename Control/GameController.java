package Control;


public final class GameController{
    private GameDrawManager drawManager;

    private boolean runForFirstTime = true;

    public GameController(int boardSize){
        drawManager = new GameDrawManager(boardSize);
    }

    public void run(){        
        if(runForFirstTime){
            drawManager.initResources();
            runForFirstTime = false;
        }  
        drawManager.drawGameWindow("Minesweeper", 500, 500);
    }



    public void close(){drawManager.close();}
}