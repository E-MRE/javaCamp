package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerLanguageService;
import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;

@RestController
@RequestMapping("/api/jobSeekerLanguages")
public class JobSeekerLanguagesController {

	private JobSeekerLanguageService languageService;

	@Autowired
	public JobSeekerLanguagesController(JobSeekerLanguageService languageService) {
		this.languageService = languageService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(JobSeekerLanguage jobSeekerLanguage){
		return ResponseEntity.ok(languageService.add(jobSeekerLanguage));
	}
}
