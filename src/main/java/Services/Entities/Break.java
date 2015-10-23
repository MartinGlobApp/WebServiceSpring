package Services.Entities;

import Data.DBContract;
import Services.Common.MyModel;

import javax.persistence.*;

/**
 * Created by martin-valdez on 20/10/15.
 */
@Entity
@Table(name = DBContract.BREAK_TABLE)
public class Break implements MyModel{

    @Id
    @GeneratedValue
    private int breakId;

    @ManyToOne
    @JoinColumn(name = DBContract.BREAK_COLUMN_ID)
    private BreakType breakType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DBContract.BREAKSTATES_COLUMN_ID)
    private BreakState breakState;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DBContract.MOMENT_COLUMN_ID)
    private Moment moment;

    private String detail;

    public int getBreakId() {
        return breakId;
    }

    public void setBreakId(int breakId) {
        this.breakId = breakId;
    }

    public BreakType getBreakType() {
        return breakType;
    }

    public void setBreakType(BreakType breakType) {
        this.breakType = breakType;
    }

    public BreakState getBreakState() {
        return breakState;
    }

    public void setBreakState(BreakState breakState) {
        this.breakState = breakState;
    }

    public Moment getMoment() {
        return moment;
    }

    public void setMoment(Moment moment) {
        this.moment = moment;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public int getId() {
        return getBreakId();
    }
}
