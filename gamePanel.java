import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Image;
import java.util.List;
import java.util.Queue;
import java.awt.Color;
import javax.swing.ImageIcon;


/**
 * This class represents the game panel where the game elements are displayed and interacted with.
 * It extends JPanel and implements MouseListener for mouse interaction.
 */
public class gamePanel extends JPanel implements  MouseListener
{
    JLabel img;
    boolean buttonClicked;
    String currentIcon;
    Graphics graph;
    EnemyQueue eQeuue;
    long lastSpawnTime;
    long bulletLastSpawned;
    long roundTimer;
    long spawnTimer;
    double enemyMultipler;
    int cost;
    private List<Enemy> enemies = new ArrayList<>();
    private List<Bullet> bullets = new ArrayList<>();

    /**
     * Constructs a new game panel with default settings.
     */
    public gamePanel()
    {
        spawnTimer = 2500;
        roundTimer = System.currentTimeMillis();
        enemyMultipler = 1;
        cost = 0;
        lastSpawnTime = System.currentTimeMillis();
        bulletLastSpawned = System.currentTimeMillis();
        eQeuue = new EnemyQueue();
        currentIcon = null;
        this.setPreferredSize(new Dimension(700, 700));

        addMouseListener(this);
        setLayout(new FlowLayout());
    }

    /**
    * Resizes the given ImageIcon to the specified width and height.
    *
    * @param image The ImageIcon to be resized.
    * @param width The desired width of the resized image.
    * @param height The desired height of the resized image.
    * @return A new ImageIcon with the specified dimensions.
    */
    public ImageIcon reSizeImage(ImageIcon image, int width, int height)
    {
        Image tempImage = image.getImage();
        Image tempSizeImage = tempImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(tempSizeImage);
    }

    /**
    * Handles the click event of the game buttons.
    *
    * @param icon The icon of the clicked button.
    */
    public void buttonClicked(String icon)
    {
        currentIcon = icon;
        buttonClicked = true;
        if(currentIcon.equals("BuzzLightweek.png"))
        {
            cost = -300;
            if(Math.abs(cost) <= Sidebar.moneyInt) {
                Sidebar.changePriceColor("Buzz", Color.GREEN);
                
            }
            Sidebar.changePriceColor("Cane", Color.BLACK);
            Sidebar.changePriceColor("Woody", Color.BLACK);
        }
        else if(currentIcon.equals("CaneGirl.png"))
        {
            cost = -200;
            if(Math.abs(cost) <= Sidebar.moneyInt) {
                
                Sidebar.changePriceColor("Cane", Color.GREEN);
                
            }
            Sidebar.changePriceColor("Buzz", Color.BLACK);
            Sidebar.changePriceColor("Woody", Color.BLACK);
        }
        else if(currentIcon.equals("Hoody.png"))
        {
            cost = -100;
            if(Math.abs(cost) <= Sidebar.moneyInt) {
                
                Sidebar.changePriceColor("Woody", Color.GREEN);
            }
            Sidebar.changePriceColor("Buzz", Color.BLACK);
            Sidebar.changePriceColor("Cane", Color.BLACK);
        }
    }

    /**
    * Overrides the paintComponent method to draw graphics on the panel.
    *
    * @param g The Graphics object used for drawing.
    */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call superclass method to ensure proper painting

        // Draw the map image
        ImageIcon mapIcon = new ImageIcon(getClass().getResource("TempMap.png"));
        Image mapImage = mapIcon.getImage();

        Graphics2D g2d = (Graphics2D) g;
        if(mapImage != null){
            g2d.drawImage(mapImage, 0, 0, this);
        }

        drawEnemies(g);
        drawBullets(g);

