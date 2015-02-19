/**
 * 
 */
package sivalabs.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sivalabs.app.entities.Country;

/**
 * @author katsi02
 *
 */
public interface CountryRepository extends JpaRepository<Country, Integer>{

}
