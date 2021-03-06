import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Players implements Iterable<Player>, Iterator<Player> {

    private final ArrayList<Player> players = new ArrayList<>();
    private int currentPlayerIndex;
    private Iterator<Player> iterator;

    public void add(Player player) {
        players.add(player);
    }

    public boolean contains(String name) {
        for (Player player : players) {
            if (player.hasName(name)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return players.size();
    }

    public Player get(int index) {
        return players.get(index);
    }

   public void setCurrentPlayer(String name) {
    	
    	
    	
        currentPlayerIndex = 0;
        while (players.get(currentPlayerIndex).hasName(name)) {
            currentPlayerIndex++;
        }
    


    }
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void turnOver() {
        if (currentPlayerIndex < players.size()-1) {
            currentPlayerIndex++;
        } else {
            currentPlayerIndex = 0;
        }
    }
    public void remove(Player player) {
    	players.remove(player);
    }
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Player next() {
        return iterator.next();
    }

    @Override
    public Iterator<Player> iterator() {
        iterator = players.iterator();
        return iterator;
    }
    
    //method to sort an arraylist
 public void sort() {
	 //to sort the arraylist i had to use the collections method which will sort in ascending order
	   Collections.sort(players, new TurnComparator());
	   //so reverse the arrayList for descending order
	   Collections.reverse(players);
 }
}
