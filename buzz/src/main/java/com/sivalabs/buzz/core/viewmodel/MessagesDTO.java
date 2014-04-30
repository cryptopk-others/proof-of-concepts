/**
 * 
 */
package com.sivalabs.buzz.core.viewmodel;

import java.util.List;

import lombok.Data;

import com.sivalabs.buzz.core.entity.Message;

/**
 * @author Siva
 *
 */
@Data
public class MessagesDTO
{
	private List<Message> messages;
	private boolean hasNext;
	private boolean hasPrevious;
	private int currentPage;
}
