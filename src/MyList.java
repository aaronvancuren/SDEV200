import java.util.Collection;

public interface MyList<E> extends java.util.Collection<E>
{
    /**
     * Return the element from this list at the specified index
     */
    E get(int index);

    /**
     * Return the index of the first matching element in this list.
     * Return -1 if no match.
     */
    int indexOf(Object e);

    /**
     * Return the index of the last matching element in this list
     * Return -1 if no match.
     */
    int lastIndexOf(E e);

    /**
     * Add a new element at the specified index in this list
     */
    void add(int index, E e);

    /**
     * Replace the element at the specified position in this list
     * with the specified element and returns the new set.
     */
    E set(int index, E e);

    /**
     * Remove the element at the specified position in this list
     * Shift any subsequent elements to the left.
     * Return the element that was removed from the list.
     */
    E remove(int index);

    /**
     * Add a new element at the end of this list
     */
    @Override
    default boolean add(E e)
    {
        add(size(), e);
        return true;
    }

    /* Return true if this list contains no elements */
    @Override
    default boolean isEmpty()
    {
        return size() == 0;
    }

    /* Remove the first occurrence of the element e
     *  from this list. Shift any subsequent elements to the left.
     *  Return true if the element is removed. */
    @Override
    default boolean remove(Object e)
    {
        if (indexOf(e) >= 0)
        {
            remove(indexOf(e));
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    default boolean containsAll(Collection<?> c)
    {
        // Left as an exercise
        return true;
    }

    @Override
    default boolean addAll(Collection<? extends E> c)
    {
        // Left as an exercise
        return true;
    }

    @Override
    default boolean removeAll(Collection<?> c)
    {
        // Left as an exercise
        return true;
    }

    @Override
    default boolean retainAll(Collection<?> c)
    {
        // Left as an exercise
        return true;
    }

    @Override
    default Object[] toArray()
    {
        // Left as an exercise
        return null;
    }

    @Override
    default <T> T[] toArray(T[] array)
    {
        // Left as an exercise
        return null;
    }
}