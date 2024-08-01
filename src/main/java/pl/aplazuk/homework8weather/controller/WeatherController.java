package pl.aplazuk.homework8weather.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;
import pl.aplazuk.homework8weather.exceptions.WeatherInfoNotFoundException;
import pl.aplazuk.homework8weather.model.weatherinfo.Data;
import pl.aplazuk.homework8weather.model.weatherinfo.Timeseries;
import pl.aplazuk.homework8weather.model.weatherinfo.WeatherInfo;

import java.net.URI;
import java.time.LocalDateTime;

@Controller
public class WeatherController {

    private static final String WEATHER_API_URL = "https://api.met.no/weatherapi/locationforecast/2.0/mini";
    private RestClient restClient = RestClient.create(WEATHER_API_URL);

    public Double getTemperature(Double latitude, Double longitude) {
        ResponseEntity<WeatherInfo> weatherInfoResponseEntity = restClient.get()
                .uri(getWeatherInfoUri(latitude, longitude))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(WeatherInfo.class);

        if (!weatherInfoResponseEntity.getStatusCode().is2xxSuccessful() && weatherInfoResponseEntity.getBody() == null) {
            throw new WeatherInfoNotFoundException("Weather Info for given latitude and longitude wasn't found");
        }
        return getAirTemperature(weatherInfoResponseEntity.getBody());
    }

    private static Double getAirTemperature(WeatherInfo weatherInfo) {
        Data data = weatherInfo.getProperties().getTimeseries().stream()
                .filter(timeseries -> timeseries.getTime().isAfter(LocalDateTime.now()))
                .map(Timeseries::getData)
                .findFirst()
                .orElse(null);

        return data != null ? data.getInstant().getDetails().getAirTemperature() : null;
    }


    private URI getWeatherInfoUri(Double latitude, Double longitude) {
        return UriComponentsBuilder.fromHttpUrl(WEATHER_API_URL)
                .queryParam("lat", latitude)
                .queryParam("lon", longitude)
                .build().toUri();
    }
}
