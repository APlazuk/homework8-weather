
package pl.aplazuk.homework8weather.model.weatherinfo;

import com.fasterxml.jackson.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "time"
})

public class Timeseries {

    @JsonProperty("data")
    private Data data;
    @JsonProperty("time")
    private LocalDateTime time;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    @JsonProperty("time")
    public LocalDateTime getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
