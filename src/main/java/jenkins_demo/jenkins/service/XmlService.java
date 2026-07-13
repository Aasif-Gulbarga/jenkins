package jenkins_demo.jenkins.service;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.StringHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
public class XmlService {

    private static final Logger log = LoggerFactory.getLogger(XmlService.class);
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
            log.error("Error uploading XML", e);
                return e.getMessage();
            }
        }
}