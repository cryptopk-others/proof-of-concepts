package sivalabs.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sivalabs.app.entities.Group;

/**
 * @author Siva
 * 
 */
public interface GroupRepository extends JpaRepository<Group, Integer>
{

}
