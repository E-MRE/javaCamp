package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeeker>> getAll(){
		return jobSeekerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker) {
		return jobSeekerService.add(jobSeeker);
	}
	
	@GetMapping("/getResumeById")
	public ResponseEntity<?> getResumeById(@Valid @RequestParam int jobSeekerId){
		return ResponseEntity.ok(null/*jobSeekerService.getResumeById(jobSeekerId)*/);
	}
}
