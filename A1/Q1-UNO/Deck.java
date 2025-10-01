import java.util.ArrayList;
import java.util.Collections;
public class Deck
{
    ArrayList<Card> deck; 

    public Deck()
     {
        deck= new ArrayList<>();
    }

    
    public void buildCards()
    {
        for(int a=1;a<=2;a++)
        {
            for (int i = 1; i <=4; i++) 
            {        
                for (int j = 0; j <=11 ; j++) 
                {
                    Card c = new Card(i,j);
                    deck.add(c);
                }
            }
        }
        for(int k=1;k<=4;k++)
        {
            deck.add(new Card(5,12));
        }
    }

    public void shuffle()
    {
        Collections.shuffle(deck);
    }
    public Card deal()
    {
      return deck.remove(0);
    }
    public int size()
    {
        return deck.size();
    }

    public ArrayList<Card> getDeck()
    {
        return deck;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Total Cards in Deck: ").append(size());
        return sb.toString();
    }
}