package backend.dto;

import java.util.UUID;

public class PlaceDto {

    private UUID id;

    private String name;

    private Integer delimiter;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(Integer delimiter) {
        this.delimiter = delimiter;
    }
}
