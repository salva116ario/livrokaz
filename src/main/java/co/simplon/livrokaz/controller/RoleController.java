package co.simplon.livrokaz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.livrokaz.model.Role;
import co.simplon.livrokaz.repository.RoleRepository;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository RoleRepository;
    
    @GetMapping("/role")
    public ResponseEntity<?> getAll(){
        List<Role> roleList = null;
        try{
            roleList = RoleRepository.findAll();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(roleList);
    }

}
