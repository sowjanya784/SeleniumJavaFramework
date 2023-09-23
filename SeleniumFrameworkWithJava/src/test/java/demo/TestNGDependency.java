package demo;

import org.testng.annotations.Test;

public class TestNGDependency {

//	@Test(dependsOnMethods = {"test2", "test3"}, priority = 1)
//	@Test(dependsOnGroups = {"saint1", "saint2"})
	@Test(dependsOnGroups = "saint.*")
	public void test1() {
		System.out.println("I am inside test 1");
	}
	
	@Test(priority = 2, groups = {"saint1"})
	public void test2() {
		System.out.println("I am inside test 2");
	}
	
	@Test(groups = "saint2")
	public void test3() {
		System.out.println("I am inside test 3");
	}
}
