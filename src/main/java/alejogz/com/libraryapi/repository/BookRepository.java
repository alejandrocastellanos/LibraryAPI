package alejogz.com.libraryapi.repository;

import alejogz.com.libraryapi.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

}
