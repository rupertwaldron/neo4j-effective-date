package movies.spring.data.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

public class Company extends EppNodeEntity {

	private String name;
	private int released;
	private String tagline;

	@JsonIgnoreProperties("company")
	@Relationship(type = "OWNED_BY", direction = Relationship.INCOMING)
	private List<Own> owns;

	public Company(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Own> getOwns() {
		return owns;
	}

	public void addOwn(Own own) {
		if (this.owns == null) {
			this.owns = new ArrayList<>();
		}
		this.owns.add(own);
	}
}