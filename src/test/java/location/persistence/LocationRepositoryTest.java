package location.persistence;

import location.persistence.entity.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
class LocationRepositoryTest {

    @Autowired
    private LocationRepository locationRepository;

    @Test
    void findAddressByCountry() {

        Address address = Address.builder().state("ABC").city("My City").country("US").build();
        locationRepository.save(address);

        Optional<List<Address>> us = locationRepository.findAddressByCountry("US");
        assertTrue(us.isPresent());
        List<Address> addresses = us.get();
        assertEquals("ABC", us.get().get(0).getState());
    }
}