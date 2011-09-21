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
		
		Object[] arr = new Object[20];
		ArrayList<Object> list = new ArrayList<Object>();
		
		for(Object obj : arr)
		{
			list.add(obj);
		}
		
		tester.addAll(list);
		
		assertTrue(tester.containsAll(list));
		assertTrue(!tester.isEmpty());
		assertTrue(!tester.contains(e));
		
		for( int i = 0; i < arr.length; i++ )
		{
			assertTrue(tester.get(i).equals( arr[i] ));
		}
	}
}
