package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RerunFailedTests {
	
	@Test
	public void test1() {
		System.out.println("In test 1 ");
	}

	@Test
	public void test2() {
		System.out.println("In test 2 ");
	}
	
	@Test(retryAnalyzer = Listeners_Demo.RetryAnalyzer.class)	//will retry the number of times defined in the method
	public void test3() {
		System.out.println("In test 3");
		Assert.assertTrue(0 > 1);
	}
}
