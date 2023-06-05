package cl.test.testtarea.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CommonResponseDTO implements Serializable {
    @JsonProperty("statusCode")
    private Integer statusCode;
    @JsonProperty("statusMessage")
    private String statusMessage;
}
