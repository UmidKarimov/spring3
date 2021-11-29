package az.spring3.spring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping
    public ResponseEntity init() {
        try {
            return ResponseEntity.ok("Second Controller ready to work!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Server is not working!");
        }
    }


    @GetMapping("/hello")
    public String sayHello() {
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String sayGoodBye() {
        return "first/goodbye";
    }


}
