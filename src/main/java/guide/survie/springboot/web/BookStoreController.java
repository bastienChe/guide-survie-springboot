package guide.survie.springboot.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/bookstore")
public class BookStoreController {

    private List<BookDTO> books = new ArrayList<>();

    @GetMapping("/books")
    public List<BookDTO> getBooks() {
        return books;
    }

    @GetMapping("/book/{id}")
    public BookDTO getBook(@PathVariable int id) {
        return books.get(id);
    }

    @PostMapping("/book")
    public BookDTO createBook(@RequestBody @Valid BookDTO bookDTO) {
        books.add(bookDTO);
        return bookDTO;
    }

    @PutMapping("/book/{id}")
    public BookDTO updateBook(@RequestBody @Valid BookDTO bookDTO, @PathVariable int id) {
        books.set(id, bookDTO);
        return bookDTO;
    }

    @DeleteMapping("book/{id}/delete")
    public BookDTO removeBook(@PathVariable int id) {
        return books.remove(id);
    }

    @GetMapping("/books/kinds")
    public Set<String> getKinds() {
        Set<String> kinds = new HashSet<>();
        for(BookDTO book : books) {
            kinds.add(book.kind.name());
        }
        return kinds;
    }

    @GetMapping("/books/kind/{kind}")
    public List<BookDTO> getBooksWithKins(@PathVariable String kind) {
        List<BookDTO> booksWithKind = new ArrayList<>();
        for(BookDTO book : books) {
            if(book.getKind().name().equals(kind)) {
                booksWithKind.add(book);
            }
        }
        return booksWithKind;
    }

}
