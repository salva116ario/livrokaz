package co.simplon.livrokaz.controller;

import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.livrokaz.model.CommandLine;
import co.simplon.livrokaz.model.Customer;
import co.simplon.livrokaz.repository.CommandLineRepository;

@RestController
@RequestMapping("/commandline")
public class CommandLineController {

	@Autowired
	private CommandLineRepository commandLineRepository;

	/**
	 * Retourne toutes les lignes de commande
	 * 
	 * @return
	 */

	@GetMapping("/getall")
	public ResponseEntity<?> getAllCommandLines() {
		List<CommandLine> commandLinesList = null;
		try {
			commandLinesList = commandLineRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(commandLinesList);
	}

	/**
	 * Retourne toutes les lignes d'un client par id client
	 * 
	 * @param cuId
	 * @return
	 */
	@GetMapping("/getbycustomer/{customerId}")
	public ResponseEntity<?> getCommandLinesByCustomer(@PathVariable Customer customerId){
		Set <CommandLine> commandLines = null;
		try {
			commandLines = commandLineRepository.findByCustomer(customerId);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(commandLines);
	}

	/**
	 * Ajouter une ligne de commande à la BDD
	 * 
	 * @param commandLine
	 * @return
	 */
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> addCommandLine(@RequestBody CommandLine commandLine) {
		CommandLine commandLineToAdd = null;
		try {
			commandLineToAdd = commandLineRepository.saveAndFlush(commandLine);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(commandLineToAdd);
	}
	
	/**
	 * modifier une ligne de commande à la BDD
	 * 
	 * @param commandLine
	 * @return
	 */
	@PutMapping(value = "/modify", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> modifyCommandLine(@RequestBody CommandLine commandLine) {
		CommandLine commandLineToModify = null;
		try {
			commandLineToModify = commandLineRepository.saveAndFlush(commandLine);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(commandLineToModify);
	}

	/**
	 * Supprime de la BDD la ligne de commande dont l'id = {id}
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteCommanLine(@PathVariable Integer id) {
		try {
			 commandLineRepository.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
}
