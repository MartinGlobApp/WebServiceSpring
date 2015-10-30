package Services.Services;

import Data.MyResponse;
import Data.RequestContract;
import Data.ResponseStates;
import Services.Common.BasicService;
import Services.Entities.Document;
import Services.Repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by martin-valdez on 22/10/15.
 */
@Service(value = RequestContract.DOCUMENT_SERVICE_NAME)
public class DocumentService extends BasicService {

    @Autowired
    private DocumentRepository documentRepository;

    public MyResponse insert(final MultipartFile newFile){
        MyResponse response = new MyResponse();
        if(!newFile.isEmpty()){
            try{
                byte[] bytes = newFile.getBytes();
                File dir = new File("Files");
                if(!dir.exists()){
                    dir.mkdirs();
                }

                File serverFile = new File(dir.getAbsolutePath() + File.separator + newFile.getOriginalFilename());
                if(!serverFile.exists()){
                    Document newDocument = new Document();
                    newDocument.setName(newFile.getOriginalFilename());
                    newDocument.setUrl(serverFile.getAbsolutePath());
                    response = insert(newDocument);
                }

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

            }catch (Exception ex){
                response.setCode(ResponseStates.ERROR_DATA_DOCUMENT);
                response.setData(ex.toString());
            }
        }else{
            response.setCode(ResponseStates.ERROR_DATA_DOCUMENT);
            response.setData("NULL Document");
        }

        return response;
        }

    public MyResponse getOne(final int id){
        MyResponse response = new MyResponse();
        try {
            Document document = (Document) documentRepository.getOne(id);
            byte[] bytes = loadFile(new File(document.getUrl()));
            response.setData(bytes);
            response.setCode(ResponseStates.DONE);
        } catch (Exception e) {
            response.setCode(ResponseStates.ERROR_DB);
            response.setData(e.toString());
        }
        return response;
    }

    public MyResponse getListAll(){
        MyResponse response = new MyResponse();
        try {
            response.setData(documentRepository.getListAll());
            response.setCode(ResponseStates.DONE);
        } catch (Exception e) {
            response.setCode(ResponseStates.ERROR_DB);
            response.setData(e.toString());
        }
        return response;
    }

    private byte[] loadFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        byte[] bytes = new byte[(int)length];
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }
        is.close();
        return bytes;
    }
}
