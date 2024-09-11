
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayButton extends JLabel implements MouseListener
{
    int pbWidth;
    int pbHeight;
    JLabel pb;
    ImageIcon playIcon;

    /**
     * Constructs a new PlayButton with default width and height.
     */
    public PlayButton()
    {
        playIcon = null;
        pbWidth = 0;
        pbHeight = 0;
    }

    /**
     * Constructs a new PlayButton with the specified width and height.
     * 
     * @param width The width of the play button.
     * @param height The height of the play button.
     */
    public PlayButton(int width,int height)
    {

        pbWidth = width;
        pbHeight = height;
        playIcon = new ImageIcon(getClass().getResource("PlayButton.png"));
        setIcon(reSizeImage(playIcon, pbWidth, pbHeight));
        addMouseListener(this);
    }

    /**
     * Resizes the given ImageIcon to the specified width and height.
     * 
     * @param image The ImageIcon to be resized.
     * @param width The width to resize to.
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
     * Invoked when the mouse button has been clicked (pressed and released) on this component, this button starts the game.
     * 
     * @param e The MouseEvent associated with this event.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
      Main.startGame();
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