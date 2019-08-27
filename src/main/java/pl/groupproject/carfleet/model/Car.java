package pl.groupproject.carfleet.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import pl.groupproject.carfleet.dto.CarInformationDto;
import pl.groupproject.carfleet.dto.CarsDto;

import javax.persistence.*;
import java.util.List;

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
    private String carBrand;
    private String carModel;
    private String initialMileage;
    private String finaleMileage;
    private String vinNr;
    private int amountOfFuel;
    private boolean reservation;

    @ManyToMany(mappedBy = "cars")
    private List<Driver> drivers;

    public CarsDto carsDto(){
        return CarsDto.builder()
                .id(id)
                .carModel(carBrand)
                .build();
    }

    public CarInformationDto carInformationDto(){
        return CarInformationDto.builder()
                .id(id)
                .carModel(carBrand)
                .initialMileage(initialMileage)
                .finaleMileage(finaleMileage)
                .vinNr(vinNr)
                .amountOfFuel(amountOfFuel)
                .build();
    }

    @ManyToMany
    @JoinTable(
            name = "damages_cars",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "damage_id"))
    private List<Damage> damages;


    //    @OneToMany(mappedBy = "cars")
//    private List<Departure> departures;
    @ManyToOne
    @JoinColumn(name = "departures_id")
    private Departure departures;

    public Car(String carModel, String initialMileage, String finaleMileage, String vinNr) {
        this.carBrand = carModel;
        this.initialMileage = initialMileage;
        this.finaleMileage = finaleMileage;
        this.vinNr = vinNr;
    }

}