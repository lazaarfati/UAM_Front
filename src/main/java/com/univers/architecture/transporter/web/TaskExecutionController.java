/**
 * 
 */
package com.univers.architecture.transporter.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.univers.architecture.transporter.model.TaskExecution;
import com.univers.architecture.transporter.service.ITaskExecutionService;

/**
 * @author sabir
 *
 */
@RestController
@RequestMapping("/api")
public class TaskExecutionController {

	private static final String DEFAULT_PAGE_NUM = "0";
	private static final String DEFAULT_PAGE_SIZE = "7";
	
	@Autowired
	private ITaskExecutionService taskExecutionService;

	@GetMapping("/taskExecution")
	public List<TaskExecution> getAllTaskExecutions() {
		return this.taskExecutionService.getAllTaskExecution();
	}
	@RequestMapping(value = "/taskExecutionList", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<TaskExecution>> listTaskExecution(
			@RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE_NUM) int page,
			@RequestParam(value = "size", required = false, defaultValue = DEFAULT_PAGE_SIZE) int size
			)
			 {
		Page<TaskExecution> taskExecutionPage = this.taskExecutionService.listTaskExecution(page, size);
		return new ResponseEntity<Page<TaskExecution>>(taskExecutionPage, new HttpHeaders(), HttpStatus.OK);
	}
	@RequestMapping(value = "/taskExecutionListByColonne", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<TaskExecution>> listTaskExecutionByColonne(
			@RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE_NUM) int page,
			@RequestParam(value = "size", required = false, defaultValue = DEFAULT_PAGE_SIZE) int size,
			@RequestParam(value = "sortBy", required = false, defaultValue = DEFAULT_PAGE_SIZE) String sortBy
			)
			 {
		List<TaskExecution> taskExecutionPage = this.taskExecutionService.listTaskExecutionByColonne(page, size, sortBy);
		return new ResponseEntity<List<TaskExecution>>(taskExecutionPage, new HttpHeaders(), HttpStatus.OK);
	}
}
