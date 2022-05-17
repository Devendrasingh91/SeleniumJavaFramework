package testCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import businessClasses.HomePage;
import utilities.DataUtil;

public class Roughtest extends baseTest {
	
	@Test(dataProviderClass=DataUtil.class,dataProvider="dps")
	public void roughtest(Hashtable<String,String>data) throws InterruptedException
	{
		new HomePage().clickOnGmailLink().enterEmail(data.get("email"));
		Thread.sleep(3000);
	}

}
