package location.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationResponse implements Serializable {


    private String unit;
    private String street;
    private String city;
    private String county;
    private String zipCode;
    private String state;
    private String country;
}
