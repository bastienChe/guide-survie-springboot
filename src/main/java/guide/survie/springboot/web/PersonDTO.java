package guide.survie.springboot.web;

public class PersonDTO {
    String name;
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
