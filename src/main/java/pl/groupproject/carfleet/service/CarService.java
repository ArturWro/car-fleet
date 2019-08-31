package pl.groupproject.carfleet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.groupproject.carfleet.dto.CarInformationDto;
import pl.groupproject.carfleet.dto.CarSelectDto;
import pl.groupproject.carfleet.dto.CarsDto;
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
                .carBrand(car.getCarBrand())
                .carModel(car.getCarModel())
                .initialMileage(car.getInitialMileage())
                .finaleMileage(car.getFinaleMileage())
                .vinNr(car.getVinNr())
                .amountOfFuel(car.getAmountOfFuel())
                .build();
        carRepository.save(carEnitity);
    }
    private CarsDto mupToDto(Car car){
        return new CarsDto(car.getId(),car.getCarBrand(),
                car.getCarModel(), car.getVinNr(), car.isReservation(), car.getCarUpdate());
    }


    public List<CarsDto> getAll() {
        return carRepository.findAll().stream().map(this::mupToDto).collect(Collectors.toList());
    }

    public List<CarSelectDto> getAllForSelect() {
        return carRepository.findAll().stream()
                .map(car -> new CarSelectDto(car.getId(), car.getVinNr()))
                .collect(Collectors.toList());
    }

//    public void updateCar(Car car){
//        cars. // ???
//    }

    public void makeReservation(String id){
        Optional<Car> byId = carRepository.findById(Long.valueOf(id));
        Car car = byId.get();
        car.setReservation(!car.isReservation());
        carRepository.save(car);
    }


//    public void updateCar(String id, CarsDto carsDto){
//        Optional<Car> byId = carRepository.findById(Long.valueOf(id));
//        Car car = byId.get();
//        car.setCarUpdate(car.getCarUpdate());
//        carRepository.save(car);
//    }
//
//
//
//    public void updateCar(CarsDto carForm) {
//    }
}
