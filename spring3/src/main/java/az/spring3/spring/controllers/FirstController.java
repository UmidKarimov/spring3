package az.spring3.spring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping
    public ResponseEntity init() {
        try {
            return ResponseEntity.ok("First Controller ready to work!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Server is not working!");
        }
    }


    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name",required = false) String name, @RequestParam(value = "surname",required = false) String surname,
                           Model model) {
        model.addAttribute("message","Hello "+name+" "+ surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String sayGoodBye() {
        return "first/goodbye";
    }


}
