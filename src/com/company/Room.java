package com.company;

public class Room {
    private int id;
    private String type;
    private int bedAmount;
    private boolean smokable;
    private boolean bookable;
    private int cost;
    private String details;

    public Room(int id, String type, int bedAmount, boolean smokable, boolean bookable, int cost, String details) {
        this.id = id;
        this.type = type;
        this.bedAmount = bedAmount;
        this.smokable = smokable;
        this.bookable = bookable;
        this.cost = cost;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBedAmount() {
        return bedAmount;
    }

    public void setBedAmount(int bedAmount) {
        this.bedAmount = bedAmount;
    }

    public boolean isSmokable() {
        return smokable;
    }

    public void setSmokable(boolean smokable) {
        this.smokable = smokable;
    }

    public boolean isBookable() {
        return bookable;
    }

    public void setBookable(boolean bookable) {
        this.bookable = bookable;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
