package location.service;

import location.domain.LocationResponse;
import location.persistence.LocationRepository;
import location.persistence.entity.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Execution(ExecutionMode.SAME_THREAD)
class LocationServiceTest {

    @InjectMocks
    private LocationService locationService;

    @Mock
    private LocationRepository locationRepository;

    @Test
    public void testRetrieveAddressByCountryName(){
        List<Address> addresses = new ArrayList<>();
        addresses.add(Address.builder().unit("APT 1111").street("Street").city("city")
                .country("US").state("State").zipCode("12303").county("county").build());
        when(locationRepository.findAddressByCountry(anyString())).thenReturn(Optional.of(addresses));
        Optional<List<LocationResponse>> us = locationService.retrieveAddressByCountryName("US");
        assertTrue(us.isPresent());
        assertEquals("12303", addresses.get(0).getZipCode());
    }

    @Test
    public void testRetrieveAddressByCountryName_empty(){

        when(locationRepository.findAddressByCountry(anyString())).thenReturn(Optional.empty());
        Optional<List<LocationResponse>> us = locationService.retrieveAddressByCountryName("US");
        assertFalse(us.isPresent());
    }

}