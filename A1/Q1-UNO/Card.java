

public class Card
{
    public enum Colour
    {
        BLUE("Blue",1),GREEN("Green",2),YELLOW("Yellow",3),RED("Red",4),BLACK("Black",5);
        private String colour;
        private int colourNumber;

        private Colour(String c, int n)
        {
            colour = c;
            colourNumber = n;
        }
        private String getColour(){ return colour;}
        private int getColourNumber(){return colourNumber;}
        public String toString()
        {
            return  colour;
        }
        
        public static Colour numToColour(int n)
        {
            Colour colours[] = Colour.values();
            Colour ans = colours[n-1];
            return ans;                
        }
    }
    public enum Face
    {
        ZERO("0"),ONE("1"),TWO("2"),THREE("3"),FOUR("4"),FIVE("5"),SIX("6"),SEVEN("7"),EIGHT("8"),NINE("9"),SKIP("Skip"),REVERSE("Reverse"),WILD("Wild");
        private String faceValue;
        
        private Face(String s)
        {
            faceValue = s;
        }
        private String faceValue(){return faceValue;}
        public String toString()
        {
            return  faceValue;
        }
        public static Face numToFace(int n)
        {
            Face faces[] = Face.values();
            Face ans = faces[n];
            return ans;
        }
    }

    public Colour colourVal;
    public Face faceVal;

    public Card(int c, int f)
    {
        colourVal = Colour.numToColour(c);
        faceVal = Face.numToFace(f); 
    }
    public Card()
    {
        this(1,0);
    }

    public Face getFaceVal()
    {
        return faceVal;
    }

    public Colour getColour()
    {
        return colourVal;
    }

    public void setColour(String c)
    {
        colourVal = Colour.valueOf(c.toUpperCase());
    }
    public void setFace(String f)
    {
        faceVal = Face.valueOf(f.toUpperCase());
    }

    public boolean playable(Card c)
    {
       return (colourVal==c.colourVal || faceVal==c.faceVal);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        if(faceVal == Face.WILD)
        {
            sb.append(faceVal).append(" *");
        }
        else
        {
            sb.append(colourVal).append(" ").append(faceVal);            
        }
        return sb.toString();
    }
}