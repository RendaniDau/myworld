package za.co.rendani.myworld.domain;

import java.io.Serializable;

public class ProcessPaymentRequest implements Serializable {

    private Long orderId;
    private String paymentReferenceId;
    private Integer amountInCents;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getPaymentReferenceId() {
        return paymentReferenceId;
    }

    public void setPaymentReferenceId(String paymentReferenceId) {
        this.paymentReferenceId = paymentReferenceId;
    }

    public Integer getAmountInCents() {
        return amountInCents;
    }

    public void setAmountInCents(Integer amountInCents) {
        this.amountInCents = amountInCents;
    }

    @Override
    public String toString() {
        return "ProcessPaymentRequest{" +
                "orderId=" + orderId +
                ", paymentReferenceId='" + paymentReferenceId + '\'' +
                ", amountInCents=" + amountInCents +
                '}';
    }
}
