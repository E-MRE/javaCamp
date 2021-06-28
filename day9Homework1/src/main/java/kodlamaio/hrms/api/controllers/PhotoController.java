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
import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.entities.concretes.Photo;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {
	
	private PhotoService photoService;

	@Autowired
	public PhotoController(PhotoService photoService) {
		this.photoService = photoService;
	}


	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Photo photo){
		return ResponseEntity.ok(photoService.add(photo));
	}
	
	@GetMapping("/getJobSeekerPhotoById")
	public ResponseEntity<?> getJobSeekerPhotoById(@RequestParam int jobSeekerId){
		return ResponseEntity.ok(photoService.getJobSeekerPhotoById(jobSeekerId));
	}
	
	@GetMapping("/getPhotoById")
	public ResponseEntity<?> getPhotoById(@RequestParam int photoId){
		return ResponseEntity.ok(photoService.getPhotoById(photoId));
	}
}
