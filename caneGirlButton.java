import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * A custom JLabel class representing a button with an image of a cane girl,
 * which can be clicked and trigger events.
 */
public class caneGirlButton extends JLabel implements MouseListener{

  int caneGirlWidth;
  int caneGirlHeight;
  ImageIcon caneIcon;
  public static boolean clicked;

  /**
   * Constructs a CaneGirlButton with default width and height.
   */
  public caneGirlButton(){
    caneGirlWidth = 0;
    caneGirlHeight = 0;
  }

  /**
   * Constructs a CaneGirlButton with specified width and height.
   * @param width The width of the button.
   * @param height The height of the button.
   */
  public caneGirlButton(int width, int height){
    caneGirlWidth = width;
    caneGirlHeight = height;
    caneIcon = new ImageIcon(getClass().getResource("CaneGirl.png"));
    setIcon(reSizeImage(caneIcon, caneGirlWidth, caneGirlHeight));
    addMouseListener(this);
  }

  /**
   * Resizes the given ImageIcon to the specified width and height.
   * @param image The ImageIcon to be resized.
   * @param width The target width of the resized image.
   * @param height The target height of the resized image.
   * @return The resized ImageIcon.
   */
  public ImageIcon reSizeImage(ImageIcon image, int width, int height)
  {
    Image tempImage = image.getImage();
    Image tempSizeImage = tempImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
    return new ImageIcon(tempSizeImage);
  }

  public boolean getClicked(){
    return clicked;
  }


  @Override
  public void mouseClicked(MouseEvent e) {
      // TODO Auto-generated method stub
      clicked = true;

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