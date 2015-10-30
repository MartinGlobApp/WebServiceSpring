package Services.Controllers;

import Data.DBContract;
import Data.MyResponse;
import Data.RequestContract;
import Services.Entities.Cart;
import Services.Entities.Document;
import Services.Services.CartService;
import Services.Services.DocumentService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by martin-valdez on 22/10/15.
 */
@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping(value = RequestContract.INSERT_DOCUMENT, method = RequestMethod.POST)
    public MyResponse insertDocument(@RequestBody final MultipartFile file) {
            return  documentService.insert(file);
    }

    @RequestMapping(RequestContract.GET_ONE_DOCUMENT)
    public MyResponse getDocument(@RequestParam(value = DBContract.DOCUMENTS_COLUMN_ID, defaultValue = "0") final int documentId){
        return documentService.getOne(documentId);
    }

    @RequestMapping(RequestContract.GET_ALL_DOCUMENT)
    public MyResponse getListAllDocument(){
        return documentService.getListAll();
    }
}
