package pl.groupproject.carfleet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.groupproject.carfleet.dto.CarInformationDto;
import pl.groupproject.carfleet.dto.CarSelectDto;
import pl.groupproject.carfleet.model.Car;
import pl.groupproject.carfleet.repository.CarRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public void addCar(CarInformationDto car){
        Car carEnitity = Car.builder()
                .id(car.getId())
                .carModel((car.getCarModel()))
                .initialMileage(car.getInitialMileage())
                .finaleMileage(car.getFinaleMileage())
                .vinNr(car.getVinNr())
                .amountOfFuel(car.getAmountOfFuel())
                .build();
        carRepository.save(carEnitity);
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public List<CarSelectDto> getAllForSelect() {
        return carRepository.findAll().stream()
                .map(car -> new CarSelectDto(car.getId(), car.getVinNr()))
                .collect(Collectors.toList());
    }

    public void makeReservation(String id){
        Optional<Car> byId = carRepository.findById(Long.valueOf(id));
        Car car = byId.get();
        car.setReservation(!car.isReservation());
        carRepository.save(car);
    }

//    public void updateCar(Car car){
//        cars. // ???
//    }

    // ogarnac sobie zapisywanie
}
