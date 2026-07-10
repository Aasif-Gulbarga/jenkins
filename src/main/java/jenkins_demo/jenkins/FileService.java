package jenkins_demo.jenkins;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.TextDocumentManager;
import com.marklogic.client.io.StringHandle;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    private final DatabaseClient client;

    public FileService(DatabaseClient client) {
        this.client = client;
    }

    public String uploadTextFile() throws Exception {

        // Physical file path
        Path path = Paths.get("C:/Demo_Projects/sample.txt");

        // Read file content
        String content = Files.readString(path);

        // Save to MarkLogic
        TextDocumentManager manager = client.newTextDocumentManager();

        manager.write(
            "/files/sample.txt",
            new StringHandle(content)
        );

        return "File uploaded successfully.";
    }
}
