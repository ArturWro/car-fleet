package pl.groupproject.carfleet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.groupproject.carfleet.dto.CarInformationDto;
import pl.groupproject.carfleet.dto.CarsDto;
import pl.groupproject.carfleet.model.Car;
import pl.groupproject.carfleet.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;


/*    public CarService() {
        cars.add(new Car("BMW", "25000", "25600", "JPA252646JSK"));
        cars.add(new Car("Mercedes", "5500", "6100", "MRC5979997JAL"));
        cars.add(new Car("Mazda", "7300", "24899", "JPA2534422646JSK"));
    }*/

    public void addCar(CarInformationDto car){
        Car carEntity = Car.builder()
                .id(car.getId())
                .carModel((car.getCarModel()))
                .initialMileage(car.getInitialMileage())
                .finaleMileage(car.getFinaleMileage())
                .vinNr(car.getVinNr())
                .amountOfFuel(car.getAmountOfFuel())
                .build();
        carRepository.save(carEntity);
    }

//    public List<Car> getAll() {
//        return carRepository.findAll();
//    }

    public List<CarsDto> carList(){
        return carRepository.findAll().stream()
                .map(Car::carsDto)
                .collect(Collectors.toList());
    }

//    public void updateCar(Car car){
//        cars. // ???
//    }

    // ogarnac sobie zapisywanie
}
