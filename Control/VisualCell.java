package Control;

import GameModels.Cell;
import javax.swing.JButton;


public class VisualCell extends JButton{

    public static enum Status {Hidden,Revealed,Flaged};
    private Status cellStatus = Status.Hidden;
    private Cell cell;

    public VisualCell(){
        cell= new Cell();
        setCellStatus(Status.Hidden);     
    }

    private void setCellStatus(Status status) {
    switch (status) {
        case Flaged:
            setIcon(ImageManager.IMAGES.get("flag"));
            break;

        case Hidden:
            setIcon(ImageManager.IMAGES.get("blank"));
            break;

        case Revealed:
            if (cell.hasMine()) {
                setIcon(ImageManager.IMAGES.get("mine"));
            }
            else if (cell.getAdjacentMines() > 0) {
                setIcon(ImageManager.IMAGES.get(
                    String.valueOf(cell.getAdjacentMines())
                ));
            }
            else {
                setIcon(ImageManager.IMAGES.get("blank"));
                this.setEnabled(false);
            }         
            break;
    }

    cellStatus = status;
}

    public Status cellStatus(){
        return cellStatus;
    }

    public boolean hasMine(){
        return cell.hasMine();
    }

    private int adjacentMines(){
        return cell.getAdjacentMines();
    }

    public void increaseMines(){
        cell.setAdjacentMines(cell.getAdjacentMines()+1);
    }
   
    public void setAdjacentMines(int adjacentMines){
        cell.setAdjacentMines(adjacentMines);
    }

    public void mineCell(){
        cell.setMine(true);       
    }

    public void toggleFlag(){
        if(cellStatus == Status.Flaged)
            setCellStatus(Status.Hidden);

        else if(cellStatus == Status.Hidden)
            setCellStatus(Status.Flaged);
    }

    public void reveal(){
        if(cellStatus == Status.Hidden)
            setCellStatus(Status.Revealed);       
    }

    public void clear(){
        setCellStatus(Status.Hidden);
        cell.clear();
    }

}