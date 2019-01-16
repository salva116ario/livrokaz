package co.simplon.livrokaz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.livrokaz.model.Style;
import co.simplon.livrokaz.repository.StyleRepository;

@RestController
public class StyleController {

	
	
	@Autowired
	private StyleRepository styleRepository;
	
	@GetMapping("/styles")
	public ResponseEntity<?> getAllStyles(){
		List<Style> styleList = null;
		try {
			styleList = styleRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}	
		return ResponseEntity.status(HttpStatus.OK).body(styleList);
	}
	
	@GetMapping("/styles/id/{id}")
	public ResponseEntity<?> livreById(@PathVariable Integer id) {
		Optional<Style> style = null;
		try {
			style = styleRepository.findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(style);
	}
	
	@PostMapping(value = "/admin/addstyle", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> addStyle(@RequestBody Style style) {
		Style styleToAdd = null;
		try {
			styleToAdd = styleRepository.saveAndFlush(style);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(styleToAdd);
	}

	@PutMapping(value = "/admin/modifystyle", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> modifyStyle(@RequestBody Style style) {
		Style styleToModify = null;
		try {
			styleToModify = styleRepository.saveAndFlush(style);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(styleToModify);
	}
	
	@DeleteMapping(value = "/admin/deletestyle/{id}")
	public ResponseEntity<?> deleteStyle(@PathVariable Integer id) {
		try {
			styleRepository.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
