package businessClasses;

import com.BaseClasses.Keywords;

public class HomePage extends Keywords{
	
	public SignInPage clickOnGmailLink()
	{
		click("GmailLink_XPATH");
		return new SignInPage();
	}
	
}
