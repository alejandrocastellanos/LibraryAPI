package alejogz.com.libraryapi.controller;

import alejogz.com.libraryapi.model.Author;
import alejogz.com.libraryapi.repository.AuthorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public List<Author> getAll(){
        return authorRepository.findAll();
    }

    @PostMapping
    public Author newAuthor(@RequestBody Author author) {
        author.setId(UUID.randomUUID().toString());
        return authorRepository.save(author);
    }
}
