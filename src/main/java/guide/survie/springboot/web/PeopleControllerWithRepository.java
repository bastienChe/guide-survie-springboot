package guide.survie.springboot.web;

import guide.survie.springboot.repository.PersonEntity;
import guide.survie.springboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/people")
class PeopleControllerWithRepository {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("")
    public ResponseEntity<List<PersonDTO>> getPeople() {
        List<PersonEntity> personEntities = personRepository.findAll();
        return ResponseEntity.ok(personEntities.stream().map(PersonAdapter::DTOFromEntity).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable Long id) {
        PersonDTO personDTO = PersonAdapter.DTOFromEntity(personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found")));
        return ResponseEntity.ok(personDTO);
    }

    @PostMapping("")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO person) {
        return ResponseEntity.ok(PersonAdapter.DTOFromEntity(personRepository.save(PersonAdapter.EntityfromDTO(person))));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return ResponseEntity.ok("person removed");
    }

}