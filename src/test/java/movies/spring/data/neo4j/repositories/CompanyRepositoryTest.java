package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @author pdtyreus
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class CompanyRepositoryTest {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private ShopRepository shopRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Before
	public void setUp() {
		Address theMeads = new Address("The Meads", "GU10 1XT");
		Company boots = new Company("Boots");
		Shop farnborough = new Shop("Farnborough", theMeads);

		Own ownedBy = new Own(farnborough, boots);
		boots.addOwn(ownedBy);

		Version version1 = new Version(1, LocalDateTime.now());
		Version version2 = new Version(2, LocalDateTime.now());
		Versioned bootsVersion = new Versioned(boots, version1);
		bootsVersion.addVersionName(version1.getValue());
		bootsVersion.addVersionName(version2.getValue());

		boots.addVersion(version1);
		boots.addVersion(version2);

		addressRepository.save(theMeads);
		companyRepository.save(boots);
		shopRepository.save(farnborough);

	}

	@Test
	public void testGetVersions() {
		assertEquals(2, companyRepository.findByName("Boots").getVersions().size());
	}

	@Test
	public void testFindByShopName() {
		String shopName = "Farnborough";
		Shop result = shopRepository.findByName(shopName);
		assertEquals(shopName, result.getName());
	}

	@Test
	public void testFindByCompanyName() {
		String companyName = "Boots";
		Company result = companyRepository.findByName(companyName);
		assertEquals(companyName, result.getName());
	}

	@Test
	public void testFindByPostCode() {
		String postCode = "GU10 1XT";
		Address result = addressRepository.findByPostCode(postCode);
		assertEquals(postCode, result.getPostCode());
	}

	@Test
	public void testGraph() {
		Collection<Company> graph = companyRepository.graph(5);

		assertEquals(1, graph.size());

		Company company = graph.iterator().next();

		assertEquals(1, company.getOwns().size());

		assertEquals("Boots", company.getName());
		assertEquals("Farnborough", company.getOwns().iterator().next().getShop().getName());
	}

	@Test
	public void testVersion() {
		Collection<Company> graph = companyRepository.versionGraph(5);

		assertEquals(1, graph.size());

		Company company = graph.iterator().next();

		assertEquals(2, company.getVersions().size());

		assertEquals(java.util.Optional.of(1), company.getVersions().get(0).getValue());
	}
}