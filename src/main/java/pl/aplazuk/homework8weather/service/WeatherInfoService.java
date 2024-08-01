package pl.aplazuk.homework8weather.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.aplazuk.homework8weather.controller.WeatherController;
import pl.aplazuk.homework8weather.model.Weather;

@Service
public class WeatherInfoService {

    private final WeatherService weatherService;
    private final WeatherController weatherController;

    public WeatherInfoService(WeatherService temperatureService, WeatherController weatherController) {
        this.weatherService = temperatureService;
        this.weatherController = weatherController;
    }

    @Scheduled(cron = "@hourly")
    public void getWeatherInfo() {
        Weather weather = new Weather();
        weather.setLatitude(51.107883);
        weather.setLongitude(17.038538);
        Double temperature = weatherController.getTemperature(weather.getLatitude(), weather.getLongitude());
        weather.setTemperature(temperature);

        weatherService.saveWeatherInfo(weather);
    }

}
