package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Company;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 * @author pdtyreus
 * @author Mark Angrish
 */
public interface CompanyRepository extends Neo4jRepository<Company, Long> {

    Company findByName(String name);

    @Query("MATCH (c:Company)<-[o:OWNED_BY]-(s:Shop) RETURN c,o,s LIMIT {limit}")
    Collection<Company> graph(@Param("limit") int limit);

    @Query("MATCH (c:Company)<-[o:HAS_VERSION]-(v:Version) RETURN c,o,v LIMIT {limit}")
    Collection<Company> versionGraph(@Param("limit") int limit);

}