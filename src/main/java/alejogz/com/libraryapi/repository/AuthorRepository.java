package alejogz.com.libraryapi.repository;

import alejogz.com.libraryapi.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
