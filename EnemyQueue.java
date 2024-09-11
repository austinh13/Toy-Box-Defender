import java.util.*;
import java.io.*;

/**
 * This class represents a queue of enemies read from a file. It reads enemy data from a text file,
 * creates a queue of enemies based on the data, and provides methods to access this queue.
 */
public class EnemyQueue 
{
    Queue<String> Equeue;
    InputStream enemyFile;
    
    /**
     * Constructs an EnemyQueue object by reading enemy data from a file and initializing the queue.
     */
    public EnemyQueue() 
    {
      
            enemyFile = this.getClass().getClassLoader().getResourceAsStream("EnemyFile.txt");
            Scanner input = new Scanner(enemyFile);
            Equeue = new LinkedList<String>();
            
            //TEMP ONLY
            while(input.hasNextLine()) {
                String tempLine = input.nextLine();

                String[] split = tempLine.split(" ");

                int number = Integer.parseInt(split[0]);
                String name = split[1];
                
                for(int i = 1; i <= number; i++)
                {
                    Equeue.add(name);
                }
            }
            input.close();
        
    }

    /**
     * Retrieves the queue of enemies.
     * @return The queue containing names of enemies.
     */
    public Queue<String> getEnemyQueue()
    {
        return Equeue;
    }


    
}
