package backend.dto;

import java.util.UUID;

public class CheckCardDto {

    private UUID customerId;
    private UUID placeId;
    private Integer checks;
    private Integer delimiter;
    private int availableHits;
    private String styleId;

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getPlaceId() {
        return placeId;
    }

    public void setPlaceId(UUID placeId) {
        this.placeId = placeId;
    }

    public Integer getChecks() {
        return checks;
    }

    public void setChecks(Integer checks) {
        this.checks = checks;
    }

    public Integer getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(Integer delimiter) {
        this.delimiter = delimiter;
    }

    public int getAvailableHits() {
        return availableHits;
    }

    public void setAvailableHits(int availableHits) {
        this.availableHits = availableHits;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }
}
