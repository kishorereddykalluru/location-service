package location.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address implements Serializable {

    private static final long serialVersionUID = 8690663645516018680L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @Column(name = "unit")
    @Schema(example = "APT 3456")
    private String unit;

    @Column(name = "street")
    @Schema(example = "3456 EAST PR LANE")
    private String street;

    @Column(name = "city")
    @Schema(example = "ALLEGANY")
    private String city;

    @Column(name = "county")
    @Schema(example = "BELONT")
    private String county;

    @Column(name = "zipcode")
    @Schema(example = "11111")
    private String zipCode;

    @Column(name = "state")
    @Schema(example = "NY")
    private String state;

    @Column(name = "country")
    @Schema(example = "US")
    private String country;

}
