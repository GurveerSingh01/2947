
import java.util.ArrayList;
import java.util.Random;

public class GamePlay
{
    CircularDoublyLinkedList <Player> players;
    Deck gameDeck;
    Card lastCard;

    public GamePlay() 
    {
        players = new CircularDoublyLinkedList<>();
        gameDeck = new Deck();
        lastCard = new Card();
    }

    public void buildDeck()
    {
        gameDeck.buildCards();
        gameDeck.shuffle();
    }
    
    public void addPlayersToList()
    {
        Player p1 = new Player("Nala");
        Player p2 = new Player("Simba");
        Player p3 = new Player("Kion");
        Player p4 = new Player("Kiara");

        players.addFirst(p1);
        players.addLast(p2);
        players.addLast(p3);  
        players.addLast(p4);
    }

    public void startingCards()
    {
        for (int i=1; i <=7; i++) 
        {          
            for(int j=1;j<=players.size();j++)
            {
                Player p = players.first();
                p.addCard(gameDeck.deal());
                players.rotate();
            }
        }
        
        do
        {
            lastCard = gameDeck.deal();
        }
        while(lastCard.getFaceVal() == Card.Face.WILD);     
    }

    public void gameSimulation()
    {
        buildDeck();
        addPlayersToList();
        System.out.println("Total Cards in Deck: "+ gameDeck.size());
        startingCards();
        System.out.println("\nLet's play UNO!!!\n");
        System.out.println("Players and hands:\n" + players);
        System.out.println("First card: "+ lastCard +"\n");
        gamePlay();
        System.out.println("\nTotal Cards in Deck: "+ gameDeck.size());
    }

    public void  playTurn(Player playing, Card playedCard)
    {   
        System.out.println(playing.getPlayerName()+" plays "+ playedCard +"\n");
        if(playedCard.getFaceVal() == lastCard.getFaceVal())  
            {
            specialCards(playedCard);
            }        
    }

    public void specialCards(Card playedCard)
    { 
        switch(playedCard.getFaceVal())
            {
            case Card.Face.SKIP:
                {
                    players.rotate();
                    System.out.println(players.first().getPlayerName() + " misses a turn\n");           
                }
                break;
            case Card.Face.REVERSE:
                {
                    System.out.println("Game reverses direction\n");
                    players.reverse();
                }
                break;
            case Card.Face.WILD:
                {   
                   wildCard();
                }
                break;
            }
    }

    public void wildCard()
    {
        Random rand = new Random();
        int randomIntColour = rand.nextInt(4);
        String color = "";
        switch (randomIntColour) 
            {
                case 0: color="RED";
                break;
                case 1: color="YELLOW";
                break;
                case 2: color="BLUE";
                break;
                case 3: color="GREEN";   
                break;
            }
        System.out.println("Color is now " + color + "\n");
        lastCard.setColour(color);
        lastCard.setFace("WILD"); //set last card face to WILD to use for next player
        //next players cards will only be checked for color matching
    }

    public void playWild( Player playing, Card card)
    {
        System.out.println(playing.getPlayerName()+" plays "+ card);
        wildCard();                 //method to choose color for lastCard
    }
    
    public Card lastCardWasWild(Card card)   // need to look at
    {
        Card afterWild  = null;
        if((card.getColour() == lastCard.getColour()))
                {
                    afterWild = card;
                }
                return afterWild;
    }    

    public Card noPlaysDrawCard(Player playing)
    {
        Card drawCard = gameDeck.deal();  //new card from deck
        playing.addCard(drawCard);         //add draw card to hand
        System.out.println(playing.getPlayerName()+" has no play, draws "+ drawCard);
        return drawCard;
    }

    public void gamePlay()
    {
        Player playing = players.first();
        ArrayList <Card> pHand = playing.getHand();
        Card wildCard = new Card(5,12);
    
        while(pHand.size()!=0 && gameDeck.size()>0)
        {
            System.out.println(playing);

            boolean cardFound = false;
            Card playedCard = null;
            for (Card card : pHand)     // check card match
            {    
                if(cardFound==false)  // to exit ignore consequtive card if match found (cardFound == true)  
                {
                    if(lastCard.getFaceVal() == Card.Face.WILD)    //if last card was Wild, check only color for new one         /** need to look at ,wild card var different from actuall wild*/
                    {
                        playedCard = lastCardWasWild(card);
                        if(playedCard!=null)
                        {
                        cardFound=true;
                        }
                    }
                    else if((card.getColour() == lastCard.getColour()) || card.getFaceVal() == lastCard.getFaceVal())
                    {
                        playedCard = card;
                        cardFound=true;
                    }
                }
            }

            if(cardFound==true) //if card normally found
            {
                lastCard = playedCard;                     //update lastCard
                playTurn(playing,playedCard);
                playing.playCard(playedCard);
            }
            else                                         // if normal card not found
            {  
                for (Card card : pHand)                  //loop to check for wild card
                    { 
                        if(card.getFaceVal()== Card.Face.WILD)      //if wild found store in playedCard to play 
                        {
                        cardFound=true;                         //to ignore second if statement if cardFound is true;
                        playedCard = card;
                        playWild(playing, playedCard);
                        }
                    }

                if(cardFound==false) // draw card if normal card and WILD not found 
                    {
                        Card drawCard = noPlaysDrawCard(playing);

                        if((drawCard.getColour() == lastCard.getColour()) || drawCard.getFaceVal() == lastCard.getFaceVal())    //check if drawn card is same to lastCard
                            {
                            cardFound=true;   
                            playedCard = drawCard;                           //store in playedCard to play later in the method
                            playTurn(playing,drawCard);                        
                            lastCard = playedCard;                                                      //update lastCard
                            }

                        else if(drawCard.getFaceVal()== Card.Face.WILD) // if last card is WILD play always (as no other card can be played)
                            {
                                cardFound=true;                 //to skip steps if card found
                                playedCard = drawCard;
                                playWild(playing, playedCard);
                            }

                        else
                        {
                            System.out.println(playing.getPlayerName()+" can't play it\n"); //card cant be played, still in hand
                        }
                    }

                if(cardFound==true) //play the plable cards - wild found in deck or new drawn card 
                    {
                        playing.playCard(playedCard); // if a playable WILD card or drawn card is found
                    }
            }

            if( pHand.size() == 1) //UNO yell condition
            {
                System.out.println(playing.getPlayerName() + " yells UNO!\n");  
            }

            if(pHand.isEmpty())  // Win condition for the current (head) player (THe player that makes the while loop stop)
            {
                System.out.println(playing.getPlayerName() + " wins!");
                break;
            }

            deckEmptyGameEnd();
            
            players.rotate(); //change tail so head points to next player
            playing = players.first(); // first player - current turn
            pHand = playing.getHand(); // head players hand
        }
    }
    
    public void deckEmptyGameEnd()
    {
        if(gameDeck.size()==0)
            {
                System.out.println("NO WINNER, NO CARDS IN DECK");
            }
            
    }
}

