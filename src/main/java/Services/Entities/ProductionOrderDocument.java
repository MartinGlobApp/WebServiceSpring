package Services.Entities;

import Data.DBContract;

import javax.persistence.*;

/**
 * Created by martin-valdez on 30/10/15.
 */
@Entity
@Table(name = DBContract.PRODUCTIONORDERDOCUMENTS_TABLE)
public class ProductionOrderDocument {

    @Id
    @GeneratedValue
    private int productionOrderDocumentId;

    @Basic(optional = false)
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = DBContract.PRODUCTIONORDER_COLUMN_ID)
    private ProductionOrder productionOrder;

    @Basic(optional = false)
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = DBContract.DOCUMENTS_COLUMN_ID)
    private Document document;

    public int getProductionOrderDocumentId() {
        return productionOrderDocumentId;
    }

    public void setProductionOrderDocumentId(int productionOrderDocumentId) {
        this.productionOrderDocumentId = productionOrderDocumentId;
    }

    public ProductionOrder getProductionOrder() {
        return productionOrder;
    }

    public void setProductionOrder(ProductionOrder productionOrder) {
        this.productionOrder = productionOrder;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
