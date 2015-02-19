/**
 * 
 */
package com.sivalabs.bootsample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author user
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

}
