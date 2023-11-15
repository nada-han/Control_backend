package ma.hansal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.hansal.entities.Employe;
import ma.hansal.services.EmployeService;

@RestController
@RequestMapping("/api/v1/employes")
public class EmployeController {

	@Autowired
	private EmployeService EmployeService;

	@GetMapping
	public List<Employe> findAllEmploye() {
		return EmployeService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Employe Employe = EmployeService.findById(id);
		if (Employe == null) {
			return new ResponseEntity<Object>("Employe with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(Employe);
		}
	}

	@PostMapping
	public Employe createEmploye(@RequestBody Employe Employe) {
		Employe.setId(0L);
		return EmployeService.create(Employe);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEmploye(@PathVariable Long id, @RequestBody Employe Employe) {

		if (EmployeService.findById(id) == null) {
			return new ResponseEntity<Object>("Employe with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		} else {
			Employe.setId(id);
			return ResponseEntity.ok(EmployeService.update(Employe));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmploye(@PathVariable Long id) {
		Employe Employe = EmployeService.findById(id);
		if (Employe == null) {
			return new ResponseEntity<Object>("Employe with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		} else {
			EmployeService.delete(Employe);
			return ResponseEntity.ok("Employe has been deleted");
		} 
	}

}

