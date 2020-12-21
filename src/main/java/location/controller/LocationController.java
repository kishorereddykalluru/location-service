package location.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import location.domain.LocationResponse;
import location.exception.AddressNotFoundException;
import location.persistence.entity.Address;
import location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {

    public static final String LOCATION_PATH = "location/{country}";

    @Autowired
    private LocationService locationService;

    @GetMapping("/"+LOCATION_PATH)
    @Operation(description = "Address Service", summary = "Retrun List of Addresses based on Country")
    @ApiResponse(responseCode = "200", description = "successfull", content = @Content(schema = @Schema(implementation = LocationResponse.class)))
    public List<LocationResponse>  getAddresses(
            @Parameter(name = "country", in = ParameterIn.PATH, required = true, description = "Country code", example = "US")
            @PathVariable("country") String country){

        return locationService.retrieveAddressByCountryName(country).orElseThrow(() -> new AddressNotFoundException("Addresses for country not found"));
    }

    @PostMapping("/location")
    public String saveAddress(
            @Parameter(required = true, description = "address", content = @Content(schema = @Schema(implementation = Address.class)))
            @RequestBody Address address){
       return locationService.save(address);
    }
}
