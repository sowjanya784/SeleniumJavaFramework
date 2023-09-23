package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) { //throws Exception {

		/*
		try {
		System.out.println("Inside main");
		System.out.println(" 1 / 0 is : " + 1/0);
		System.out.println("how come we are here");
		}
		catch(Exception e) {
			System.out.println("In catch ");
			System.out.println("Message is : " + e.getMessage());
			System.out.println("Cause is : " + e.getCause());
			e.printStackTrace();
		}
		// finally is executed exception or not, so we include must run code here
		finally {
			System.out.println("Lets see if this is printed");
		}
		*/
		//we can define try catch here or add throws to main func
//		try {
			demo();
//		} catch (Exception e) {
//			System.out.println("stack trace : ");
//			e.printStackTrace();
//		}
	}

	private static void demo() {//throws Exception {

		System.out.println("Inside main");
		//can deliberately throw an exception, any code below throw is unreachable, no need to catch it in calling func
		throw new ArithmeticException("not valid operation");
//		System.out.println(" 1 / 0 is : " + 1/0);
//		System.out.println("how come we are here");
	}

}
