package az.spring3.spring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/second")
public class SecondController {

    @GetMapping
    public ResponseEntity init(){
        try{
            return ResponseEntity.ok("Second Controller ready to work!");
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body("Server is not working!");
        }
    }

    @GetMapping("/exit")
    public String exit (){
        return "second/exit";
    }
}
