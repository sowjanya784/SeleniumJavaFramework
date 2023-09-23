package demo;
import org.testng.annotations.Test;

public class TestNGPriorities {

	@Test(priority = 1)
	public void one() {
		System.out.println("In test one");
	}
	
	@Test(priority = -1)
	public void two() {
		System.out.println("In test two");
	}
	
	@Test(priority = 0)
	public void three() {
		System.out.println("In test three");
	}
}
