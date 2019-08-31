package pl.groupproject.carfleet.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CarInformationDto {
    private Long id;
    private String carModel;
    private String carBrand;
    private String initialMileage;
    private String finaleMileage;
    private String vinNr;
    private int amountOfFuel;

}
