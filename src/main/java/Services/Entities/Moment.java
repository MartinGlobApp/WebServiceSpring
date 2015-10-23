package Services.Entities;

import Data.DBContract;
import Services.Common.MyModel;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by martin-valdez on 20/10/15.
 */
@Entity
@Table(name = DBContract.MOMENT_TABLE)
public class Moment implements MyModel{

    @Id
    @GeneratedValue
    private int momentId;

    @OneToMany(mappedBy = "moment", cascade = CascadeType.ALL)
    private List<Break> breakList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DBContract.WORKER_COLUMN_ID)
    private Worker worker;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DBContract.PURCHASEORDER_COLUMN_ID)
    private PurchaseOrder purchaseOrder;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DBContract.MOMENTSTATE_COLUMN_ID)
    private MomentState momentState;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DBContract.STATION_COLUMN_ID)
    private Station station;

    private Date starDate;
    private Date endDate;

    public int getMomentoId() {
        return momentId;
    }

    public void setMomentoId(int momentoId) {
        this.momentId = momentoId;
    }

    public List<Break> getBreakList() {
        return breakList;
    }

    public void setBreakList(List<Break> breakList) {
        this.breakList = breakList;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public PurchaseOrder getOrder() {
        return purchaseOrder;
    }

    public void setOrder(PurchaseOrder order) {
        this.purchaseOrder = order;
    }

    public MomentState getMomentState() {
        return momentState;
    }

    public void setMomentState(MomentState momentState) {
        this.momentState = momentState;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public int getId() {
        return getMomentoId();
    }
}
