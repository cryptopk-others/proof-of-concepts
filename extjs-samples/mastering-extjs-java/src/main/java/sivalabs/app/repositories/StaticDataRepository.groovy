/**
 * 
 */
package sivalabs.app.repositories

import groovy.sql.Sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sivalabs.app.entities.Actor;

/**
 * @author katsi02
 *
 */
@Repository
class StaticDataRepository {
	
	@Autowired
	javax.sql.DataSource dataSource;
	
	List<Actor> getActors()
	{
		Sql sql = new Sql(dataSource)
		List actors = []
		sql.rows("select actor_id as id, first_name as firstName, last_name as lastName, last_update as lastUpdate from actor").each { actor ->
			actors << new Actor(actor)
		}
		return actors
	}
}
