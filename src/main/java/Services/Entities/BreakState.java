package Services.Entities;

import Data.DBContract;
import Services.Common.MyModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by martin-valdez on 20/10/15.
 */
@Entity
@Table(name = DBContract.BREAKSTATES_TABLE)
public class BreakState implements MyModel{

    @Id
    @GeneratedValue
    private int breakStateId;
    private String name;
    private String description;

    public int getBreakStateId() {
        return breakStateId;
    }

    public void setBreakStateId(int breakStateId) {
        this.breakStateId = breakStateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getId() {
        return getBreakStateId();
    }
}
