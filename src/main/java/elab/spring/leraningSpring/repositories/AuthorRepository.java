package elab.spring.leraningSpring.repositories;

import elab.spring.leraningSpring.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
