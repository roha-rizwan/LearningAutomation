package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.FileReaderManager;

public class Hooks {
    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before("@UI")

    public void BeforeSteps() {
		/*What all you can perform here
			Starting a web-driver
			Setting up DB connections
			Setting up test data
			Setting up browser cookies
			Navigating to certain page
			or anything before the test
		*/
      //  testContext.getWebDriverManager().getDriver().get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

   @After("@UI")
    public void AfterSteps() {
        testContext.getWebDriverManager().closeDriver();
    }

}
