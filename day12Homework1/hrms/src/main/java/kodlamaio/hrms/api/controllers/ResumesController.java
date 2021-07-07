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
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.entities.dtos.ResumeDto;

@RestController
@RequestMapping("/api/resumes")
public class ResumesController {

	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		this.resumeService = resumeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody ResumeDto resumeDto){
		return ResponseEntity.ok(resumeService.add(resumeDto));
	}
	
	@GetMapping("/getResumesById")
	public ResponseEntity<?> getResumesById(@Valid @RequestParam int resumeId){
		return ResponseEntity.ok(resumeService.getResumesById(resumeId));
	}
}
