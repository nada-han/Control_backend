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

import ma.hansal.entities.Service1;
import ma.hansal.services.ServiceService;

@RestController
@RequestMapping("/api/v1/services")
public class ServiceController {

	@Autowired
	private ServiceService serviceService;

	@GetMapping
	public List<Service1> findAllService() {
		return serviceService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Service1 Service1 = serviceService.findById(id);
		if (Service1 == null) {
			return new ResponseEntity<Object>("Service with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(Service1);
		}
	}

	@PostMapping
	public Service1 createService(@RequestBody Service1 Service1) {
		Service1.setId(0L);
		return serviceService.create(Service1);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateService(@PathVariable Long id, @RequestBody Service1 Service1) {

		if (serviceService.findById(id) == null) {
			return new ResponseEntity<Object>("Service with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		} else {
			Service1.setId(id);
			return ResponseEntity.ok(serviceService.update(Service1));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteService(@PathVariable Long id) {
		Service1 Service1 = serviceService.findById(id);
		if (Service1 == null) {
			return new ResponseEntity<Object>("Service with ID " + id + " not found", HttpStatus.BAD_REQUEST);
		} else {
			serviceService.delete(Service1);
			return ResponseEntity.ok("Service has been deleted");
		} 
	}

}
