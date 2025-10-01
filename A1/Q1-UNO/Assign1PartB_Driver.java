import java.util.Scanner;

public class Assign1PartB_Driver
{
    public static void main(String[] args) 
    {
        ArithmeticCalculator cal = new ArithmeticCalculator();
        LinkedStack <Integer> prevList = new LinkedStack<>();
        LinkedStack <Integer> nextList = new LinkedStack<>();
        
        System.out.println("Simple Calculator: type z to undo, y to redo, q to quit.\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number:\n");
        int numA = sc.nextInt();
        int numB = 0;
        String numPrompted;

        System.out.println("Enter the next operation on " + numA + ":");
        String operation = sc.next();
        if(!(operation.equals("z")||operation.equals("y")||operation.equals("q")))
            {
             numB = sc.nextInt();   
            }

        while(!operation.equals("q"))
        {
            if(operation.equals("z"))
            {
                if(prevList.isEmpty())
                {
                    System.out.println("Nothing to undo.");
                    System.out.println("Enter a number:");
                    numA = sc.nextInt();
                }
                else
                {
                    nextList.push(numA);
                    numA = prevList.pop();
                    System.out.println("UNDO: " + numA);
                }
            }
            else if(operation.equals("y"))
            {
                if(nextList.isEmpty())
                {
                    System.out.println("Nothing to redo.");
                }
                else
                {
                    prevList.push(numA);
                    numA = nextList.pop();
                    System.out.println("REDO: " + numA);
                }
            }
            else
            {
                prevList.push(numA);
                int result = cal.arithmeticOperation(numA, numB, operation);
                System.out.println("= " + result);
                numA = result;  
            }
            System.out.println("Enter the next operation on " + numA + ":");
            operation = sc.next();
            
            if(!(operation.equals("z")||operation.equals("y")||operation.equals("q")))
            {
             numB = sc.nextInt();   
            }
        }
        System.out.println("Goodbye!");
    }
}