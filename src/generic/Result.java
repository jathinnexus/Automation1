package generic;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Result implements ITestListener, IAutoConst {
	public static int passCount=0, failCount=0;
	@Override
	public void onFinish(ITestContext arg0) {
		Utility.writeToXL(SUMMARY_PATH, "sheet1", passCount, failCount);
		}
	@Override
	public void onStart(ITestContext result) {}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	@Override
	public void onTestFailure(ITestResult result) {
		failCount++;
		}
	@Override
	public void onTestSkipped(ITestResult result) {}

	@Override
	public void onTestStart(ITestResult result) {	}
	@Override
	public void onTestSuccess(ITestResult result) {
		passCount++;
		}
	}
