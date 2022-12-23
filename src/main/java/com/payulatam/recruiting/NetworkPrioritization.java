package com.payulatam.recruiting;
import java.util.*;

public class NetworkPrioritization {

    private static final int ZERO = 0;

    public enum Criteria {
        RESPONSE_TIME, COST;
    }

    private List<PaymentNetwork> filligPaymentNetworks(int[] responseTimes, int[] cost){
        List<PaymentNetwork> paymentNetworks = new ArrayList<>();
        for (int paymentNetwork = ZERO; paymentNetwork < responseTimes.length; paymentNetwork++) {
            paymentNetworks.add(new PaymentNetwork(responseTimes[paymentNetwork], cost[paymentNetwork], paymentNetwork));
        }
        return paymentNetworks;
    }


    public int[] prioritizeNetwork(int[] responseTimes, int[] cost, Criteria priority) {
        List<PaymentNetwork> paymentNetworks = this.filligPaymentNetworks(responseTimes,cost);

        switch (priority) {
            case RESPONSE_TIME: {
                paymentNetworks.sort(Comparator.comparing(PaymentNetwork::getResponseTime).thenComparing(PaymentNetwork::getCost));
                break;
            }
            case COST: {
                paymentNetworks.sort(Comparator.comparing(PaymentNetwork::getCost).thenComparing(PaymentNetwork::getResponseTime));
                break;
            }
        }
        return paymentNetworks.stream().mapToInt(PaymentNetwork::getPosition).toArray();
    }

}
