
package pl.aplazuk.homework8weather.model.weatherinfo;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "details",
    "summary"
})
public class Next6Hours {

    @JsonProperty("details")
    private Details__3 details;
    @JsonProperty("summary")
    private Summary__2 summary;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("details")
    public Details__3 getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(Details__3 details) {
        this.details = details;
    }

    @JsonProperty("summary")
    public Summary__2 getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(Summary__2 summary) {
        this.summary = summary;
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
