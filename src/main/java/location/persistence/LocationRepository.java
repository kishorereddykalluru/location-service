package location.persistence;

import location.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository  extends JpaRepository<Address, Long> {

    @Query("select a from Address a where a.country=:country")
    Optional<List<Address>> findAddressByCountry(@Param("country") String country);
}
