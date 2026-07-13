package jenkins_demo.jenkins.service;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.io.StringHandle;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final DatabaseClient client;

    public PersonService(DatabaseClient client) {
        this.client = client;
    }


    public String savePerson() {

        JSONDocumentManager manager =
            client.newJSONDocumentManager();


        String json = """
                {
                  "id": "101",
                  "name": "John",
                  "age": 30
                }
                """;


        manager.write(
            "/person/101.json",
            new StringHandle(json)
        );


        return "Document Saved";
    }


    public String getPerson() {

        JSONDocumentManager manager =
            client.newJSONDocumentManager();

        StringHandle handle = new StringHandle();

        manager.read(
            "/person/101.json",
            handle
        );


        return handle.get();
    }
}