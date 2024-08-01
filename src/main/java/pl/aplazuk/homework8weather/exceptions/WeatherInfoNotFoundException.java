package pl.aplazuk.homework8weather.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WeatherInfoNotFoundException extends RuntimeException {

    public WeatherInfoNotFoundException(String message) {
        super(message);
    }
}
