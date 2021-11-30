package az.spring3.spring.controllers;

import az.spring3.spring.DAO.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/people")
public class PeopleControllers {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleControllers(PersonDAO personDAO){
        this.personDAO=personDAO;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.showById(id));
        return  "people/show";
    }

}