        // Custom drawing code for icons
        // Use the Graphics object (g) provided by Swing to draw on the panel
        // Size of buzz is 63 x 66
        for (int row = 0; row <= 700; row += 70) {
            for (int col = 0; col <= 700; col += 70) {
                if (gameMap.map.get(row, col) != null) {
                    Tile temp = gameMap.map.get(row, col);
                    if (temp.isPlaceAble()) {
                        ImageIcon icon = new ImageIcon(getClass().getResource(temp.getType()));
                        Image img = icon.getImage();
                        g.drawImage(img,row,col,null);
                        spawnBullets(row, col, temp);
                    }
                }
            }
        }

    }

    /**
    * Updates the game state, including spawning enemies, moving them, and managing rounds.
    */
    public void updateGame()
        {
            spawnEnemies();
            moveEnemies();
            moveBullets();
            roundTimer();
        }

    /**
    * Checks if it's time to increase the round, adjusts enemy spawn rate and difficulty accordingly.
    */
    private void roundTimer()
    {
        if(System.currentTimeMillis() - roundTimer >= 25000)
        {
            if(Sidebar.roundInt <= 10)
            {
            Sidebar.increaseRound();
            enemyMultipler += 1;
            
                if(Sidebar.roundInt == 4)
                {
                    spawnTimer = 2250;
                }
            }
            else if(Sidebar.roundInt <= 20)
            {
                Sidebar.increaseRound();
                enemyMultipler += 1.5;
                if(Sidebar.roundInt == 10)
                {
                    spawnTimer = 1750;
                }
            }
            roundTimer = System.currentTimeMillis();
        }
    }

    /**
    * Spawns enemies based on the current time and enemy queue.
    */
    private void spawnEnemies() {
        if (System.currentTimeMillis() - lastSpawnTime >= spawnTimer) 
        {
            Queue<String> tempQueue = eQeuue.getEnemyQueue();
            if(!tempQueue.isEmpty())
            {
                String temp = tempQueue.remove();
            if(temp.equals("MonsterTruck.png"))
            {
                enemies.add(new Enemy(temp,0,0,1,10));
            }
            else if(temp.equals("ArmyMan.png"))
            {
                enemies.add(new Enemy(temp, 0, 0, 2,5));
            }
            else if(temp.equals("Biker.png"))
            {
                enemies.add(new Enemy(temp, 0, 0, 4, 5));
            }

            lastSpawnTime = System.currentTimeMillis();
            }
        }
    }

    /**
    * Moves enemies on the game screen according to a predefined path.
    */
    private void moveEnemies() {
        Iterator<Enemy> iter = enemies.iterator();
            while (iter.hasNext()) {
                Enemy enemy = iter.next();
                if(enemy.getX() < 280)
                {
                    enemy.moveRight(); // Move right
                }
                else if(enemy.getY() <= 420)
                {
                    enemy.moveDown();
                }
                else if(enemy.getX() <= 700)
                {
                    enemy.moveRight();
                }
                else
                {
                    Sidebar.changeHealth(enemy.getDamage());
                    iter.remove();
                if(Sidebar.healthInt < 0)
                {
                    JLabel temp = new JLabel();
                    temp.setIcon(new ImageIcon(getClass().getResource("GameOver.png")));
                    Main.endGame(false,temp);
                }
            }
        }
    }

    /**
    * Draws the enemies on the game panel.
    *
    * @param g The Graphics object used for drawing.
    */
    private void drawEnemies(Graphics g)
    {
        for(Enemy temp: enemies)
        {
            ImageIcon icon = new ImageIcon(getClass().getResource(temp.getType()));
            Image img = icon.getImage();
            g.drawImage(img,temp.getX(),temp.getY(),null);
        }
    }



    /**
     * Spawns bullets from towers to attack enemies within range.
    *
    * @param x The x-coordinate of the tower.
    * @param y The y-coordinate of the tower.
    * @param temp The Tile representing the tower.
    */
    private void spawnBullets(int x, int y, Tile temp)
    {
    long currentTime = System.currentTimeMillis();
    int towerRange = temp.getRange();
    int xTemp = temp.getX();
    int yTemp = temp.getY();
    int timeToShoot = 1000;

    switch(temp.getType()) 
        {
        case "Hoody.png": timeToShoot = 1000; break;
        case "BuzzLightweek.png": timeToShoot = 1500; break;
        case "CaneGirl.png": timeToShoot = 400; break;
        }

    for(Enemy enemy: enemies)
        {
        if(currentTime - temp.getTime() >= timeToShoot)
            {
                if (Math.abs(enemy.getX() - x) <= towerRange && Math.abs(enemy.getY() - y) <= towerRange) 
                {
                    bullets.add(new Bullet(xTemp,yTemp, enemy.getX() + 50,enemy.getY() + 50, temp.getType(), enemy));
                    temp.setTime(currentTime);
                }
            }
        }
    }

    /**
    * Moves the bullets on the game panel.
    * Also deals with deleting bullets and giving money if they kill enemey or get to end of path
    */
    private void moveBullets() {
        Iterator<Bullet> iter = bullets.iterator();
        while (iter.hasNext()) {

            Bullet bullet = iter.next();
            int xDistance = (int) Math.abs(bullet.getX() - bullet.getTx());
            int yDistance = (int) Math.abs(bullet.getY() - bullet.getTy());
            if((xDistance > 10) || (yDistance > 10))
            {
                int tX = bullet.getTx();
                int tY = bullet.getTy();
                float deltaX = (float) (tX - bullet.getX());
                float deltaY = (float) (tY - bullet.getY());
                float angle = (float) Math.atan2(deltaY, deltaX);
                int speed = 10;
                switch(bullet.getType()) {
                    case "CaneGirl.png": speed = 20; break;
                    case "BuzzLightweek.png": speed = 5; break;
                }
                
                bullet.changeX(speed * Math.cos(angle));
                bullet.changeY(speed * Math.sin(angle));
                //System.out.println("Moving Bullets");
            }
            else
            {
                int damage = 10;
                //System.out.println("BULLET TYPE" + bullet.getType());
                switch(bullet.getType()) {
                    case "Hoody.png": damage = -8; break;
                    case "BuzzLightweek.png": damage = -15; break;
                    case "CaneGirl.png": damage = -6; break;
                }
                iter.remove();
                Enemy temp = bullet.getEnemy();
                temp.changeHealth(damage);
                if(temp.getHealth() <= 0)
                {
                    if(enemies.contains(temp))
                    {
                        if(temp.getType().equals("ArmyMan.png"))
                        {
                            Sidebar.changeMoney(25);
                        }
                        else if(temp.getType().equals("MonsterTruck.png"))
                        {
                            Sidebar.changeMoney(65);
                        }
                        else if (temp.getType().equals("Biker.png")) {
                            Sidebar.changeMoney(40);
                        }
                    }
                    enemies.remove(temp);
                }
            }
        }
    }

    /**
    * Draws the bullets on the game panel, draws bullet type based on tower.
    *
    * @param g The Graphics object used for drawing.
    */
    private void drawBullets(Graphics g)
    {
        for(Bullet temp: bullets)
        {
            int tempX = (int)temp.getX();
            int tempY = (int)temp.getY();
            if(temp.getType().equals("Hoody.png"))
            {
            g.setColor(Color.GRAY);
            g.fillRect(tempX,tempY, 25, 25);
            }
            else if (temp.getType().equals("CaneGirl.png"))
            {
            ImageIcon icon = new ImageIcon(getClass().getResource("CaneProjectile.png"));
            Image img = icon.getImage();
            g.drawImage(img,tempX,tempY,null);
            }
            else 
            {
                g.setColor(Color.RED);
                g.fillRect(tempX,tempY, 35, 35);
            }
        }
    }

    /**
    * Handles the mouse click event, checks if a button was clicked for a tower.
    * If button was clicked and whever mouse was clicked has a open tile place the tower in that grid.
    * The grid is based of 10x10 tiles that are 70 pixels each, rounds to the nearest 70 to place.
    *
    * @param e The MouseEvent object containing information about the event.
    */
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("gameScreen clicked");
        int x = e.getX();
        int y = e.getY();
        int rowX = (int)Math.floor(x / 70.0f) * 70;
        int rowY = (int)Math.floor(y / 70.0f) * 70;
        if(gameMap.isPlaceAble(rowX,rowY) && buttonClicked && (Math.abs(cost) <= Sidebar.moneyInt))
        {
            System.out.println("X: " + x + " Y: " + y);
            System.out.println("RoundedX: " + rowX + "Rounded Y: " + rowY);
            //System.out.println("game Screen clicked inside of placeable and button clicked");
            gameMap.map.put(rowX, rowY, new Tile(true,currentIcon, rowX, rowY));
            System.out.println(gameMap.map.get(rowX, rowY).getType());
            if(currentIcon.equals("BuzzLightweek.png"))
            {
                Sidebar.changeMoney(-300);
                Sidebar.changePriceColor("Buzz", Color.black);
            }
            else if(currentIcon.equals("CaneGirl.png"))
            {
                Sidebar.changeMoney(-200);
                Sidebar.changePriceColor("Cane", Color.black);
            }
            else if(currentIcon.equals("Hoody.png"))
            {
                Sidebar.changeMoney(-100);
                Sidebar.changePriceColor("Woody", Color.black);
            }
            currentIcon = null;
            buttonClicked = false;
        }


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

    /**
    * Represents a bullet fired by towers to attack enemies.
    */
    class Bullet
    {
        double x;
        double y;
        int targetX;
        int targetY;
        String type;
        Enemy target;

        /**
        * Constructs a new Bullet object.
        *
        * @param xC      The initial X coordinate of the bullet.
        * @param yC      The initial Y coordinate of the bullet.
        * @param tX      The X coordinate of the target enemy.
        * @param tY      The Y coordinate of the target enemy.
        * @param t       The type of the bullet.
        * @param enemy   The enemy targeted by the bullet.
        */
        public Bullet(double xC, double yC, int tX, int tY, String t, Enemy enemy)
        {
            x = xC;
            y = yC;
            targetX = tX;
            targetY = tY;
            type = t;
            target = enemy;
        }

        /**
        * Gets the enemy targeted by the bullet.
        *
        * @return The enemy targeted by the bullet.
        */
        public Enemy getEnemy() {
            return target;
        }

        /**
        * Gets the type of the bullet.
        *
        * @return The type of the bullet.
        */
        public String getType() {
            return type;
        }

        /**
        * Updates the X coordinate of the bullet.
        *
        * @param num The amount to change the X coordinate by.
        */
        public void changeX(double num) {
            x += num;
        }

        /**
        * Updates the Y coordinate of the bullet.
        *
        * @param num The amount to change the Y coordinate by.
        */
        public void changeY(double num) {
            y += num;
        }

        /**
        * Gets the current X coordinate of the bullet.
        *
        * @return The current X coordinate of the bullet.
        */
        public double getX() {
            return x;
        }

        /**
        * Gets the current Y coordinate of the bullet.
        *
        * @return The current Y coordinate of the bullet.
        */
        public double getY() {
            return y;
        }

        /**
        * Gets the X coordinate of the target enemy.
        *
        * @return The X coordinate of the target enemy.
        */
        public int getTx() {
            return targetX;
        }

        /**
        * Gets the Y coordinate of the target enemy.
        *
        * @return The Y coordinate of the target enemy.
        */
        public int getTy() {
            return targetY;
        }
    }

    /**
    * Represents an enemy in the game.
    */
    class Enemy
    {
        private int x;
        private int y;
        private int speed;
        private int damage;
        private String enemyType;
        private int health;

    /**
    * Constructs a new Enemy object.
    *
    * @param type The type of the enemy.
    * @param xC   The initial X coordinate of the enemy.
    * @param yC   The initial Y coordinate of the enemy.
    * @param s    The speed of the enemy.
    * @param dmg  The damage inflicted by the enemy.
    */
    public Enemy(String type, int xC, int yC, int s, int dmg) {
        enemyType = type;
        x = xC;
        y = yC;
        speed = s;
        damage = dmg;
        if (type.equals("ArmyMan.png")) {
            health = 15;
        } else if (type.equals("MonsterTruck.png")) {
            health = 30;
        } else if (type.equals("Biker.png")) {
            health = 10;
        }
        health = (int) (health * enemyMultipler); 
    }

    /**
     * Updates the health of the enemy.
     *
     * @param h The amount to change the health by.
     */
    public void changeHealth(int h) {
        health += h;
    }

    /**
     * Gets the current health of the enemy.
     *
     * @return The current health of the enemy.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets the type of the enemy.
     *
     * @return The type of the enemy.
     */
    public String getType() {
        return enemyType;
    }

    /**
     * Gets the current X coordinate of the enemy.
     *
     * @return The current X coordinate of the enemy.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the current Y coordinate of the enemy.
     *
     * @return The current Y coordinate of the enemy.
     */
    public int getY() {
        return y;
    }

    /**
     * Moves the enemy to the right.
     */
    public void moveRight() {
        x += speed;
    }

    /**
     * Moves the enemy downwards.
     */
    public void moveDown() {
        y += speed;
    }

    /**
     * Gets the damage inflicted by the enemy.
     *
     * @return The damage inflicted by the enemy.
     */
    public int getDamage() {
        return damage;
    }

    }
}