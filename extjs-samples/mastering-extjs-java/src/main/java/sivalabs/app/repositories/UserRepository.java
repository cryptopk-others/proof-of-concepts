package sivalabs.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sivalabs.app.entities.User;

/**
 * @author Siva
 * 
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);

	User findByEmailAndPassword(String email, String password);

	User findByUserNameAndPassword(String userName, String password);

}
