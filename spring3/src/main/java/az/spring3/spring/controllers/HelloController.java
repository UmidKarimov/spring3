package az.spring3.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HelloController {

    @GetMapping("/hello")
    public String init (){
        return "hello/hello";
    }
}
