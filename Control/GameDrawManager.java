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

    private void createGamePanel(){   
        if(panel == null){
            panel = new JPanel(); 
        }
        panel.setLayout(new GridLayout(GameConfig.BOARD_WIDTH ,GameConfig.BOARD_WIDTH,1,1));        
    }
    
    public void createCells(){
        panel.removeAll();
        drawnCells= new VisualCell[GameConfig.BOARD_WIDTH][GameConfig.BOARD_WIDTH]; 
        for (int i = 0; i < GameConfig.BOARD_WIDTH; i++) {
            for (int j = 0; j < GameConfig.BOARD_WIDTH; j++) {
                drawnCells[i][j] = new VisualCell();
                panel.add(drawnCells[i][j]);
            }
        }
    }
    
    public void draw(){  
        if(GameConfig.BOARD_WIDTH <= 0)
            throw new IllegalArgumentException("cells count should be a positive interger and non-equal to zero !");
        try{
            
            SwingUtilities.invokeAndWait(() -> {  
                createGameWindow();   
                createGamePanel();
                createCells();
                frame.add(panel);
                frame.setTitle(GameConfig.WINDOW_TITLE);
                frame.setSize(GameConfig.WINDOW_FRAME_WIDTH,GameConfig.WINDOW_FRAME_HEIGHT);
                frame.setVisible(true);
            });      
            
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
     
    public void displayWinScreen(){
        JOptionPane.showMessageDialog(null, "You win !", "Win", JOptionPane.INFORMATION_MESSAGE);
    } 

    public void displayLoseScreen(){
        JOptionPane.showMessageDialog(null, "You lose !", "lose", JOptionPane.INFORMATION_MESSAGE);
    } 

}