package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore //everything in class is ignored
public class TestNGIgnore {
	
	@Test
	@Ignore	//this method is ignored
	public void test() {
		System.out.println("in test");
	}
	
	public void test1() {
		System.out.println("in test 1");
	}

}
