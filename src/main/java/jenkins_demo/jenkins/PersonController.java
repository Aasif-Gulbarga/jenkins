package jenkins_demo.jenkins;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {


    private final PersonService service;


    public PersonController(PersonService service) {
        this.service = service;
    }


    @PostMapping
    public String save() {

        return service.savePerson();
    }


    @GetMapping
    public String get() {

        return service.getPerson();
    }

}
