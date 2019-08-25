package pl.groupproject.carfleet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import pl.groupproject.carfleet.dto.CarInformationDto;
import pl.groupproject.carfleet.dto.CarsDto;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

//@Embeddable
@Getter
@Setter
@Entity
@Table(name = "cars")
@EntityListeners(AuditingEntityListener.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String carModel;
    private String initialMileage;
    private String finaleMileage;
    private String vinNr;
    private int amountOfFuel;

    @ManyToMany(mappedBy = "cars")
    private List<Driver> drivers;

    @OneToMany(mappedBy = "car")
    private Set<Damage> damages;

    public CarsDto carsDto(){
        return CarsDto.builder()
                .id(id)
                .carModel(carModel)
                .build();
    }

    public CarInformationDto carInformationDto(){
        return CarInformationDto.builder()
                .id(id)
                .carModel(carModel)
                .initialMileage(initialMileage)
                .finaleMileage(finaleMileage)
                .vinNr(vinNr)
                .amountOfFuel(amountOfFuel)
                .build();
    }
    
    //    @OneToMany(mappedBy = "cars")
//    private List<Departure> departures;
    @ManyToOne
    @JoinColumn(name = "departures_id")
    private Departure departures;

    public Car(String carModel, String initialMileage, String finaleMileage, String vinNr) {
        this.carModel = carModel;
        this.initialMileage = initialMileage;
        this.finaleMileage = finaleMileage;
        this.vinNr = vinNr;
    }

}