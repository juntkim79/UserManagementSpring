package com.moneylion.usermanagement;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {

  private final UserRepository repository;
  public static String newline = System.getProperty("line.separator");

  UserController(UserRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/feature")
  public ResponseEntity<String> getUsers(@RequestParam(value = "email") String email, 
    @RequestParam(value= "featureName") String featureName) {
        String result = repository.findEnableByEmailAndFeatureName(email, featureName);
         if(result == null){
          return ResponseEntity.status(204).build();
         }else{
          return ResponseEntity.ok().body("{"+newline+ "\t\"canAccess\" : " + result + newline+"}");
         }
  }

  @PostMapping("/feature")
  public ResponseEntity<String> newUser(@RequestBody User newUser) {
      if (!newUser.valid()) {
        return ResponseEntity.status(304).build();
    }
    
    String result = repository.findEnableByEmailAndFeatureName(newUser.getEmail(), newUser.getFeatureName());
    if(result != null){
      if(result == String.valueOf(newUser.getEnable())){
        return ResponseEntity.status(304).build();
      }else{
        repository.updateByEmailAndFeatureName(newUser.getEnable(), newUser.getEmail(), newUser.getFeatureName());
      }
    }
    else{
      repository.save(newUser);  
    }

    return ResponseEntity.ok().body("");
    
  }

  @GetMapping("/all")
  List<User> all() {
    return repository.findAll();
  }
}