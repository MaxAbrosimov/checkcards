package backend.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("customer_check_cards")
public class CheckCard {

    @PrimaryKey
    private CheckCardKey key;
    private int checks;
    private int delimiter;
    private String styleId;

    public CheckCardKey getKey() {
        return key;
    }

    public void setKey(CheckCardKey key) {
        this.key = key;
    }

    public int getChecks() {
        return checks;
    }

    public void setChecks(int checks) {
        this.checks = checks;
    }

    public int getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(int delimiter) {
        this.delimiter = delimiter;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }
}
