package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootstrapData(final AuthorRepository authorRepository,
		final BookRepository bookRepository,
		final PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(final String... args) throws Exception {

		//publisher
		Publisher publisher = new Publisher();
		publisher.setPublisherName("Publisher A");
		publisher.setAddress("Salnas 20");
		publisher.setCity("Riga");
		publisher.setState("Latvia");
		publisher.setZip("LV-1021");

		Publisher publisherSaved = publisherRepository.save(publisher);

		System.out.println(publisherSaved);
		System.out.println("Publisher Count: " + publisherRepository.count());

		//book1
		Author eric = new Author();
		eric.setFirstName("Eric");
		eric.setLastName("Evans");

		Author ericSaved = authorRepository.save(eric);

		Book ddd = new Book();
		ddd.setTitle("Domain Driven Design");
		ddd.setIsbm("123456");
		ddd.getAuthors().add(ericSaved);
		ddd.setPublisher(publisherSaved);

		Book dddSaved = bookRepository.save(ddd);

		//book2
		Author rod = new Author();
		rod.setFirstName("Rod");
		rod.setLastName("Johnson");

		Author rodSaved = authorRepository.save(rod);

		Book noEJB = new Book();
		noEJB.setTitle("J2EE Development without EJB");
		noEJB.setIsbm("54757585");
		noEJB.getAuthors().add(rodSaved);
		noEJB.setPublisher(publisherSaved);

		Book noEJBSaved = bookRepository.save(noEJB);

		//print
		System.out.println("In Bootstrap");
		System.out.println("Author Count: " + authorRepository.count());
		System.out.println("Book Count: " + bookRepository.count());


	}
}
