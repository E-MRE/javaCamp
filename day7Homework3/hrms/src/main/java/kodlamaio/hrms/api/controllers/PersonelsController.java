package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.PersonelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Personel;

@RestController
@RequestMapping("/api/personels")
public class PersonelsController {

	private PersonelService personelService;

	@Autowired
	public PersonelsController(PersonelService personelService) {
		this.personelService = personelService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Personel>> getAll(){
		return personelService.getAll();
	}
	
	@PostMapping("/verifyEmployerById")
	public Result verifyEmployerById(@RequestParam String email) {
		return personelService.veriftEmployer(email);
	}
}
