package jenkins_demo.jenkins.config;

import com.marklogic.client.DatabaseClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final DatabaseClient client;

    public TestController(DatabaseClient client) {
        this.client = client;
    }


    @GetMapping
    public String test() {

        return "MarkLogic Connected";
    }
}
