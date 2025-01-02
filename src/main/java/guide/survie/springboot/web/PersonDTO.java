package guide.survie.springboot.web;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PersonDTO {

    @NotBlank(message = "Name is mandatory")
    String name;

    @Min(value = 18, message = "Age must be more than 18")
    int age;

    public PersonDTO (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

}
