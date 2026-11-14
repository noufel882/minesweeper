package Control;
import java.util.Map;
import javax.swing.ImageIcon;


public class ImageManager {
    public final static Map<String, ImageIcon> IMAGES = Map.ofEntries(
        Map.entry("1", new ImageIcon(ImageManager.class.getResource("/Resources/Images/01.png"))),
        Map.entry("2", new ImageIcon(ImageManager.class.getResource("/Resources/Images/02.png"))),
        Map.entry("3", new ImageIcon(ImageManager.class.getResource("/Resources/Images/03.png"))),
        Map.entry("4", new ImageIcon(ImageManager.class.getResource("/Resources/Images/04.png"))),
        Map.entry("5", new ImageIcon(ImageManager.class.getResource("/Resources/Images/05.png"))),
        Map.entry("6", new ImageIcon(ImageManager.class.getResource("/Resources/Images/06.png"))),
        Map.entry("7", new ImageIcon(ImageManager.class.getResource("/Resources/Images/07.png"))),
        Map.entry("8", new ImageIcon(ImageManager.class.getResource("/Resources/Images/08.png"))),
        Map.entry("flag", new ImageIcon(ImageManager.class.getResource("/Resources/Images/flag.png"))),
        Map.entry("mine", new ImageIcon(ImageManager.class.getResource("/Resources/Images/mine.png"))),
        Map.entry("blank", new ImageIcon(ImageManager.class.getResource("/Resources/Images/blank.png")))
);

    

}