package Listeners_Demo;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)
public class TestNGListenersDemo2 {
	
	@Test
	public void test3() {
		System.out.println("In test 4");
	}
	
	@Test
	public void test4() {
		System.out.println("In test 5");
	}
	
	@Test
	public void test5() {
		System.out.println("In test 6");
	}

}
