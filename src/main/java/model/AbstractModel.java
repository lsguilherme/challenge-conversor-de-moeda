package model;

import java.time.LocalDateTime;

public class AbstractModel {
    private final LocalDateTime searchAt;

    public AbstractModel() {
        this.searchAt = LocalDateTime.now();
    }

    public LocalDateTime getSearchAt() {
        return searchAt;
    }
}
