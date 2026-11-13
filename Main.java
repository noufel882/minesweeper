import Control.GameDrawManager;

public class Main {
    public static void main(String[] args) {
        GameDrawManager dManager = new GameDrawManager(8);

        dManager.drawGameWindow("title", 500,500);
        
        dManager.close();
    }
}