import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * WoodyButton class represents a custom button with Woody's icon that can be clicked.
 * It extends JLabel and implements MouseListener interface to handle mouse events.
 */
public class WoodyButton extends JLabel implements MouseListener{

  int woodyWidth;
  int woodyHeight;
  ImageIcon woodyIcon;
  public static boolean clicked;

  /**
   * Default constructor for WoodyButton.
   * Initializes woodyWidth and woodyHeight to 1.
   */
  public WoodyButton(){
    woodyWidth = 1;
    woodyHeight = 1;
  }

  /**
     * Constructor for WoodyButton with specified width and height.
     * Initializes woodyWidth, woodyHeight, and sets the icon.
     * Also adds the MouseListener to handle mouse events.
     * 
     * @param width The width of the button
     * @param height The height of the button
     */

  public WoodyButton(int width, int height){
    woodyWidth = width;
    woodyHeight = height;
    woodyIcon = new ImageIcon(getClass().getResource("Hoody.png"));
    setIcon(reSizeImage(woodyIcon, woodyWidth, woodyHeight));
    addMouseListener(this);
  }

  /**
   * Resizes the given image to the specified width and height.
   * 
   * @param image The ImageIcon to be resized
   * @param width The width to resize to
   * @param height The height to resize to
   * @return The resized ImageIcon
   */
  public ImageIcon reSizeImage(ImageIcon image, int width, int height)
  {
    Image tempImage = image.getImage();
    Image tempSizeImage = tempImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
    return new ImageIcon(tempSizeImage);
  }

  /**
   * Gets the current state of the button (clicked or not).
   * 
   * @return True if the button is clicked, false otherwise
   */
  public boolean getClicked(){
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