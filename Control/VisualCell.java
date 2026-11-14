package Control;

import GameModels.Cell;
import javax.swing.JButton;

public class VisualCell extends JButton{

    public static enum Status {UnReaveled,Reaveled,Flaged,UnFlaged};

    private Status cellStatus = Status.UnReaveled;
    private Cell cell;

    public VisualCell(){
        cell= new Cell();
        setCellStatus(Status.UnFlaged);
    }

    private void setCellStatus(Status status) {
    switch (status) {

        case Flaged:
            setIcon(ImageManager.IMAGES.get("flag"));
            break;

        case UnFlaged:
            setIcon(ImageManager.IMAGES.get("blank"));
            break;

        case UnReaveled:
            setIcon(ImageManager.IMAGES.get("blank"));
            break;

        case Reaveled:
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
            }
            this.setEnabled(false);
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

    public int adjacentMines(){
        return cell.getAdjacentMines();
    }
   
    public void setAdjacentMines(int adjacentMines){
        cell.setAdjacentMines(adjacentMines);
    }

    public void mineCell(){
        cell.setMine(true);        
    }

    public void ToggleFlag(){
        if(cellStatus == Status.Flaged)
            setCellStatus(Status.UnFlaged);

        else if(cellStatus == Status.UnFlaged)
            setCellStatus(Status.Flaged);
    }

    public void Reavel(){
        if(cellStatus == Status.Flaged || cellStatus == Status.Reaveled)return;
        setCellStatus(Status.Reaveled);
    }

}