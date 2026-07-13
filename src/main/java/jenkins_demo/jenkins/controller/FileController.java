package jenkins_demo.jenkins.controller;

import jenkins_demo.jenkins.service.FileService;
import jenkins_demo.jenkins.service.XmlService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

    private final FileService service;
    private final XmlService xmlservice;

    public FileController(FileService service, XmlService xmlservice) {
        this.service = service;
        this.xmlservice = xmlservice;
    }

    @PostMapping("text/upload")
    public String upload() throws Exception {

        return service.uploadTextFile();
    }

    @PostMapping("xml/upload")
    public String uploadxml() {

        return xmlservice.uploadXml();
    }
}
