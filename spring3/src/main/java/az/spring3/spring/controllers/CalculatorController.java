package az.spring3.spring.controllers;

import az.spring3.spring.services.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calc")
public class CalculatorController {


    @GetMapping
    public ResponseEntity init() {
        try {
            return ResponseEntity.ok("Calculator ready to work!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Server is not working!");
        }
    }

    @GetMapping("/operation")
    public String calc(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("action") String action, Model model) {

        model.addAttribute("result", CalculatorService.calculate(a, b, action));
        return "calculator/calc";
    }
}
