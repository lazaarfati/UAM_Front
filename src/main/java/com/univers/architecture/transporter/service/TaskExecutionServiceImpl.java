/**
 * 
 */
package com.univers.architecture.transporter.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.univers.architecture.transporter.dao.ITaskExecutionRepository;
import com.univers.architecture.transporter.model.TaskExecution;

/**
 * @author sabir
 *
 */
@Service
public class TaskExecutionServiceImpl implements ITaskExecutionService {

	private static final Logger log = LoggerFactory.getLogger(TaskExecutionServiceImpl.class);

	@Autowired
	private ITaskExecutionRepository taskExecutionRepository;

	@Override
	public List<TaskExecution> getAllTaskExecution() {

		log.warn("Loading all taskExecution ! be careful about performance");

		return (List<TaskExecution>) this.taskExecutionRepository.findAll();
	}
	@Override
	public Page<TaskExecution> listTaskExecution(int page, int size) {

		log.warn("Loading all taskExecution ! be careful about performance");
		Pageable pageable = PageRequest.of(page, size);
		Page<TaskExecution> taskExecutionEntityPage;
			taskExecutionEntityPage = this.taskExecutionRepository.findAll(pageable);

		return taskExecutionEntityPage;
	}
	
	@Override
	public List<TaskExecution> listTaskExecutionByColonne(int page, int size,String sortBy) {

		log.warn("Loading all taskExecution ! be careful about performance");
		Pageable pageable = PageRequest.of(page, size,Sort.by(sortBy).ascending());
		Page<TaskExecution> taskExecutionEntityPage;
			taskExecutionEntityPage = this.taskExecutionRepository.findAll(pageable);

		return taskExecutionEntityPage.getContent();
	}
	
	

}
