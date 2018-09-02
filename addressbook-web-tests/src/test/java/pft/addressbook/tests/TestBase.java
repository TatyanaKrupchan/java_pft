package pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

    //protected static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);
    protected static ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeSuite
    public ApplicationManager setUp() throws Exception {
        app.init();
        return app;
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
