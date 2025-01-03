package guide.survie.springboot.web;

import guide.survie.springboot.repository.PersonEntity;

public class PersonAdapter {

    public static PersonDTO DTOFromEntity(PersonEntity personEntity) {
        return new PersonDTO(personEntity.getName(), personEntity.getAge(), personEntity.getId());
    }

    public static PersonEntity EntityfromDTO(PersonDTO personDTO) {
        return new PersonEntity(personDTO.getName(), personDTO.getAge());
    }

}
