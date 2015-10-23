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
@Table(name = DBContract.BREAKTYPE_TABLE)
public class BreakType implements MyModel{

    @Id
    @GeneratedValue
    private int breakTypeId;
    private String name;
    private String description;

    public int getBreakTypeId() {
        return breakTypeId;
    }

    public void setBreakTypeId(int breakTypeId) {
        this.breakTypeId = breakTypeId;
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
        return getBreakTypeId();
    }
}
