package alejogz.com.libraryapi.repository;

import alejogz.com.libraryapi.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
