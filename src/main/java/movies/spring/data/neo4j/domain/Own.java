package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark Angrish
 */
@RelationshipEntity(type = "OWNED_BY")
public class Own {

    @Id
    @GeneratedValue
	private Long id;
	private List<String> owners = new ArrayList<>();

	@StartNode
	private Shop shop;

	@EndNode
	private Company company;

	public Own(Shop shop, Company company) {
		this.shop = shop;
		this.company = company;
	}

	public Long getId() {
	    return id;
	}

	public List<String> getOwners() {
	    return owners;
	}

	public Shop getShop() {
	    return shop;
	}

	public Company getCompany() {
	    return company;
	}

    public void addOwnerName(String name) {
        if (this.owners == null) {
            this.owners = new ArrayList<>();
        }
        this.owners.add(name);
    }
}