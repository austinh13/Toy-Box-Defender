
public class Tile    
{
  public Boolean placeable;
  public String tileType;
  public int range;
  private int x;
  private int y;
  private long time;

  /**
     * Constructs a new Tile object with default values.
     * By default, the tile is placeable.
     */
  public Tile(){
    placeable = true;
  }

  /**
     * Constructs a new Tile object with specified parameters.
     *
     * @param place Indicates whether the tile is placeable.
     * @param type The type of the tile.
     * @param xC The x-coordinate position of the tile.
     * @param yC The y-coordinate position of the tile.
     */
  public Tile(boolean place, String type, int xC, int yC)
  {
    time = System.currentTimeMillis();
    x = xC;
    y = yC;
    placeable = place;
    tileType = type;
    if(tileType.equals("Hoody.png"))
    {
      range = 140;
    }
    else if(tileType.equals("BuzzLightweek.png"))
    {
      range = 210;
    }
    else if(tileType.equals("CaneGirl.png"))
    {
      range = 100;
    }
  }

  /**
   * Gets the time at which the tile was created or modified.
   *
   * @return The time in milliseconds.
   */
  public long getTime()
  {
    return time;
  }

  /**
   * Sets the time at which the tile was created or modified.
   *
   * @param t The time to set, in milliseconds.
   */
  public void setTime(long t)
  {
    time = t;
  }

  /**
   * Gets the x-coordinate position of the tile.
   *
   * @return The x-coordinate position.
   */
  public int getX()
  {
    return x;
  }

  /**
   * Gets the y-coordinate position of the tile.
   *
   * @return The y-coordinate position.
   */
  public int getY()
  {
    return y; 
  }
  
  /**
     * Gets the type of the tile.
     *
     * @return The tile type.
     */
  public String getType()
  {
    return tileType; 
  }


   /**
     * Checks if the tile is placeable.
     *
     * @return True if the tile is placeable, false otherwise.
     */
  public boolean isPlaceAble()
  {
    return placeable;
  }

  /**
   * Gets the range of the tile.
   *
   * @return The range value.
   */
  public int getRange()
  {
    return range; 
  }

  /**
   * Constructs a new Tile object with specified placeability.
   *
   * @param isPlaceable Indicates whether the tile is placeable.
   */
  public Tile(Boolean isPlaceable){
    placeable = isPlaceable;
  }


 
}