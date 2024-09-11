import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;



public class HowToScreen extends JLabel 
{
    ImageIcon htsIcon;
    int htsHeight;
    int htsWidth;

    /**
     * Constructs a new HowToScreen with default dimensions.
     * The default height and width are set to 0.
     */
    public HowToScreen()
    {
      htsHeight = 0;
      htsWidth = 0;
    }

    /**
     * Constructs a new HowToScreen with specified dimensions.
     *
     * @param width The width of the how-to screen.
     * @param height The height of the how-to screen.
     */
    public HowToScreen(int width, int height)
    {
      htsWidth = width;
      htsHeight = height;
        htsIcon = new ImageIcon(getClass().getResource("HowToPlay.png"));
      setIcon(reSizeImage(htsIcon, htsWidth, htsHeight));
    }

    /**
     * Resizes the given ImageIcon to the specified dimensions.
     *
     * @param image The ImageIcon to be resized.
     * @param width The desired width of the resized image.
     * @param height The desired height of the resized image.
     * @return The resized ImageIcon.
     */
    public ImageIcon reSizeImage(ImageIcon image, int width, int height)
    {
      Image tempImage = image.getImage();
      Image tempSizeImage = tempImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
      return new ImageIcon(tempSizeImage);
    }
}

