package org.iesch.DocumentosReferenciados.repository;

import org.iesch.DocumentosReferenciados.modelo.AutoresRef;
import org.iesch.DocumentosReferenciados.modelo.BookRef;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRefRepository extends MongoRepository<BookRef, String > {
}
