package com.qa.weather.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;
    private String weatherDataMenu ="a[href='/weather-data']";


    public HomePage (Page page){
        this.page = page;
    }

    public void clickWeatherDataMenu(){
        page.click(weatherDataMenu);
    }

}
