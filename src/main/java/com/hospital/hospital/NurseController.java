package com.hospital.hospital;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // This means that this class is a Controller
@RequestMapping("/nurse") // This means URL's start with /nurse
public class NurseController {

	private final NurseRepository nurseRepository;

	// Constructor: Spring gives us the repository
	public NurseController(NurseRepository nurseRepository) {
		this.nurseRepository = nurseRepository;
	}

	@PostMapping("/login")
	public ResponseEntity<Boolean> login(@RequestBody Nurse inputNurse) {
		
        Optional<Nurse> nurse = nurseRepository.findByUsernameAndPassword(
        		inputNurse.getUsername(),
        		inputNurse.getPassword()
        );
 
        boolean found = nurse.isPresent();
 
        
        return ResponseEntity
                .status(found ? HttpStatus.OK : HttpStatus.UNAUTHORIZED)
                .body(found);
	}

    // Get all nurses from the database
    @GetMapping("/index")
    public ResponseEntity<List<Nurse>> getAll() {
        return ResponseEntity.ok(nurseRepository.findAll());
    }

	// Search for a nurse by name
	@GetMapping("/name/{name}")
	public ResponseEntity<Nurse> findByName(@PathVariable String name) {
		Optional<Nurse> nurse = nurseRepository.findByName(name);

		// Check if a nurse was found
		if (nurse.isPresent()) {
			return ResponseEntity.ok(nurse.get());
		}

		// Return 404 if the nurse does not exist
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

	}

}