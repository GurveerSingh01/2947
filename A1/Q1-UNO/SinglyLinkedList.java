/**
 * Gurveer Singh 3187474
 */
public class SinglyLinkedList<E>
{
    private static class Node<E>
    {
        private E element;
        private Node<E> next;

        private Node(E e, Node<E> n)
        {
            element = e;
            next = n;
        }

        public E getElement()
        {
            return element;
        }

        public Node<E> getNext()
        {
            return next;
        }

        public void setNext(Node<E> n)
        {
            next = n;
        }
    }

    public Node<E> head = null;
    public Node<E> tail = null;
    public int size = 0;

    public SinglyLinkedList(){}; // starting empty list

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size==0;
    }

    public E first()
    {
        if(isEmpty())
        { 
            return null;
        }
        return head.getElement();
    }

    public E last()
    {
        if(isEmpty())
        { return null;}
        return tail.getElement();
    }

    public void addFirst(E e)
    {
        head = new Node<>(e,head);
        if(size==0)
        {
            tail = head;
        }
        size++;
    }

    public void addLast(E e)
    {
        Node<E> newest = new Node<>(e,null);
        if(size==0)
        {
            head = newest;
        }
        else
        {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst()
    {
        if(isEmpty()){return null;}
        E removed = head.getElement();
        head = head.getNext();
        size--;
        if(size==0)
        {
            tail = null;
        }
        return removed;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        sb.append("[");
        while(current!=null)
        {
            sb.append(current.getElement());
            if(current.getNext()!=null)
            {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
