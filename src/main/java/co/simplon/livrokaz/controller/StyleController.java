package co.simplon.livrokaz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
