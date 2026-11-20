package Control;

import GameModels.Cell;
import javax.swing.JButton;


/** Swing button that represents both the visual state and model state of one board cell. */
public class VisualCell extends JButton{

    /** Possible states of a visual board cell. */
    public static enum Status {Hidden,Revealed,Flaged};
    private Status cellStatus = Status.Hidden;
    private Cell cell;

    /** Creates a hidden cell with no mine and no adjacent mines. */
    public VisualCell(){
        cell= new Cell();
        setCellStatus(Status.Hidden);     
    }

    /**
     * Updates the cell status and matching button icon.
     *
     * @param status new visual state to display
     */
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

    /**
     * Gets the current visual state.
     *
     * @return hidden, revealed, or flagged status
     */
    public Status cellStatus(){
        return cellStatus;
    }

    /**
     * Checks whether the underlying cell contains a mine.
     *
     * @return {@code true} when this cell contains a mine
     */
    public boolean hasMine(){
        return cell.hasMine();
    }

    /**
     * Gets the number of adjacent mines.
     *
     * @return adjacent-mine count
     */
    public int adjacentMines(){
        return cell.getAdjacentMines();
    }

    /** Increments the displayed cell's adjacent-mine count. */
    public void increaseMines(){
        cell.setAdjacentMines(adjacentMines()+1);
    }
   
    /**
     * Sets the number of adjacent mines.
     *
     * @param adjacentMines adjacent-mine count
     */
    public void setAdjacentMines(int adjacentMines){
        cell.setAdjacentMines(adjacentMines);
    }

    /** Places a mine in the underlying cell. */
    public void mineCell(){
        cell.setMine(true);       
    }

    /** Toggles this hidden cell between hidden and flagged states. */
    public void toggleFlag(){
        if(cellStatus == Status.Flaged)
            setCellStatus(Status.Hidden);

        else if(cellStatus == Status.Hidden)
            setCellStatus(Status.Flaged);
    }

    /** Reveals the cell if it is currently hidden. */
    public void reveal(){
        if(cellStatus == Status.Hidden)
            setCellStatus(Status.Revealed);       
    }

    /** Clears both the mine state and visual state of this cell. */
    public void clear(){
        setCellStatus(Status.Hidden);
        cell.clear();
    }

}