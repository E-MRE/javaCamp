package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.ProgrammingSkillService;
import kodlamaio.hrms.entities.concretes.ProgrammingSkill;

@RestController
@RequestMapping("/api/programmingSkills")
public class ProgrammingSkillsController {

	private ProgrammingSkillService skillService;

	@Autowired
	public ProgrammingSkillsController(ProgrammingSkillService skillService) {
		this.skillService = skillService;
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody ProgrammingSkill skill) {
		return ResponseEntity.ok(skillService.add(skill));
	}
}
