package com.infomedia.DocRepository.repositories;

import com.infomedia.DocRepository.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
