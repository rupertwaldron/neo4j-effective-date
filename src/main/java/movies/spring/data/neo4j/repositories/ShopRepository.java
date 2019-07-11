package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Shop;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author pdtyreus
 * @author Mark Angrish
 */
public interface ShopRepository extends Neo4jRepository<Shop, Long> {

    Shop findByName(String name);

}