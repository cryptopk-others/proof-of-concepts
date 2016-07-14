/**
 * 
 */
package demo;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Siva
 *
 */
@Repository
public interface ProductRepository extends SolrCrudRepository<Product, String>
{

	List<Product> findByName(String name);

}
