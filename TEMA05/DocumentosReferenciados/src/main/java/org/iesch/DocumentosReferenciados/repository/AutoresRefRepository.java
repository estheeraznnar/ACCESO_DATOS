package org.iesch.DocumentosReferenciados.repository;

import org.iesch.DocumentosReferenciados.modelo.AutoresRef;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoresRefRepository extends MongoRepository<AutoresRef, String > {
}
