package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
@CrossOrigin
public class JobPositionsController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition> > getAll(){
		return jobPositionService.getAll();
	}
	
	@GetMapping("/getActiveJobPositions")
	public DataResult<List<JobPosition>> getActiveJobPositions(){
		return jobPositionService.getActiveJobPositions();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody JobPosition jobPosition) {
		return ResponseEntity.ok(jobPositionService.add(jobPosition));
	}
	
	@GetMapping("/getActiveJobPositionsByCreationDate")
	public DataResult<List<JobPosition>> getActiveJobPositionsByCreationDate(@RequestParam String creationDate){
		return jobPositionService.getActiveJobPositionsByCreationDate(creationDate);
	}
	
	@GetMapping("/getActivePositionsSorted")
	public DataResult<List<JobPosition>> getActiveJobPositionsSorted(@RequestParam boolean isDesc){
		return jobPositionService.getActiveJobPositionsSorted(isDesc);
	}
	
	@GetMapping("/getActivePositionsByCompany")
	public DataResult<List<JobPosition>> getActivePositionsByCompany(@RequestParam String companyName){
		return jobPositionService.getActiveJobPositionsByCompanyName(companyName);
	}
	
	@PostMapping("/updateJobPositionStatus")
	public Result updateJobPositionStatus(@RequestParam int positionId, @RequestParam boolean isActive) {
		return jobPositionService.updateJobPositionStatus(positionId, isActive);
	}
	
	@GetMapping("/getActivePositionsByEmployerId")
	public ResponseEntity<DataResult<List<JobPosition>>> getActivePositionsByEmployerId(@Valid @RequestParam int employerId){
		return ResponseEntity.ok(jobPositionService.getActivePositionsByEmployerId(employerId));
	}
	
	@GetMapping("/getAllPositionsByEmployerId")
	public ResponseEntity<DataResult<List<JobPosition>>> getAllPositionsByEmployerId(@Valid @RequestParam int employerId){
		return ResponseEntity.ok(jobPositionService.getAllPositionsByEmployerId(employerId));
	}
}
