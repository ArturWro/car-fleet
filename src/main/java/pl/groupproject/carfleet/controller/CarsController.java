package pl.groupproject.carfleet.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.groupproject.carfleet.dto.CarInformationDto;
import pl.groupproject.carfleet.dto.CarsDto;
import pl.groupproject.carfleet.model.Car;
import pl.groupproject.carfleet.service.CarService;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarsController {

    private final CarService service;

    @GetMapping("/cars")
    public String allCars(Model model) {
        List<Car> cars = service.getAll();
        model.addAttribute("carslist", cars);
        return "cars";
    }

    @GetMapping("/addcar")
    ModelAndView createAddCarView() {
        ModelAndView modelAndView = new ModelAndView("addcar");
        modelAndView.addObject("car", new CarInformationDto());
        return modelAndView;
    }

    @PostMapping("/addcar")
    public String registration(@ModelAttribute("car") CarInformationDto carForm) {
        service.addCar(carForm);

        return "redirect:/cars";
    }

    @PostMapping("/cars")
    public String reservation(HttpServletRequest request){
        String parameter = request.getParameter("msg");
        service.makeReservation(parameter);
        System.out.println(parameter);

        return "redirect:/cars";
    }

}