package com.qa.weather.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;

public class WeatherForecast {
    Page page;

    private String pageHeading ="xpath=//h1[@class='h3 d-flex align-items-end justify-content-between']";

    public String getWeatherForecastTitle(){
        String weatherForecastTitle =page.title();
        return weatherForecastTitle;
    }

    public String getWeatherForecastHeader(){
        String weatherForecastHeader=page.locator(pageHeading).innerText();
        return weatherForecastHeader;
    }

    public WeatherForecast (Page page){
        this.page = page;
    }
}
