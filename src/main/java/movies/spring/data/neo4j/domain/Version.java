package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

import java.time.LocalDateTime;

public class Version {
    @Id
    @GeneratedValue
    private Long id;
    private Integer value;
    private LocalDateTime timestamp;

    public Version(Integer value, LocalDateTime timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return String.format("version %d %s", value, timestamp);
    }

    public Integer getValue() {
        return value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
