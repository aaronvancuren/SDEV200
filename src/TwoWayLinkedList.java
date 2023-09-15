import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class TwoWayLinkedList<E> implements MyList<E>
{
    private Node<E> head, tail;
    private int size;

    /**
     * Create a default list
     */
    public TwoWayLinkedList() {}

    /**
     * Create a list from an array of objects
     */
    public TwoWayLinkedList(E[] objects)
    {
        this.addAll(Arrays.asList(objects));
    }

    /**
     * Return the head element in the list
     */
    public E getFirst()
    {
        if (size == 0)
        {
            return null;
        }
        else
        {
            return head.element;
        }
    }

    /**
     * Add an element to the beginning of the list
     */
    public void addFirst(E e)
    {
        Node<E> newNode = new Node<>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase list size

        if (tail == null) // The new node is the only node in list
        {
            tail = head;
        }
    }

    /**
     * Remove the head node and return the object that is contained in the
     * removed node.
     */
    public E removeFirst()
    {
        if (size == 0)
        {
            return null; // Nothing to delete
        }
        else
        {
            Node<E> temp = head; // Keep the first node temporarily
            head = head.next; // Move head to point to next node
            size--; // Reduce size by 1
            if (head == null)
            {
                tail = null; // List becomes empty
            }
            return temp.element; // Return the deleted element
        }
    }

    /**
     * Return the last element in the list
     */
    public E getLast()
    {
        if (size == 0)
        {
            return null;
        }
        else
        {
            return tail.element;
        }
    }

    /**
     * Add an element to the end of the list
     */
    public void addLast(E e)
    {
        Node<E> newNode = new Node<>(e); // Create a new node for e

        if (tail == null)
        {
            head = tail = newNode; // The only node in list
        }
        else
        {
            tail.next = newNode; // Link the new node with the last node
            tail = newNode; // tail now points to the last node
        }

        size++; // Increase size
    }

    /**
     * Remove the last node and return the object that is contained in the
     * removed node.
     */
    public E removeLast()
    {
        if (size == 0 || size == 1)
        {
            return removeFirst();
        }
        else
        {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++)
            {
                current = current.next;
            }

            E temp = tail.element;
            tail = current;
            tail.next = null;
            size--;
            return temp;
        }
    }

    /**
     * Clear the list
     */
    public void clear()
    {
        head = tail = null;
    }

    /**
     * Return the element from this list at the specified index
     */
    public E get(int index)
    {
        System.out.println("Implementation left as an exercise");
        return null;
    }

    /**
     * Return the index of the head matching element in this list. Return -1 if
     * no match.
     */
    public int indexOf(Object e)
    {
        System.out.println("Implementation left as an exercise");
        return 0;
    }

    /**
     * Return the index of the last matching element in this list Return -1 if
     * no match.
     */
    public int lastIndexOf(Object e)
    {
        System.out.println("Implementation left as an exercise");
        return 0;
    }

    /**
     * Add a new element at the specified index in this list The index of the
     * head element is 0
     */
    public void add(int index, E e)
    {
        if (index == 0)
        {
            addFirst(e); // Insert first
        }
        else if (index >= size)
        {
            addLast(e); // Insert last
        }
        else
        { // Insert in the middle
            Node<E> current = head;
            for (int i = 1; i < index; i++)
            {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }

    /**
     * Replace the element at the specified position in this list with the
     * specified element.
     */
    public E set(int index, E e)
    {
        System.out.println("Implementation left as an exercise");
        return null;
    }

    /**
     * Remove the element at the specified position in this list. Return the
     * element that was removed from the list.
     */
    public E remove(int index)
    {
        if (index < 0 || index >= size)
        {
            return null; // Out of range
        }
        else if (index == 0)
        {
            return removeFirst(); // Remove first
        }
        else if (index == size - 1)
        {
            return removeLast(); // Remove last
        }
        else
        {
            Node<E> previous = head;

            for (int i = 1; i < index; i++)
            {
                previous = previous.next;
            }

            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    /**
     * Return true if this list contains the element o
     */
    public boolean contains(Object e)
    {
        System.out.println("Implementation left as an exercise");
        return true;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++)
        {
            assert current != null;
            result.append(current.element);
            current = current.next;
            if (current != null)
            {
                result.append(", "); // Separate two elements with a comma
            }
            else
            {
                result.append("]"); // Insert the closing ] in the string
            }
        }

        return result.toString();
    }

    @Override
    public Iterator<E> iterator()
    {
        return new LinkedListIterator();
    }

    public ListIterator<E> listIterator()
    {
        return new LinkedListIterator();
    }

    public ListIterator<E> listIterator(int index)
    {
        return new LinkedListIterator(index);
    }

    private static class Node<E>
    {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E e)
        {
            element = e;
        }
    }

    private class LinkedListIterator implements java.util.ListIterator<E>
    {
        private Node<E> current = head; // Current index

        public LinkedListIterator() {}

        public LinkedListIterator(int index)
        {
            if (index < 0 || index >= size)
            {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            for (int nextIndex = 0; nextIndex < index; nextIndex++)
            {
                current = current.next;
            }
        }

        public void setLast()
        {
            current = tail;
        }

        @Override
        public boolean hasNext()
        {
            return (current != null);
        }

        @Override
        public E next()
        {
            E e = current.element;
            current = current.next;
            return e;
        }

        @Override
        public boolean hasPrevious()
        {
            return current != null;
        }

        @Override
        public E previous()
        {
            E e = current.element;
            current = current.previous;
            return e;
        }

        @Override
        public int nextIndex()
        {
            System.out.println("Implementation left as an exercise");
            return 0;
        }

        @Override
        public int previousIndex()
        {
            System.out.println("Implementation left as an exercise");
            return 0;
        }

        @Override
        public void remove()
        {
            System.out.println("Implementation left as an exercise");
        }

        @Override
        public void set(E e)
        {
            current.element = e; // TODO Auto-generated method stub
        }

        @Override
        public void add(E e)
        {
            System.out.println("Implementation left as an exercise");
        }
    }
}
