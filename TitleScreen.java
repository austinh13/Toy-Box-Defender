
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;



public class TitleScreen extends JPanel implements Runnable
  {
    Color bgColor;
    JLabel pb;
    JLabel ht;
    JLabel hts;
    JLabel xb;
    //ImageIcon playIcon;
    double fontSize;
    int pbWidth;
    int pbHeight;
    int htWidth;
    int htHeight;
    int htsWidth;
    int htsHeight;
    int xbWidth;
    int xbHeight;
    Thread titleThread;

    /**
     * Constructor for TitleScreen class.
     * Initializes the components of the title screen and sets their initial properties.
     */
    public TitleScreen()
    {
      fontSize = 7;
      //buttons = true;
      pbHeight = 40 * Main.multipler;
      pbWidth = 40 * Main.multipler;

      htWidth = 36 * Main.multipler;
      htHeight = 36 * Main.multipler;

      htsWidth = 90 * Main.multipler;
      htsHeight = 85 * Main.multipler;

      xbWidth = 14 * Main.multipler;
      xbHeight = 14  * Main.multipler;
      //playIcon = new ImageIcon("PlayButton.png");
      bgColor = new Color(255,191,124);



      this.setBackground(bgColor);
      hts = new HowToScreen(htsWidth,htsWidth);
      ht = new HowTo(htWidth,htHeight);
      pb = new PlayButton(pbWidth,pbHeight);
      xb = new XButton(xbWidth,xbHeight);
      setLayout(null);

      pb.setBounds((Main.windowWidth / 3) - (pbWidth/2) - (Main.windowWidth/20), (Main.windowHeight / 2), pbWidth, pbHeight);
      ht.setBounds((Main.windowWidth / 2), (Main.windowHeight / 2) + (Main.windowHeight/100), htWidth, htHeight);
      hts.setBounds(Main.windowWidth / 20, (Main.windowHeight/20), htsWidth, htsHeight);
      xb.setBounds(Main.windowWidth - (Main.windowWidth/3) - (xbWidth),(Main.windowHeight / 7) - xbHeight, xbWidth, xbHeight);
      add(pb);
      add(ht);
    }


    /**
     * Overrides the paintComponent method to draw custom graphics on the panel.
     * This method renders the title of the game.
     * 
     * @param g The Graphics object used for drawing.
     */
    public void paintComponent(Graphics g)
    {
      Font font = new Font("ROMAN_BASELINE	", Font.PLAIN, ((int)fontSize * Main.multipler));
      super.paintComponent(g);
      g.setFont(font);
      g.drawString("Toy Box Defender", (Main.windowWidth / 4) - (Main.windowWidth/20), (Main.windowHeight / 2) - (Main.windowHeight/10));

    }

    /**
     * Starts the game thread responsible for updating the title screen.
     */
    public void startGameThread()
    {
        titleThread = new Thread(this);
        titleThread.start();
    }

    /**
     * The run method of the thread. It continuously checks for user interactions and updates the screen accordingly.
     */
    public void run()
    {
      while(titleThread != null)
      {

          try {
            Thread.sleep(25);
            if(((HowTo)ht).getClicked())
              {
                //System.out.println("clicked");
                ((HowTo)ht).clickedReceived();
                remove(ht);
                remove(pb);
                hts.add(xb);
                add(hts);
              }
            if(((XButton)xb).isClicked())
            {
              remove(hts);
              add(ht);
              add(pb);
              ((XButton)xb).clickedReceived();
            }
              
              revalidate();
              repaint();

          } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
          }
        }
    }

}