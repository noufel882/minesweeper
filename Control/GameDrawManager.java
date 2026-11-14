package Control;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public final class GameDrawManager {
    
    private JFrame frame;
    private JPanel panel;
    private int boardCellsCount;
    private VisualCell[][] buttons;
    
    public VisualCell[][] Cells(){return buttons;}

    public GameDrawManager(int boardSize){
        this.boardCellsCount = boardSize;
        buttons = new VisualCell[boardSize][boardSize];
        for (int i = 0; i < buttons.length; i++) {  
            for (int j = 0; j < buttons.length; j++) {         
                buttons[i][j] = new VisualCell();              
            }          
        }
    }
 
    public void initResources(){
    
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            panel = new JPanel(new GridLayout(boardCellsCount ,boardCellsCount));
            frame.add(panel);
            
            for (int i = 0; i < boardCellsCount; i++) {
                for (int j = 0; j < boardCellsCount; j++) {                                
                    panel.add(buttons[i][j]);     
                }
            }
        });
    }

    public void drawGameWindow(String title ,int width , int height){
        SwingUtilities.invokeLater(() -> {
            frame.setTitle(title);
            frame.setSize(width,height);
            frame.setVisible(true);
        });
    }
    
    //set the unmanaged resources free
    public void close(){
        if(frame != null)
        {
            SwingUtilities.invokeLater(() -> {
                frame.dispose();       
            });
        }
    }
    
    public static void displayWinScreen(){
        JOptionPane.showMessageDialog(null, "You win !", "Win", JOptionPane.INFORMATION_MESSAGE);
    } 

    public static void displayLoseScreen(){
        JOptionPane.showMessageDialog(null, "You lose !", "lose", JOptionPane.INFORMATION_MESSAGE);
    } 

}