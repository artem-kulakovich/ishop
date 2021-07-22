package by.bntu.fitr.entity;

public class Order {
    private int id;
    private double cost;
    private String info;
    private String date;
    private int consumer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getConsumer() {
        return consumer;
    }

    public void setConsumer(int consumer) {
        this.consumer = consumer;
    }
}
