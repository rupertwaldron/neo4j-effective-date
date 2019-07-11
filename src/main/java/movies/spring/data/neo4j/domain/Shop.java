package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.Relationship;

public class Shop extends EppNodeEntity{

	private String name;

	@Relationship(type = "HAS_ADDRESS")
	private Address address;

	@Relationship(type = "IS_OWNED_BY")
	private Company company;

	public Shop(String name, Address address) {
		this.name = name;
		this.address = address;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}