package com.qa.weather.pages;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.options.AriaRole;
import java.io.IOException;

public class WeatherDataPage {

    Page page;
    Response response;
    private String locationTextField ="#wxlocation";
    private String forecastHistoryDropdown =".dropdown-toggle-label";
    private String selectForecastOption ="xpath=//ul[@class='dropdown-menu show']/li[2]";


    public WeatherDataPage (Page page){
        this.page = page;
    }

    public void searchWeatherData(String cityName){
        page.fill(locationTextField,cityName);
        page.click(forecastHistoryDropdown);
        page.locator(selectForecastOption).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search")).click();
    }

    public String getWeatherDataURL(){
        return page.url();
    }

    public String getWeatherDataTitle(){
        String weatherDataTitle=page.title();
        return weatherDataTitle;
    }


    public APIResponse getWeatherDataResponse() throws IOException {
        APIResponse response = page.request().get("https://www.visualcrossing.com/weather-forecast/Chennai");
        return response;
    }
}
