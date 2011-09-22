/**
 * 
 */
package swe1ue1;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * @author patrick
 *
 */
public class MyListTest {
	@Test
	public void testIsEmpty() {
		MyList tester = new MyList();
		
		assertTrue(tester.isEmpty());
		
		tester.add(new Object());
		
		assertTrue(!tester.isEmpty());
		
		tester.remove(0);
		
		assertTrue(tester.isEmpty());
	}
	
	@Test
	public void testContains() {
		MyList tester = new MyList();
		Object[] e = new Object[10];
		
		assertTrue(!tester.contains(e[0]));
		
		tester.add(e[0]);
		
		assertTrue(tester.contains(e[0]));
		
		ArrayList<Object> list = new ArrayList<Object>();
		
		for(Object o : e)
		{
			list.add(o);
		}
		
		tester.addAll(list);
		
		assertTrue(tester.containsAll(list));
	}
	
	@Test
	public void testAdd() {
		MyList tester = new MyList();

		Object e = new Object();
		tester.add(e);
		
		assertTrue(tester.contains(e));
		assertTrue(!tester.isEmpty());
		
		tester = new MyList();
		
		ArrayList<Object> list = new ArrayList<Object>();
		
		for(int i = 0; i < 20; i++)
		{
			list.add(new Object());
		}
		
		tester.addAll(list);
		
		assertTrue(tester.containsAll(list));
		assertTrue(!tester.isEmpty());
		assertTrue(!tester.contains(e));
		
		for( int i = 0; i < list.size(); i++ )
		{	
			assertTrue(tester.get(i).equals( list.get(i) ));
		}
	}
	
	@Test
	public void testClear() {
		MyList tester = new MyList();
		
		tester.add(new Object());
		
		assertTrue(!tester.isEmpty());
		
		tester.clear();
		
		assertTrue(tester.isEmpty());
		
		for(int i = 98; i > 0; i--)
		{
			tester.add(new Object());
		}
		
		assertTrue(!tester.isEmpty());
		
		tester.clear();
		
		assertTrue(tester.isEmpty());
	}
	
	@Test 
	public void testRemove() {
		MyList tester = new MyList();
		
		boolean didThrow = false;
		try 
		{
			tester.remove(0);
		} catch(IndexOutOfBoundsException ex)
		{
			didThrow = true;
		} finally
		{
			assertTrue(didThrow);
		}
		
		tester.add(new Object());
		tester.add(new Object());
		
		Object e = tester.get(0);
		
		tester.remove(e);
		
		didThrow = false;
		try 
		{
			tester.get(1);
		} catch(IndexOutOfBoundsException ex)
		{
			didThrow = true;
		} finally
		{
			assertTrue(didThrow);
		}
		
		tester.remove(0);
		
		assertTrue(tester.isEmpty());
		
		ArrayList<Object> list = new ArrayList<Object>();
		
		for(int i = 20; i > 0; i--)
		{
			list.add(new Object());
		}
		
		tester.addAll(list);
		
		tester.removeAll(list);
		
		assertTrue(tester.isEmpty());
		
		tester.addAll(list);
		
		tester.removeAll(list.subList(0, 10));
		
		assertTrue(tester.size() == 10);
		
		tester.retainAll(list.subList(10, 20));
		
		assertTrue(tester.size() == 10);
		
		tester.retainAll(list.subList(0, 1));
		
		assertTrue(tester.isEmpty());
	}
	
	@Test
	public void testIndexOf() {
		MyList tester = new MyList();
		final int totalSize = 20;
		
		for(int i = totalSize; i >= 0; i--)
		{
			tester.add(new Object());
		}
		
		Object s = new Object();
		final int firstIndex = 2;
		final int lastIndex = 14;
		final int secondToLast = 7;
		
		tester.add(firstIndex, s);
		tester.add(5, s);
		tester.add(secondToLast, s);
		tester.add(lastIndex, s);
		
		assertTrue(!tester.isEmpty());
		assertTrue(tester.indexOf(s) == firstIndex);
		assertTrue(tester.lastIndexOf(s) == lastIndex);
		
		tester.remove(lastIndex);
		
		assertTrue(tester.size() == totalSize + 4);
		
		assertTrue(tester.lastIndexOf(s) == secondToLast);
	}
	
	@Test
	public void testGet() {
		MyList tester = new MyList();
		ArrayList<Object> list = new ArrayList<Object>();
		
		final int total = 100;
		
		for(int i = 0; i < total; i++)
		{
			Object tmp = new Object();
			tester.add(tmp);
			list.add(tmp);
			
			assertTrue(list.get(i).equals(tester.get(i)));
		}
		
		assertTrue(tester.size() == total);
		tester.remove(6);
		assertTrue(tester.size() == total - 1);
		
		assertTrue(list.get(7).equals(tester.get(7 - 1)));
		
		Object o = new Object();
		
		tester.add(6, o);
		
		assertTrue(tester.size() == total);
		assertTrue(tester.get(6).equals(o));
	}
}
