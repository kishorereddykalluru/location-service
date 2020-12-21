package location.controller;

import location.domain.LocationResponse;
import location.exception.LocationExeption;
import location.service.LocationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Execution(ExecutionMode.SAME_THREAD)
@WebMvcTest(LocationController.class)
@Import(LocationExeption.class)
class LocationControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private LocationService locationService;

    @Test
    public void valid_accept() throws Exception {
        List<LocationResponse> locationResponses = new ArrayList<>();
        locationResponses.add(LocationResponse.builder().unit("APT 1111").street("Street").city("city")
                .country("US").state("State").zipCode("12303").county("county").build());
        when(locationService.retrieveAddressByCountryName(anyString())).thenReturn(Optional.of(locationResponses));

        mvc.perform(get("/"+LocationController.LOCATION_PATH, "US")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}