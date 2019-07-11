package movies.spring.data.neo4j.domain;


public class Address extends EppNodeEntity {

	private String lineOne;
	private String postCode;

	public Address(String lineOne, String postCode) {
		this.lineOne = lineOne;
		this.postCode = postCode;
	}

	public String getLineOne() {
		return lineOne;
	}

	public String getPostCode() {
		return postCode;
	}
}