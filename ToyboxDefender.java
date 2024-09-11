
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;



public class ToyboxDefender extends JPanel implements Runnable {
	// SCREEN SETTINGS
	static final int originalTileSize = 16; // 16x16 tile
	final int scale = 2;

	final int tileSize = originalTileSize * scale; // 48x48
	static final int gridSize = 20;
	final int screenWidth = gridSize * tileSize; // 960x960 gameSize
	final int screenHeight = gridSize * tileSize;
	Thread gameThread;
	gameMap map;
	Sidebar sidebar;
	gamePanel gameScreen;

	/**
     * Constructs a ToyboxDefender object.
     * Initializes the game map, sidebar, and game panel.
     */
	public ToyboxDefender() {

		map = new gameMap();
		sidebar = new Sidebar();
		gameScreen = new gamePanel();

		this.setSize(new Dimension(screenWidth, screenHeight));
		
		this.setBackground(new Color(0, 141, 80));
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		this.setLayout(new BorderLayout());

		System.out.println("ToyboxDefender panel created.");


		this.add(sidebar, BorderLayout.EAST);
    	this.add(gameScreen, BorderLayout.WEST);
  
	}

	
	


  	/**
     * Starts the game thread.
     */
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	/**
     * Ends the game thread.
     */
	public void endGameThread()
	{
		gameThread = null;
	}

	/**
     * Implements the game loop.
	 * Checks if buttons are clicked and updates all gamePanel things.
     */
	public void run() {

		while (gameThread != null) {
			
			// Figure out later: Make to where if you clicked one button you cant click the others / maybe a selecting boolean?
			if(buzzLightWeekButton.clicked)
				{
					//System.out.println("Buzz Clicked");
					gameScreen.buttonClicked("BuzzLightweek.png");
					buzzLightWeekButton.clicked = false;
				}
			else if(caneGirlButton.clicked)
				{
					gameScreen.buttonClicked("CaneGirl.png");
					caneGirlButton.clicked = false;
				}
			else if(WoodyButton.clicked)
				{
					gameScreen.buttonClicked("Hoody.png");
					WoodyButton.clicked = false;
				}
			// 1: UPDATE
			update();
			// 2: DRAW ONTO WINDOW
			repaint();
			gameScreen.revalidate();
			gameScreen.updateGame();
			gameScreen.repaint();
      sidebar.revalidate();
      sidebar.repaint();

			try {
				Thread.sleep(15);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	/**
     * Updates the game state.
     */
	public void update() {
		// update frame
	}

	/**
     * Paints the game components onto the panel.
     *
     * @param g the Graphics object to paint onto
     */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
    
	}

}
