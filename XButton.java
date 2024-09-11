import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class XButton extends JLabel implements MouseListener
{
    int xHeight;
    int xWidth;
    ImageIcon xImage;
    boolean clicked;

    
    /**
     * XButton class represents a custom JButton with an "X" icon.
     * This button can be clicked and will notify listeners when clicked.
     */
    public XButton()
    {
        clicked = false;
        xWidth = 0;
        xHeight = 0;
    }

    /**
     * Constructor for XButton with specified width and height.
     * Loads the "XButton.png" image and sets it as the button icon.
     * Adds a mouse listener to the button.
     *
     * @param width  The width of the button.
     * @param height The height of the button.
     */
    public XButton(int width, int height)
    {
        clicked = false;
        xWidth = width;
        xHeight = height;
        xImage = new ImageIcon(getClass().getResource("XButton.png"));
        setIcon(reSizeImage(xImage, xWidth, xHeight));
        addMouseListener(this);
    }

    
    /**
     * Resize the given ImageIcon to the specified width and height.
     *
     * @param image  The ImageIcon to resize.
     * @param width  The width to resize to.
     * @param height The height to resize to.
     * @return The resized ImageIcon.
     */
    public ImageIcon reSizeImage(ImageIcon image, int width, int height)
    {
      Image tempImage = image.getImage();
      Image tempSizeImage = tempImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
      return new ImageIcon(tempSizeImage);
    }

    /**
     * Check if the button has been clicked.
     *
     * @return true if the button has been clicked, false otherwise.
     */
    public boolean isClicked()
    {
        return clicked;
    }

    public void clickedReceived()
    {
        clicked = false;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        clicked = true;
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
