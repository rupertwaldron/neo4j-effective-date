package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RelationshipEntity(type = "HAS_VERSION")
public class Versioned {

    @Id
    @GeneratedValue
	private Long id;
	private List<Integer> versions = new ArrayList<>();

	@StartNode
	private EppNodeEntity nodeEntity;

	@EndNode
	private Version version;

	public Versioned(EppNodeEntity nodeEntity, Version version) {
		this.nodeEntity = nodeEntity;
		this.version = version;
	}

	public Versioned() {
	}

	public Long getId() {
	    return id;
	}

	public List<Integer> getVersions() {
	    return versions;
	}

	public Version getVersion() {
	    return version;
	}

	public EppNodeEntity getNodeEntity() {
	    return nodeEntity;
	}

    public void addVersionName(Integer name) {
        if (this.versions == null) {
            this.versions = new ArrayList<>();
        }
        this.versions.add(name);
    }
}