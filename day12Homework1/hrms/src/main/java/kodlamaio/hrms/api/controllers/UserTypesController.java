package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UserTypeService;
import kodlamaio.hrms.entities.concretes.UserType;

@RestController
@RequestMapping("/api/usertypes")
@CrossOrigin
public class UserTypesController {

	private UserTypeService userTypeService;

	@Autowired
	public UserTypesController(UserTypeService userTypeService) {
		this.userTypeService = userTypeService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(userTypeService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody UserType userType){
		return ResponseEntity.ok(userTypeService.add(userType));
	}
}
