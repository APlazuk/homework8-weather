package pl.aplazuk.homework8weather.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.aplazuk.homework8weather.model.Weather;

@Repository
public interface WeatherRepo extends JpaRepository<Weather, Long> {
}
