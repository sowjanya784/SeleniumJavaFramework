package demo;

import org.testng.annotations.Test;

@Test(groups = "classTests")
public class TestNG_Groups {
	
	
	@Test(groups = {"sanity"})
	public void test1() {
		System.out.println("In test 1");
	}

	@Test(groups = {"sanity", "smoke", "windows.OSTest"})
	public void test2() {
		System.out.println("In test 2");
	}
	
	@Test(groups = {"sanity", "regression", "linux.OSTest"})
	public void test3() {
		System.out.println("In test 3");
	}
	
	@Test
	public void test4() {
		System.out.println("In test 4");
	}
	
}
