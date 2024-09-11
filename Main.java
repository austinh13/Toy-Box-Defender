import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * The Main class serves as the entry point for the Miniature Mayhem: Toybox Defender game.
 * It initializes the game window and manages the transition between different screens.
 */
public class Main
{
    // size of the whole window
    public static final int multipler = 7;
    public static final int windowWidth = 114 * multipler;
    public static final int windowHeight = 100 * multipler;
    private static JFrame window;
    private static JPanel title;
    private static ToyboxDefender gamePanel;
    private static Thread thread;
  

    public static void main(String[] args) throws Exception {

    window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle("Miniature Mayhem: Toybox Defender");
    window.setSize(windowWidth,windowHeight);
    
    gamePanel = new ToyboxDefender();
    title = new TitleScreen();
    ((TitleScreen)title).startGameThread();
    window.getContentPane().add(title);

    window.setLocationRelativeTo(null);
    window.setVisible(true);
    }

    /**
     * Starts the game by transitioning from the title screen to the main game panel.
     */
    public static void startGame()
    {
      window.getContentPane().remove(title);
      window.getContentPane().add(gamePanel);
      gamePanel.startGameThread();
      window.revalidate();
      window.repaint();
    }

  /**
   * Ends the game and displays the appropriate screen based on whether the player won or lost.
   * @param wonGame A boolean indicating whether the player won the game or not.
   */

  public static void endGame(boolean wonGame, JLabel panel)
  {
    window.getContentPane().remove(gamePanel);
    gamePanel.endGameThread();
    if(wonGame)
    {
      // no win condition added
    }
    else
    {
      JPanel endGame = new JPanel();
 
      endGame.add(panel);
      window.getContentPane().add(endGame);
    }
    window.revalidate();
    window.repaint();
    
  }


    
}