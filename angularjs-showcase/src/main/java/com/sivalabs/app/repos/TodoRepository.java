/**
*
*
*/
package com.sivalabs.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.app.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
