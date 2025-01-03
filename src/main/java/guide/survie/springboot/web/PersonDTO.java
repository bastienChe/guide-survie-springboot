package guide.survie.springboot.web;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PersonDTO {

    Long id;

    @NotBlank(message = "Name is mandatory")
    String name;

    @Min(value = 18, message = "Age must be more than 18")
    int age;

    public PersonDTO (String name, int age, Long id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

}
