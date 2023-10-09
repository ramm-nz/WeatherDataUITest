package com.qa.weather.tests;

import com.qa.weather.base.BaseTest;
import com.qa.weather.constants.AppConstants;
import com.qa.weather.util.ReadTestData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class WeatherDataTest extends BaseTest {
    ReadTestData readTestData = new ReadTestData();

    @Test(priority = 1, description = "Verify the Title of the HomePage")
    public void homePageTitleTest() {
        homePage.clickWeatherDataMenu();
        Assert.assertEquals(weatherDataPage.getWeatherDataTitle(), AppConstants.HOME_PAGE_TITLE);
    }

    @Test(priority = 2, description = "Verify that URL should contain the city name")
    public void weatherDataURLTest() throws IOException, ParseException {
        weatherDataPage.searchWeatherData(readTestData.getData("cityName"));
        Assert.assertEquals(weatherDataPage.getWeatherDataURL(),readTestData.getData("weatherDataURL"));
}

    @Test(priority = 3,description = "Verify that Header should contain the city name")
    public void weatherDataHeaderTest() throws IOException, ParseException {
        Assert.assertEquals(weatherForecastPage.getWeatherForecastHeader(),readTestData.getData("weatherDataHeader"));
    }

    @Test(priority = 4,description = "Verify that Title should contain the city name")
    public void weatherDataTitleTest() throws IOException, ParseException {
        Assert.assertEquals(weatherForecastPage.getWeatherForecastTitle(),readTestData.getData("weatherForecastTitle"));
    }
}
