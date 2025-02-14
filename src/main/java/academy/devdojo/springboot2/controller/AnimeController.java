package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.requests.AnimePostRequestsBody;
import academy.devdojo.springboot2.requests.AnimePutRequestsBody;
import academy.devdojo.springboot2.service.AnimeService;
import academy.devdojo.springboot2.util.Dateutil;
import com.fasterxml.jackson.databind.introspect.AnnotatedAndMetadata;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/anime")
@Log4j2
@RequiredArgsConstructor

public class AnimeController {

    private final  Dateutil dateutil;
    private final AnimeService animeService;

    @GetMapping()
    public ResponseEntity<List<Anime> > lista() {
        return ResponseEntity.ok(animeService.listAll());
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable long id) {
        
        return ResponseEntity.ok(animeService.findByIdOrThrowBadException(id));
    }
    @GetMapping(path = "/find")
    public ResponseEntity<List<Anime>> findByName(@RequestParam(name = "name") String name) {
        //localhost:8080/anime/find?name

        return ResponseEntity.ok(animeService.findByName(name));
    }
    @PostMapping
    //ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Anime> save(@RequestBody AnimePostRequestsBody animePostRequestsBody) {
        return new ResponseEntity<>(animeService.save (animePostRequestsBody),HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
   @PutMapping
   public ResponseEntity<Void> replace(@RequestBody AnimePutRequestsBody animePutRequestsBody){
       animeService.replace(animePutRequestsBody);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
}

