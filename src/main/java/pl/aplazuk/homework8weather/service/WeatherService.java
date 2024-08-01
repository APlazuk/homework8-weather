package pl.aplazuk.homework8weather.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.aplazuk.homework8weather.model.Weather;
import pl.aplazuk.homework8weather.repositories.WeatherRepo;

import java.sql.SQLException;

@Service
public class WeatherService {

    private final WeatherRepo weatherRepo;

    public WeatherService(WeatherRepo weatherRepo) {
        this.weatherRepo = weatherRepo;
    }

    @Transactional(rollbackFor = SQLException.class)
    public Weather saveWeatherInfo(Weather weather) {
        return weatherRepo.save(weather);
    }

}
