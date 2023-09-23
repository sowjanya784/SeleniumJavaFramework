package demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameters {

	@Test
	@Parameters({"myName"})	// {} optional for single parameter, parameters separated by , 
//optional, if no value given prints value of name, null
	//if no optional and dont pass value in .xml, raises error
	public void test(@Optional("Sujji") String name) {
		System.out.println("Name is : " + name);
	}
}
