package jenkins_demo.jenkins;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.StringHandle;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
public class XmlService {

    private final DatabaseClient client;

    public XmlService(DatabaseClient client) {
        this.client = client;
    }

    public String uploadXml() {

        try (
            InputStream inputStream =
                 getClass().getClassLoader().getResourceAsStream("employees.xml")) {

            if (inputStream == null) {
                return "employees.xml not found in resources folder";
            }

            String xml = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

            XMLDocumentManager manager = client.newXMLDocumentManager();

            manager.write(
                "/employees/employees.xml",
                new StringHandle(xml)
            );

            return "XML uploaded successfully.";

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}