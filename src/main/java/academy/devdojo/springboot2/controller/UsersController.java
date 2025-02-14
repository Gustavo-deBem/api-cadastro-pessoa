package academy.devdojo.springboot2.controller;


import academy.devdojo.springboot2.domain.Users;

import academy.devdojo.springboot2.requests.AnimePutRequestsBody;
import academy.devdojo.springboot2.service.UsersService;
import academy.devdojo.springboot2.requests.UsersPostRequestsBody;
import academy.devdojo.springboot2.requests.UsersPutRequestsBody;

import academy.devdojo.springboot2.util.Dateutil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Log4j2
@RequiredArgsConstructor

public class UsersController {
    private final Dateutil dateutil;
    private final UsersService usersService;

    @GetMapping()
    public ResponseEntity<List<Users>> lista() {
        return ResponseEntity.ok(usersService.listAll());
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Users> findById(@PathVariable long id) {

        return ResponseEntity.ok(usersService.findByIdOrThrowBadException(id));
    }
    @GetMapping(path = "/find")
    public ResponseEntity<List<Users>> findByName(@RequestParam(name = "name") String name) {
        //localhost:8080/users/find?name

        return ResponseEntity.ok(usersService.findByName(name));
    }@PostMapping
    //ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Users> save(@RequestBody UsersPostRequestsBody usersPostRequestsBody) {
        return new ResponseEntity<>(usersService.save (usersPostRequestsBody), HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
       usersService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody UsersPutRequestsBody usersPutRequestsBody){
        usersService.replace(usersPutRequestsBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}







