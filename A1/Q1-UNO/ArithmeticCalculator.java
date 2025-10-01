public class ArithmeticCalculator
{
    public int arithmeticOperation(int numA, int numB, String operation)
    {
        int answer=0;
        switch(operation)
        {
            case "+":
            {
                answer= numA + numB;
            }
            break;
            case "-":
            {
                answer= numA - numB;
            }
            break;
            case "*":
            case "x":
            {
                answer= numA * numB;
            }
            break;
            case "/":
            {
                answer= numA / numB;
            }
            break;
        }
        return answer;
    }
}