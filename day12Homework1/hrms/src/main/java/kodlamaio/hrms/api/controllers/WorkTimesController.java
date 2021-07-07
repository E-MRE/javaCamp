package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTimeService;

@RestController
@RequestMapping("/api/worktimes")
@CrossOrigin
public class WorkTimesController {

	private WorkTimeService workTimeService;

	@Autowired
	public WorkTimesController(WorkTimeService workTimeService) {
		this.workTimeService = workTimeService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(workTimeService.getAll());
	}
}
