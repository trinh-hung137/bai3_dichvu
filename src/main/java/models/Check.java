package models;

import java.io.Serializable;

public class Check implements Serializable {
    private String id;
    private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    public void setId(String id) {
        this.id = id;
    }
    public Check(){

    }
    @Override
    public String toString() {
        return "Check{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                '}';
    }
}
