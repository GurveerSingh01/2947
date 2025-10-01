public class CircularDoublyLinkedList<E>
{
    public static class Node<E>
    {
        Node<E> previous;
        E element;
        Node<E> next;
        public Node( E e, Node<E> p, Node<E> n)
        {
            previous =p;
            element = e;
            next =n;
        }

        public E getElement() {return element;}

        public Node<E> getPrev() {return previous;}

        public Node<E> getNext() {return next;}

        public void setPrev(Node<E> p) {previous = p;}

        public void setNext(Node<E> n) {next = n;}
    }

    private Node<E> tail;
    private int size;
    public CircularDoublyLinkedList()
    {    
        tail = new Node<>(null,null,null);
        size=0;
    }

    public int size(){return size;}

    public boolean isEmpty(){ return size==0;}

    public E first()
    {
        if(isEmpty())
        {
            return null;
        }
        return tail.getNext().getElement();
    }

    public E last()
    {
        if(isEmpty())
        {
            return null;
        }
        return tail.getElement();
    }

    int revState=0;
    public void rotate()
    {
        if(tail!=null)
        {
            if(revState==0)
            {
            tail=tail.getNext();
            }
            else
            {
            tail = tail.getPrev();
            }
        }
    }

    public void reverse()
    {
        if(revState ==0)
        {
            revState=1;
        }
        else if(revState == 1)
        {
            revState = 0;
        }
    }

    public Node<E> addBetween(E e, Node<E> predecessor, Node<E> successor)
    {
        Node<E> newest = new Node<>(e, predecessor,successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
        return newest;
    } 

    public void addFirst(E e)
    {
        if(size==0)
        {
            tail =  new Node<E>(e, null, null);
            tail.setNext(tail);
            tail.setPrev(tail); 
            size++;
        }
        else
        {
            addBetween(e, tail, tail.getNext());
        }     
    }

    public void addLast(E e)
    {
        addFirst(e);
        tail = tail.getNext();
    }

    public E remove(Node<E> node)
    {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public E removeFirst()
    {
        if(isEmpty())
        {
            return null;
        }
        Node<E> head = tail.getNext();
        if(head==tail)
        {
            tail = null;
        }
        else
        {
            remove(head);
        }
        return head.getElement();
    }

    public E removeLast()
    {
        Node<E> tailCopy = tail;
        if(isEmpty())
        {
            return null;
        }
        if(tail == tail.getNext())
        {
            remove(tail);
            tail = null;   //important otherwise in remove(tail) 
                           // if tail=null written before remove(tail) its trying to remove null = error
           
        }
        else
        {
            tail = tail.getPrev();
            remove(tailCopy);
        }
        return tailCopy.getElement();
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(size!=0)
        {
            Node<E> current = tail.getNext();
            do
            {
                sb.append(current.getElement());
                if(current!=tail)
                {
                    sb.append(",\n");
                }
                current = current.getNext();
            }
            while(current!=tail.getNext());
        }
        sb.append("]\n");
        return sb.toString();
    }

    public Node<E> getTail()
    {
        return tail;
    }
}