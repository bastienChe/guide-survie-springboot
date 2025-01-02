package guide.survie.springboot.web;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/bookstore")
class BookStoreController {

    @Value("${books.max-books-authorized}")
    private int maxBooksAuthorized;

    @Value("${books.admin.email}")
    private String adminEmail;

    @Value("${books.admin.name}")
    private String adminName;

    @Value("${books.admin.send-email-on-delete}")
    private boolean sendEmailOnDelete;

    private List<BookDTO> books = new ArrayList<>();

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getBooks() {
        return ResponseEntity.ok(this.books);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable int id) {
        return ResponseEntity.ok(this.books.get(id));
    }

    @GetMapping("/books/kind/{kind}")
    public ResponseEntity<List<BookDTO>> getBooksWithKind(@PathVariable String kind) {
        List<BookDTO> booksWithKind = new ArrayList<>();
        for (BookDTO book : books) {
            if (kind.equals(book.getKind().name())) {
                booksWithKind.add(book);
            }
        }

        return ResponseEntity.ok(booksWithKind);
    }

    @GetMapping("/books/kinds")
    public ResponseEntity<Set<String>> getKinds() {
        Set<String> kinds = new HashSet<>();
        for (BookDTO book : books) {
            kinds.add(book.getKind().name());
        }

        return ResponseEntity.ok(kinds);
    }

    @PostMapping("/books")
    public ResponseEntity<?> createBook(@RequestBody @Valid BookDTO book) {
        if (books.size() >= maxBooksAuthorized) {
            return ResponseEntity.badRequest().build();
        }
        books.add(book);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/books/{id}/delete")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        books.remove(id);
        System.out.println(sendEmailOnDelete);
        if (sendEmailOnDelete) {
            System.out.println("send an email to "+adminName+" : "+ adminEmail);
        }
        return ResponseEntity.ok("book removed");
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable int id, @RequestBody @Valid BookDTO book) {
        books.set(id, book);
        return ResponseEntity.ok(book);
    }


}