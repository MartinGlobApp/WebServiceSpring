package Services.Entities;

import Data.DBContract;
import Services.Common.MyModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by martin-valdez on 19/10/15.
 */

@Entity
@Table(name = DBContract.WORKER_TABLE)
public class Worker implements MyModel{

    @Id
    @GeneratedValue
    private int workerId;
    private String name;
    private String lastName;

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int getId() {
        return getWorkerId();
    }
}
