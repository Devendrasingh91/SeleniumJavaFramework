package testCases;

import org.testng.annotations.AfterMethod;
import com.BaseClasses.Keywords;

public class baseTest extends Keywords {
	
	@AfterMethod
	public void tearsDown()
	{
		
		driver.quit();
		//Baseclass.quit();
	}

}
