package alejogz.com.libraryapi.controller;

import alejogz.com.libraryapi.model.Author;
import alejogz.com.libraryapi.model.Book;
import alejogz.com.libraryapi.model.Category;
import alejogz.com.libraryapi.repository.AuthorRepository;
import alejogz.com.libraryapi.repository.BookRepository;
import alejogz.com.libraryapi.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookController {


    private final BookRepository bookRepository;

    private final CategoryRepository categoryRepository;

    private final AuthorRepository authorRepository;


    public BookController(BookRepository bookRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> getById(@PathVariable String id){
        return bookRepository.findById(id);
    }

    @PostMapping
    public Book newBook(@RequestBody Book book){
        book.setId(UUID.randomUUID().toString());
        String categoryId = book.getCategory().getId();
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new RuntimeException("Category not found"));

        String authorId = book.getAuthor().getId();
        Author author = authorRepository.findById(authorId).orElseThrow(
                () -> new RuntimeException("Author not found"));
        book.setCategory(category);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book book){
        book.setId(id);
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id){
        bookRepository.deleteById(id);
    }
}
