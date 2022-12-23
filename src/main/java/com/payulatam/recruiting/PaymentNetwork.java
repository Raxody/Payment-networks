package com.payulatam.recruiting;

public class PaymentNetwork {
    private int responseTime;
    private int cost;
    private int position;

    public PaymentNetwork(int responseTime, int cost, int position) {
        this.responseTime = responseTime;
        this.cost = cost;
        this.position = position;
    }

    public int getResponseTime() {
        return responseTime;
    }
    public int getCost() {
        return cost;
    }
    public int getPosition() {
        return position;
    }

}
