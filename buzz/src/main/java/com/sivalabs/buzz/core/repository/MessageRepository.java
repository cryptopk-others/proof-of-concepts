/**
 * 
 */
package com.sivalabs.buzz.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.buzz.core.entity.Message;

/**
 * @author Siva
 *
 */
public interface MessageRepository extends JpaRepository<Message, Integer>
{

	Page<Message> findByCreatedById(int userId, Pageable pageable);

}
