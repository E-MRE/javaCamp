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
import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.entities.concretes.Experience;

@RestController
@RequestMapping(value="/api/experiences")
public class ExperiencesController {

	private ExperienceService experienceService;

	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		this.experienceService = experienceService;
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody Experience experience){
		return ResponseEntity.ok(experienceService.add(experience));
	}
	
	@GetMapping(value="/getExperiencesDescById")
	public ResponseEntity<?> getExperiencesDescById(@Valid @RequestParam int jobSeekerId){
		return ResponseEntity.ok(experienceService.getExperiencesDescById(jobSeekerId));
	}
}
