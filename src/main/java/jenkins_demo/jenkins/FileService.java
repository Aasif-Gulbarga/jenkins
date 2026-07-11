package jenkins_demo.jenkins;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.TextDocumentManager;
import com.marklogic.client.io.StringHandle;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
public class FileService {

    private final DatabaseClient client;

    public FileService(DatabaseClient client) {
        this.client = client;
    }

    public String uploadTextFile() throws Exception {

        try (
            InputStream inputStream =
                 getClass().getClassLoader().getResourceAsStream("sample.txt")) {

            if (inputStream == null) {
                return "sample.txt not found in resources folder";
            }

            String content = new String(
                inputStream.readAllBytes(),
                StandardCharsets.UTF_8
            );

            TextDocumentManager manager = client.newTextDocumentManager();

            manager.write(
                "/files/sample.txt",
                new StringHandle(content)
            );

            return "Text file uploaded successfully.";
        }
    }
}
