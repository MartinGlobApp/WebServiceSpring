package Services.Entities.dummies;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by martin-valdez on 30/10/15.
 */
public class MyFile {

    private String name;
    private MultipartFile file;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
