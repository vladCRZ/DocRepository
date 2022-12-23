package com.infomedia.DocRepository.bootstrap;

import com.infomedia.DocRepository.domain.Author;
import com.infomedia.DocRepository.domain.Book;
import com.infomedia.DocRepository.domain.Publisher;
import com.infomedia.DocRepository.repositories.AuthorRepository;
import com.infomedia.DocRepository.repositories.BookRepository;
import com.infomedia.DocRepository.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in bootstrap");

        Author sergio = new Author("Sergio", "Cruz");
        Book book1 = new Book("Tutorial Remedy", "100000000123");
        sergio.getBooks().add(book1);
        book1.getAuthors().add(sergio);

        authorRepository.save(sergio);
        bookRepository.save(book1);


        Author german = new Author("German","Caballero");
        Book book2 = new Book("Tomcat documentation", "10000000234");

        german.getBooks().add(book2);
        book2.getAuthors().add(german);

        authorRepository.save(german);
        bookRepository.save(book2);


        Author carlos = new Author("Carlos","Benavides");
        Book book3 = new Book("Remedy Material", "10000000235");

        carlos.getBooks().add(book3);
        book3.getAuthors().add(carlos);

        authorRepository.save(carlos);
        bookRepository.save(book3);


        Publisher norma = new Publisher("Norma", "Fresnos #13", "68300");
        publisherRepository.save(norma);

        book1.setPublisher(norma);
        norma.getBooks().add(book1);

        book2.setPublisher(norma);
        norma.getBooks().add(book2);

        book3.setPublisher(norma);
        norma.getBooks().add(book3);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        publisherRepository.save(norma);

        System.out.println("Number of books = " + authorRepository.count());
        System.out.println("Number of Publishers = " + publisherRepository.count());



    }
}
