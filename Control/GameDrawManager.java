package Control;

import Configration.GameConfig;

import java.awt.GridLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public final class GameDrawManager{
    
    private JFrame frame;
    private JPanel panel;
    private VisualCell[][] drawnCells;
    
    
    public VisualCell[][] getDrawnCells(){
        return drawnCells;
    }

    private void createGameWindow(){
        if(frame == null){
            frame = new JFrame();
            frame.setLocation(0,0);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    private void createPanel(int boardWidth){   
        if(panel == null){
            panel = new JPanel(); 
        }
        panel.setLayout(new GridLayout(boardWidth ,boardWidth,1,1));        
    }
    
    public void createCells(int boardWidth){
        panel.removeAll();
        drawnCells= new VisualCell[boardWidth][boardWidth]; 
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardWidth; j++) {
                drawnCells[i][j] = new VisualCell();
                panel.add(drawnCells[i][j]);
            }
        }
    }
    
    public void draw(int boardWidth){  
        if(boardWidth <= 0)
            throw new IllegalArgumentException("cells count should be a positive interger and non-equal to zero !");
        try{
            
            SwingUtilities.invokeAndWait(() -> {  
                createGameWindow();   
                createPanel(boardWidth);
                createCells(boardWidth);
                frame.add(panel);
                frame.setTitle(GameConfig.TITLE);
                frame.setSize(GameConfig.FRAME_WIDTH,GameConfig.FRAME_HEIGHT);
                frame.setVisible(true);
            });      
            
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
     
    public static void displayWinScreen(){
        JOptionPane.showMessageDialog(null, "You win !", "Win", JOptionPane.INFORMATION_MESSAGE);
    } 

    public static void displayLoseScreen(){
        JOptionPane.showMessageDialog(null, "You lose !", "lose", JOptionPane.INFORMATION_MESSAGE);
    } 

}