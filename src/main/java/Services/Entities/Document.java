package Services.Entities;

import Data.DBContract;
import Services.Common.MyModel;

import javax.persistence.*;

/**
 * Created by martin-valdez on 28/10/15.
 */
@Entity
@Table(name = DBContract.DOCUMENTS_TABLE)
public class Document implements MyModel{

    @Id
    @GeneratedValue
    private int documentId;
    private String name;
    private String url;

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int getId() {
        return getDocumentId();
    }
}
