package org.iesch.DocumentosReferenciados.service;

import org.bson.types.ObjectId;
import org.iesch.DocumentosReferenciados.modelo.BookRef;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRefService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<BookRef> buscarTodos() {
        return mongoTemplate.findAll(BookRef.class);
    }

    public @Nullable List<BookRef> buscarPorTitulo(String titulo) {
        Query query = new Query();
        query.addCriteria(Criteria.where("titulo").regex(titulo, "i"));
        return mongoTemplate.find(query, BookRef.class);
    }

    public @Nullable List<BookRef> findByAutoresId(String autorId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("autores.id").is(new ObjectId(autorId)));
        return mongoTemplate.find(query, BookRef.class);
    }

    public @Nullable BookRef buscarPorId(String id) {
        return mongoTemplate.findById(id, BookRef.class);
    }

    public @Nullable List<BookRef> findByNombreAutor(String nombreAutor) {
        //1 lookup, lluego un match
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("autores")
                .localField("autores")
                .foreignField("_id")
                .as("autoresData");

        MatchOperation matchOperation = Aggregation.match(
                Criteria.where("autoresData.nombre") //filtro por lo de arriba y el campo que queremos
                        .regex(nombreAutor, "i") //nombre que le pasmos por el metodo
        );
        Aggregation aggregation = Aggregation.newAggregation(lookupOperation, matchOperation);
        AggregationResults<BookRef> results = mongoTemplate.aggregate(
                aggregation, "libros_ref", BookRef.class
        );
        return results.getMappedResults();
    }
}
