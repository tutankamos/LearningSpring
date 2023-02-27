package elab.spring.leraningSpring.bootstrap;

import elab.spring.leraningSpring.domain.Author;
import elab.spring.leraningSpring.domain.Book;
import elab.spring.leraningSpring.domain.Publisher;
import elab.spring.leraningSpring.repositories.AuthorRepository;
import elab.spring.leraningSpring.repositories.BookRepository;
import elab.spring.leraningSpring.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
//        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain-Driven Design", "123123");
//        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
//        publisher.getBooks().add(ddd);

//        publisherRepository.save(publisher); // perche' se lo alzo di due righe non funiona?
//        authorRepository.save(eric);
        bookRepository.save(ddd);

//
//        Author rod = new Author("Rod", "Johnson");
//        Book noEJB = new Book("J2EE Developement withoutEJB", "345345354");
//        rod.getBooks().add(noEJB);
//        noEJB.getAuthors().add(rod);
//
//        noEJB.setPublisher(publisher);
//        publisher.getBooks().add(noEJB);
//
//        authorRepository.save(rod);
//        bookRepository.save(noEJB);
//        publisherRepository.save(publisher);
//

        System.out.println("Started in Bootstrap");
        System.out.println("number of books: " + bookRepository.count());
        System.out.println("number of Publishers: " + publisherRepository.count());

        Optional<Book> optBook = bookRepository.findById(ddd.getId());
        if(optBook.isPresent()){
            Book fromDB_Book = optBook.get();
            System.out.println("Publisher number of books: " + fromDB_Book.getAuthors().size());
        }
    }
}
