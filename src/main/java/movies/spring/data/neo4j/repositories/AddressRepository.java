package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Address;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author pdtyreus
 * @author Mark Angrish
 */
public interface AddressRepository extends Neo4jRepository<Address, Long> {

    Address findByPostCode(String postCode);

}