import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * A custom JButton class representing a button with Buzz Lightyear image.
 * This class extends JLabel and implements MouseListener interface.
 */
public class buzzLightWeekButton extends JLabel implements MouseListener
  {
      
    /** The icon for Buzz Lightyear image. */
    private ImageIcon buzzIcon;
    
    /** The width of the button. */
    private int buzzWidth;
    
    /** The height of the button. */
    private int buzzHeight;
    
    /** A boolean indicating whether the button is clicked. */
    public static boolean clicked;
    
    /**
    * Constructs a BuzzLightWeekButton with default width and height.
    */
    public buzzLightWeekButton()
    {
      clicked = false;
      buzzWidth = 0;
      buzzHeight = 0;
      addMouseListener(this);
    }

    /**
    * Constructs a BuzzLightWeekButton with specified width and height.
    *
    * @param width  the width of the button
    * @param height the height of the button
    */
    public buzzLightWeekButton(int width, int height)
    {
      clicked = false;
      buzzWidth = width;
      buzzHeight = height;
      buzzIcon = new ImageIcon(getClass().getResource("BuzzLightweek.png"));
      
      setIcon(reSizeImage(buzzIcon, buzzWidth, buzzHeight));
      addMouseListener(this);
    }

    /**
    * Resizes the given ImageIcon to the specified width and height.
    *
    * @param image  the ImageIcon to be resized
    * @param width  the width to resize to
    * @param height the height to resize to
    * @return a resized ImageIcon
    */
    public ImageIcon reSizeImage(ImageIcon image, int width, int height)
    {
      Image tempImage = image.getImage();
      Image tempSizeImage = tempImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
      return new ImageIcon(tempSizeImage);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        clicked = true;
        //System.out.println("Button Clicked");
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