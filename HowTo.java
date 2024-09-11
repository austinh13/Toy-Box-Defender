
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
* A custom JLabel class representing a clickable "How To" button with an image.
*/
public class HowTo extends JLabel implements MouseListener
{
    int htWidth;
    int htHeight;
    ImageIcon htIcon;
    public boolean clicked;
    
    /**
     * Default constructor for the HowTo button.
     */
    public HowTo()
    {
        clicked = false;
        htIcon = null;
        htWidth = 0;
        htHeight = 0;
    }

    /**
     * Constructor to create a HowTo button with specified width and height.
     * @param width The width of the button
     * @param height The height of the button
     */
    public HowTo(int width,int height)
    {
        clicked = false;
        htWidth = width;
        htHeight = height;
        htIcon = new ImageIcon(getClass().getResource("HowTo.png"));
        setIcon(reSizeImage(htIcon, htWidth, htHeight));
        addMouseListener(this);
    }

    /**
     * Resizes the given ImageIcon to the specified width and height.
     * @param image The ImageIcon to be resized
     * @param width The desired width of the resized image
     * @param height The desired height of the resized image
     * @return The resized ImageIcon
     */
    public ImageIcon reSizeImage(ImageIcon image, int width, int height)
    {
      Image tempImage = image.getImage();
      Image tempSizeImage = tempImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
      return new ImageIcon(tempSizeImage);
    }
    /**
     * Returns the status of the button (whether it has been clicked or not).
     * @return True if the button has been clicked, false otherwise
     */
    public boolean getClicked()
    {
        return clicked;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        clicked = true;
        //System.out.println(getClicked());
    }

    public void clickedReceived()
    {
        clicked = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    
}