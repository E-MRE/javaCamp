package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.entities.concretes.Education;

@RestController
@RequestMapping(value="/api/educations")
public class EducationsController {

	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		this.educationService = educationService;
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody Education education) {
		return ResponseEntity.ok(educationService.add(education));
	}
	
	@GetMapping("/getSchoolsAscById")
	public ResponseEntity<?> getSchoolsDescById(@RequestParam int jobSeekerId){
		return ResponseEntity.ok(educationService.getSchoolsDescById(jobSeekerId));
	}
}
