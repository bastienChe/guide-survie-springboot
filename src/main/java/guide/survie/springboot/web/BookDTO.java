package guide.survie.springboot.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookDTO {

    @NotBlank(message = "Name is mandatory")
    String name;

    @NotBlank(message = "Author is mandatory")
    String author;

    @NotNull(message = "Kind is mandatory")
    Kind kind;

    public BookDTO(String name, String author, Kind kind) {
        this.name = name;
        this.author = author;
        this.kind = kind;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public Kind getKind() {
        return this.kind;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public enum Kind {
        SF("SF"),
        DETECTIVE("DETECTIVE"),
        THRILLER("THRILLER");

        public final String label;

        private Kind(String label) {
            this.label = label;
        }
    }
}
