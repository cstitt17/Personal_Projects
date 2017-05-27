package cards;
import java.util.ArrayList;

public class Shoe {
	ArrayList<String> cards;
	
	public Shoe(int decks)
	{
		cards = new ArrayList<String>();
		String[] suit = {"C", "D", "H", "S"};
		String[] vals = {"A", "J", "K", "Q"};
		
		for (int i=0; i<decks; i++)
			for (String s : suit)
			{
				for (String v : vals)
					cards.add(v + " " + s);
				
				for (int j = 2; j <= 10; j++)
					cards.add(j + " " + s);
			}
	}
	
	public void shuffle()
	{
		ArrayList<String> temp = new ArrayList<String>();
		
		while(cards.size() > 0)
		{
			int r = (int) (Math.random()*cards.size());
			temp.add(cards.remove(r));
		}
		
		cards = temp;
	}
	
	public ArrayList<String> getShoe() {
		return cards;
	}
}