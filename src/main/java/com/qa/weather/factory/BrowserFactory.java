package com.qa.weather.factory;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    Properties prop;

    public Page initBrowser(Properties prop){
        String browserName=prop.getProperty("browser");
        playwright = Playwright.create();
        switch (browserName.toLowerCase()){
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                System.out.println("Please enter the browser name to execute the test");
                break;
        }
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(prop.getProperty("url"));
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reject optional cookies")).click();
        return page;
    }

    public Properties initProp() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config/config.properties");
        prop = new Properties();
        prop.load(fileInputStream);
        return prop;
    }

}
