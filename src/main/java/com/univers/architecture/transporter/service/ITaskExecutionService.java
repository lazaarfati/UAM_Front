/**
 * 
 */
package com.univers.architecture.transporter.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.univers.architecture.transporter.model.TaskExecution;

/**
 * @author sabir
 *
 */
public interface ITaskExecutionService {

	public List<TaskExecution> getAllTaskExecution();

	Page<TaskExecution> listTaskExecution(int page, int size);

	List<TaskExecution> listTaskExecutionByColonne(int page, int size, String sortBy);
}
