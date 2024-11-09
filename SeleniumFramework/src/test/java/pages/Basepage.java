package pages;

import utils.BrowserUtils;

public class Basepage {
    public void navigateTo(String url) {
        BrowserUtils.getDriver().get(url); // Use BrowserUtils to navigate
    }
}