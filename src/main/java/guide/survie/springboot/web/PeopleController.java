package guide.survie.springboot.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/people")
class PeopleController {
    private List<PersonDTO> people = new ArrayList<>();

    @GetMapping("")
    public ResponseEntity<List<PersonDTO>> getPeople() {
        return ResponseEntity.ok(this.people);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPeople(@PathVariable int id) {
        return ResponseEntity.ok(this.people.get(id));
    }

    @PostMapping("")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO person) {
        people.add(person);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deletePerson(@PathVariable int id) {
        this.people.remove(id);
        return ResponseEntity.ok("person removed");
    }

    /*
        Problèmes : GET sur id qui n'existe pas = exception
                    Delete sur id qui n'existe pas = exception
                    Pas de PUT pour modifier un enregistrement existant
                    Pas de validation de contenu (name peut être vide)
     */

}