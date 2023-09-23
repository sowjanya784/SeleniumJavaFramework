package Listeners_Demo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//can implement multiple listeners with a comma (,)
public class TestNGListeners implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("******* Test Started *******" + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("******* Test Success *******" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("******* Test Failure *******" + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("******* Test Skipped *******" + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("******* Test failed but within success percentage *******" + result.getName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("******* Test failed with timeout *******" + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("******* on start *******" + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("******* on finish *******" + context.getName());
	}

}
