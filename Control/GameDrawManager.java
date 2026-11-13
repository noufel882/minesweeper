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
    private JButton[][] buttons;
    
    public GameDrawManager(int boardCellsCount){
        this.boardCellsCount = boardCellsCount;
        buttons = new JButton[boardCellsCount][boardCellsCount];
        for (int i = 0; i < buttons.length; i++) {            
            buttons[i][i] = new JButton();              
        }
    }

    private void initframe(String title ,int width , int height){
        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void initPanel(){
        panel = new JPanel(new GridLayout(boardCellsCount ,boardCellsCount));
        frame.add(panel);
    }
    
    private void initButtons(){
  
        for (int i = 0; i < boardCellsCount; i++) {
            for (int j = 0; j < buttons.length; j++) {                                
                panel.add(buttons[i][j]);     
            }
        }
    }
    
    public void drawGameWindow(String title ,int width , int height){
        SwingUtilities.invokeLater(() -> {
            initframe(title,width,height);
            initPanel();
            initButtons();
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