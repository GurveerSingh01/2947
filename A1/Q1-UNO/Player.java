
import java.util.ArrayList;
public class Player
{
    public String playerName;
    public ArrayList<Card> hand;

    public Player(String playerName)
    {
        this.playerName = playerName;
        hand = new ArrayList<>();
    }

    public String getPlayerName()
    {
        return playerName;
    }
    public ArrayList<Card> getHand()
    {
        return hand;
    }
    public void setPlayerName(String p)
    {
        playerName = p;
    }
    
    public Player()
    {
        this("null");
    }

    public Card playCard(Card c)
    {
        int index = hand.indexOf(c);
        return hand.remove(index);
    }

    public void addCard(Card e)
    {
        hand.add(e);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(playerName).append("'s hand: ");
        for(Card c: hand)
        {
            sb.append(c);
            if(hand.indexOf(c)!= hand.size()-1)
            {
            sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();            
    }
}