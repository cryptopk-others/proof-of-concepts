/**
 * 
 */
package sivalabs.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sivalabs.app.entities.Category;

/**
 * @author katsi02
 *
 */
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
