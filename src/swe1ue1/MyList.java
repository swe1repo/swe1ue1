package swe1ue1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList implements List<Object> {
	private Object[] list_;
	
	public MyList() {
		list_ = new Object[0];
	}

	@Override
	public boolean add(Object e) {		
		add(list_.length, e);
		
		return true;
	}

	@Override
	public void add(int index, Object element) {
		if( indexWithinBounds(index) == false && index != list_.length )
		{
			throw new IndexOutOfBoundsException();
		}
		
		Object[] tmp = new Object[list_.length + 1];
		
		for( int i = 0; i < index; i++ )
		{
			tmp[i] = list_[i];
		}
		
		tmp[index] = element;
		
		for( int i = index + 1; i < tmp.length; i++ )
		{
			tmp[i] = list_[i];
		}
		
		list_ = tmp;
	}

	@Override
	public boolean addAll(Collection<? extends Object> c) {
		return addAll(list_.length, c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends Object> c) {
		Object[] arr = c.toArray();
		
		for( int i = 0; i < arr.length; i++ )
		{
			add(index + i, arr[i]);
		}
		
		return true;
	}

	@Override
	public void clear() {
		list_ = new Object[0];
	}
	
	private boolean isEqual(Object o, Object e) {
		return (o == null ? e == null : o.equals(e));
	}

	@Override
	public boolean contains(Object o) {
		for( Object e : list_ )
		{	
			if( isEqual(o, e) == true )
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		Object[] arr = c.toArray();
		
		for( Object o : arr )
		{
			if( contains(o) == false )
			{
				return false;
			}
		}
		
		return true;
	}

	@Override
	public Object get(int index) {
		if( indexWithinBounds(index) == false )
		{
			throw new IndexOutOfBoundsException();
		}
		
		return list_[index];
	}

	@Override
	public int indexOf(Object o) {
		for( int i = 0; i < list_.length; i++ )
		{
			if( isEqual(o, list_[i]) )
			{
				return i;
			}
		}
		
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return (list_.length == 0);
	}

	@Override
	public int lastIndexOf(Object o) {
		for( int i = list_.length - 1; i >= 0; i-- )
		{
			if( isEqual(o, list_[i]) )
			{
				return i;
			}
		}
		
		return -1;
	}

	@Override
	public boolean remove(Object o) {
		int i = indexOf(o);
		remove(i);
		return true;
	}

	@Override
	public Object remove(int index) {
		if( indexWithinBounds(index) == false )
		{
			throw new IndexOutOfBoundsException();
		}
		
		Object tmp = list_[index];
		list_[index] = null;
		
		Object[] newList = new Object[list_.length - 1];
		
		for( int i = 0; i < index; i++ )
		{
			newList[i] = list_[i];
		}
		
		for( int i = index; i < list_.length - 1; i++ )
		{
			newList[i] = list_[i + 1];
		}
		
		list_ = newList;
		
		return tmp;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for( Object e : c.toArray() )
		{
			if( remove(e) == false )
			{
				return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		for( Object o : list_ )
		{
			if( c.contains(o) == false )
			{
				remove(o);
			}
		}
		return false;
	}

	@Override
	public Object set(int index, Object element) {
		if( indexWithinBounds(index) == false )
		{
			throw new IndexOutOfBoundsException();
		}
		
		return list_[index] = element;
	}

	@Override
	public int size() {
		return list_.length;
	}

	@Override
	public List<Object> subList(int fromIndex, int toIndex) {
		MyList sublist = new MyList();
		
		for( int i = fromIndex; i < toIndex; i++ )
		{
			sublist.add(i, list_[i]);
		}
		
		return sublist;
	}

	@Override
	public Object[] toArray() {
		return list_;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		if( a == null)
		{
			throw new NullPointerException();
		}
		
		Object[] output;
		
		if(a.length >= list_.length)
		{
			output = a;
		}
		else
		{
			output = new Object[list_.length];
		}

		for( int i = 0; i < list_.length; i++ )
		{
			output[i] = list_[i];
		}
		
		for( int i = list_.length; i < output.length; i++)
		{
			output[i] = null;
		}

		return (T[])output;
	}
	
	private boolean indexWithinBounds(int index) {
		return ( index < 0 || index >= size() );
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<Object> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<Object> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
}		
