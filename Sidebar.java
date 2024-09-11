import javax.swing.*;
import java.awt.*;

public class Sidebar extends JPanel {

	public static int moneyInt;
	public static int healthInt;
	public static int roundInt;

	public static JLabel health;
	public static JLabel money;
	public static JLabel round;
	public static JLabel buzzPrice;
	public static JLabel canePrice;
	public static JLabel woodyPrice;

	private JLabel caneGirlButton;
	private JLabel woodyButton;
	private JLabel buzzLightweekButton;
	private Color sidebarColor;
	private double buttonSize;
	final int iconSize = 48;
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 2;
	final int tileSize = originalTileSize * scale; // 48x48
	final int gridSize = 16;
	final int screenWidth = gridSize * tileSize; // 960x960 gameSize
	final int screenHeight = gridSize * tileSize;

	/**
     * Constructor for Sidebar class.
     * Initializes the default values for health, money, round, and button size.
     * Sets up the layout and appearance of the sidebar.
     */
	public Sidebar() {
		healthInt = 100;
		moneyInt = 250;
		roundInt = 1;
		buttonSize = 7;
		sidebarColor = new Color(222, 184, 135);
		this.setPreferredSize(new Dimension(80, 700));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(sidebarColor);

		round = new JLabel("R: " + roundInt);
		round.setFont(new Font("Arial", Font.PLAIN, 20));
		round.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(round);

		add(Box.createRigidArea(new Dimension(0, 10)));
		
		health = new JLabel("♥: " + healthInt);
		health.setFont(new Font("Arial", Font.PLAIN, 20));
		health.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(health);

		add(Box.createRigidArea(new Dimension(0, 10)));

		money = new JLabel("$: " + moneyInt);
		money.setFont(new Font("Arial", Font.PLAIN, 20));
		money.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(money);

		add(Box.createRigidArea(new Dimension(0, 25)));
		buzzLightweekButton = new buzzLightWeekButton(((int) buttonSize * Main.multipler),((int) buttonSize * Main.multipler));
		buzzLightweekButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(buzzLightweekButton);
			add(Box.createRigidArea(new Dimension(0, 10)));

		buzzPrice = new JLabel("$300");
		buzzPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
		buzzPrice.setFont(new Font("Arial", Font.PLAIN, 25));
		add(buzzPrice);
		add(Box.createRigidArea(new Dimension(0, 25)));

		caneGirlButton = new caneGirlButton(((int) buttonSize * Main.multipler), ((int) buttonSize * Main.multipler));
			caneGirlButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(caneGirlButton);
			add(Box.createRigidArea(new Dimension(0, 10)));


		canePrice = new JLabel("$200");
		canePrice.setAlignmentX(Component.CENTER_ALIGNMENT);
		canePrice.setFont(new Font("SANS_SERIF", Font.PLAIN, 25));
		add(canePrice);
		add(Box.createRigidArea(new Dimension(0, 25)));

		woodyButton = new WoodyButton(((int) buttonSize * Main.multipler),((int) buttonSize * Main.multipler));
		woodyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(woodyButton);
		add(Box.createRigidArea(new Dimension(0, 10)));

		woodyPrice = new JLabel("$100");
		woodyPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
		woodyPrice.setFont(new Font("SANS_SERIF", Font.PLAIN, 25));
		add(woodyPrice);
	}

/**
     * Updates the player's health by the specified amount.
     * @param healthChange The amount by which the health is changed.
     */
	public static void changeHealth(int healthChange)
		{
		healthInt -= healthChange;
		health.setText("♥: " + healthInt);
		//System.out.println("Changed Health");
		}

	/**
     * Updates the player's money by the specified amount.
     * @param moneyChange The amount by which the money is changed.
     */
	public static void changeMoney(int moneyChange)
	{
		moneyInt += moneyChange;
		money.setText("$: " + moneyInt);
	}

	/**
     * Changes the color of the price label for a specific item.
     * @param buttonType The type of item whose price label is to be changed.
     * @param c The color to set for the price label.
     */
	public static void changePriceColor(String buttonType, Color c) {
		switch(buttonType) {
			case "Woody": woodyPrice.setForeground(c); break;
			case "Buzz": buzzPrice.setForeground(c); break;
			case "Cane": canePrice.setForeground(c); break;
		}
	}

	/**
     * Increases the round number by one and updates the display.
     */
	public static void increaseRound() {
		roundInt++;
		round.setText("R:" + roundInt);
	}
 
}



