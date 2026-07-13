package jenkins_demo.jenkins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenkinsController {

    @GetMapping("/jenkis")
    public String index() {
        return "Hello Jenkins!!!!";
    }
}
