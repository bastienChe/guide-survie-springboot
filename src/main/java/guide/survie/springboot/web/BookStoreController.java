package guide.survie.springboot.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/bookstore")
class BookStoreController {
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
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO book) {
        books.add(book);
        return ResponseEntity.ok(book );
    }

    @DeleteMapping("/books/{id}/delete")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        books.remove(id);
        return ResponseEntity.ok("book removed");
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable int id, @RequestBody BookDTO book) {
        books.set(id, book);
        return ResponseEntity.ok(book);
    }


}