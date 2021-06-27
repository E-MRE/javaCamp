package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
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
	public Result add(@RequestBody JobPosition jobPosition) {
		return jobPositionService.add(jobPosition);
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
}
