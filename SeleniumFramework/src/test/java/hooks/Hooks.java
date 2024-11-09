package hooks;

import utils.BrowserUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
        BrowserUtils.getDriver();
    }

    @After
    public void tearDown() {
        BrowserUtils.closeDriver();
    }
}
