package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public abstract class EppNodeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Relationship(type = "HAS_VERSION")
    private List<Version> versions;

    public Long getId() {
        return id;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public void addVersion(Version version) {
        if (this.versions == null) {
            this.versions = new ArrayList<>();
        }
        this.versions.add(version);
    }
}
