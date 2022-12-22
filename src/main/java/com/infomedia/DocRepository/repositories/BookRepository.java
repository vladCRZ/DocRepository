package com.infomedia.DocRepository.repositories;

import com.infomedia.DocRepository.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
