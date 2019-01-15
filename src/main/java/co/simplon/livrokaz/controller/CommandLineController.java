package co.simplon.livrokaz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.livrokaz.model.CommandLine;
import co.simplon.livrokaz.repository.CommandLineRepository;

@RestController
public class CommandLineController {

	@Autowired
	private CommandLineRepository commandLineRepository;
	
	@GetMapping("/commandlines")
	public ResponseEntity<?> getAllCommandLines(){
		List<CommandLine> commandLinesList = null;
		try {
			commandLinesList = commandLineRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}	
		return ResponseEntity.status(HttpStatus.OK).body(commandLinesList);
	}
	
}
