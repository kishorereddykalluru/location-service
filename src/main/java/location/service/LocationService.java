package location.service;

import location.domain.LocationResponse;
import location.persistence.LocationRepository;
import location.persistence.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Optional<List<LocationResponse>> retrieveAddressByCountryName(String country){
        Optional<List<Address>> addressByCountry = locationRepository.findAddressByCountry(country);
        List<LocationResponse> locationResponses = null;
        if(addressByCountry.isPresent()){
            locationResponses = addressByCountry.get().stream().map(response -> LocationResponse
                    .builder()
                    .unit(response.getUnit())
                    .city(response.getCity())
                    .country(response.getCountry())
                    .state(response.getState())
                    .county(response.getCounty())
                    .street(response.getStreet())
                    .state(response.getState())
                    .zipCode(response.getZipCode())
                    .build()
            ).collect(Collectors.toList());
        }
        return Optional.ofNullable(locationResponses);
    }

    public String save(Address address){
        Address save = locationRepository.save(address);

        if(Objects.nonNull(save))
            return "updated successfully";

        return "saved";
    }
 }
