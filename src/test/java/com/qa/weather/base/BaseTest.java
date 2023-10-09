package com.qa.weather.base;

import com.microsoft.playwright.Page;
import com.qa.weather.factory.BrowserFactory;
import com.qa.weather.pages.HomePage;
import com.qa.weather.pages.WeatherDataPage;
import com.qa.weather.pages.WeatherForecast;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    BrowserFactory bf;
    Page page;
    protected Properties prop;
    protected HomePage homePage;
    protected WeatherDataPage weatherDataPage;
    protected WeatherForecast weatherForecastPage;

    @BeforeTest
    public void setUp() throws IOException {
        bf=new BrowserFactory();
        prop =bf.initProp();
        page= bf.initBrowser(prop);
        homePage = new HomePage(page);
        weatherDataPage = new WeatherDataPage(page);
        weatherForecastPage = new WeatherForecast(page);
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
