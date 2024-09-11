import java.util.*;

/**
 * The `gameMap` class represents a map for a game grid. It contains methods to create and manage the game map,
 * including placing tiles and checking if a specific position on the map is available.
 */
public class gameMap
  {
    static NestedHashMap map; 
    
    /**
     * Constructs a new gameMap object and initializes the map by creating the grid and adding paths.
     */
    public gameMap()
    {
      map = new NestedHashMap();
      createMap();
      addPath();
    }

    /**
     * Checks if a specific position on the map is available for placing a tile.
     *
     * @param x The x-coordinate of the position to check.
     * @param y The y-coordinate of the position to check.
     * @return True if the position is available, false otherwise.
     */
    public static boolean isPlaceAble(int x, int y)
    {
      if(map.get(x,y) == null)
      {
        return true;
      }
      return false;
    }

    /**
     * Creates the initial grid for the game map.
     */
    public void createMap()
    {
      for(int row = 0; row <= 700;row+=20)
        {
          for(int col = 0; col <=700;col+=20)
          {
            map.put(row,col,null);
          }
        }
    }

    /**
     * Adds paths to the game map at specific coordinates where towers cant be placed
     */
    public void addPath()
    {
      for(int i = 0; i < 5;i++)
        {
          map.put(i*70,0, new Tile(false,"Path", i*70, 0));
        }

      for(int i = 1; i <= 7; i++)
        {
          map.put(70*4, 70 * i,new Tile(false,"Path", 70 * 4, 70 * i));
        }

      for(int i = 1; i<10;i++)
        {
          map.put(70*4 + (i * 70), 420,new Tile(false,"Path", 70*4 + (i* 70), 420));
        }
    }

    /**
     * NestedHashMap is a nested class used to implement a two-dimensional HashMap for storing the tiles.
     */
    public class NestedHashMap {

      private Map<Integer, Map<Integer, Tile>> map;

      /**
      * Constructs a new NestedHashMap object.
      */
      public NestedHashMap() {
        map = new HashMap<Integer, Map<Integer, Tile>>();
      }

      /**
      * Retrieves the tile at the specified coordinates from the nested HashMap.
      *
      * @param i The x-coordinate of the tile.
      * @param j The y-coordinate of the tile.
      * @return The Tile object at the specified coordinates, or null if no tile is found.
      */
      public Tile get(Integer i, Integer j) {
        if (map.containsKey(i)) {
          return map.get(i).get(j);
        }
        return null;
      }

      /**
      * Inserts a tile into the nested HashMap at the specified coordinates.
      *
      * @param i The x-coordinate of the tile.
      * @param j The y-coordinate of the tile.
      * @param t The Tile object to be inserted.
      * @return The previous Tile object at the specified coordinates, or null if there was no previous mapping.
      */
      public Tile put(Integer i, Integer j, Tile t) {
        Map<Integer, Tile> tempMap;
        if (map.containsKey(i)) {
          tempMap = map.get(i);
        } else {
          tempMap = new HashMap<Integer, Tile>();
          map.put(i, tempMap);
        }

        return tempMap.put(j, t);
      }

      /**
      * Checks if the nested HashMap contains a tile at a specified coordinates.
      *
      * @param i The x-coordinate to check.
      * @param j The y-coordinate to check.
      * @return True if the coordinates are present in the nested HashMap, false otherwise.
      */
      public boolean containsKeys(Integer i, Integer j) {
        return map.containsKey(i) && (map.get(i).containsKey(j));
      }

    }
  }