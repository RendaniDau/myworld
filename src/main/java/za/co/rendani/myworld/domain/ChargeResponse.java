package za.co.rendani.myworld.domain;

import java.util.Map;

public class ChargeResponse {
    public Source source;
    public String object;
    public String id;
    public String status;
    public String currency;
    public int amountInCents;
    public boolean liveMode;
    public Map<String, String> metadata;

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAmountInCents() {
        return amountInCents;
    }

    public void setAmountInCents(int amountInCents) {
        this.amountInCents = amountInCents;
    }

    public boolean isLiveMode() {
        return liveMode;
    }

    public void setLiveMode(boolean liveMode) {
        this.liveMode = liveMode;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "ChargeResponse{" +
                "source=" + source +
                ", object='" + object + '\'' +
                ", id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", currency='" + currency + '\'' +
                ", amountInCents=" + amountInCents +
                ", liveMode=" + liveMode +
                ", metadata=" + metadata +
                '}';
    }
}
