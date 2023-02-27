package elab.spring.leraningSpring.repositories;

import elab.spring.leraningSpring.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
