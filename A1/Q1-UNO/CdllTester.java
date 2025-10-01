/**
 * DO NOT MODIFY THIS CLASS.
 * Tester Class for CDLL
 * This class is provided for you to test that your CDLL methods class works as expected.
 * The expected output for this class is shown as comments after the last line. 
 * @author ACS-2947
 *
 */
public class CdllTester {
	public static void main(String[] args) {
		
    	CircularDoublyLinkedList<Integer> cdll = new CircularDoublyLinkedList<>();
    	cdll.addFirst(2);
    	cdll.addFirst(1);
    	cdll.addLast(3);
    	cdll.addLast(4);
    	cdll.addLast(5);
    	cdll.addLast(6);
    	System.out.println("current: "+cdll);
    	
    	cdll.rotate();
    	System.out.println("rotated: "+cdll);
    	cdll.rotate();
    	System.out.println("rotated: "+cdll);
    	cdll.rotate();
    	System.out.println("rotated: "+cdll);
    	
    	System.out.println("reversed direction");
    	cdll.reverse();
    	System.out.println("cdll size: "+cdll.size()); 
        	
    	cdll.rotate();
    	System.out.println("rotated: "+cdll);
    	cdll.rotate();
    	System.out.println("rotated: "+cdll);
    	cdll.rotate();
    	System.out.println("rotated: "+cdll);
    	
    	System.out.println("Remove last: " + cdll.removeLast());
    	System.out.println("current: "+cdll);
    	System.out.println("Remove first: "+cdll.removeFirst());
    	System.out.println("current: "+cdll);
    	
    	System.out.println("reversed direction");
    	cdll.reverse();
    	
    	cdll.rotate();
    	System.out.println("rotated: "+cdll);
    	cdll.rotate();
    	System.out.println("rotated: "+cdll);
    	cdll.rotate();
    	System.out.println("rotated: "+cdll);
    	
    	System.out.println("cdll isEmpty: "+cdll.isEmpty()); 
    	System.out.println("Remove last: " + cdll.removeLast());
    	System.out.println("current: "+cdll);
    	System.out.println("Remove first: "+cdll.removeFirst());
    	System.out.println("current: "+cdll);
    	System.out.println("Remove last: " + cdll.removeLast());
    	System.out.println("current: "+cdll);
    	System.out.println("cdll size: "+cdll.size());
    	
    	System.out.println("Remove last: " + cdll.removeLast());
    	System.out.println("current: "+cdll);
    	
    	System.out.println("Remove last: " + cdll.removeLast());
    	System.out.println("current: "+cdll);
    	
    	System.out.println("cdll size: "+cdll.size());
    	System.out.println("cdll isEmpty: "+cdll.isEmpty());
	}	
}
/*
 * EXPECTED OUTPUT FOR THIS CLASS.
 * Your output from using your CDLL class you match this.
current: [1, 2, 3, 4, 5, 6]
rotated: [2, 3, 4, 5, 6, 1]
rotated: [3, 4, 5, 6, 1, 2]
rotated: [4, 5, 6, 1, 2, 3]
reversed direction
cdll size: 6
rotated: [3, 4, 5, 6, 1, 2]
rotated: [2, 3, 4, 5, 6, 1]
rotated: [1, 2, 3, 4, 5, 6]
Remove last: 6
current: [1, 2, 3, 4, 5]
Remove first: 1
current: [2, 3, 4, 5]
reversed direction
rotated: [3, 4, 5, 2]
rotated: [4, 5, 2, 3]
rotated: [5, 2, 3, 4]
cdll isEmpty: false
Remove last: 4
current: [5, 2, 3]
Remove first: 5
current: [2, 3]
Remove last: 3
current: [2]
cdll size: 1
Remove last: 2
current: []
Remove last: null
current: []
cdll size: 0
cdll isEmpty: true
 */

