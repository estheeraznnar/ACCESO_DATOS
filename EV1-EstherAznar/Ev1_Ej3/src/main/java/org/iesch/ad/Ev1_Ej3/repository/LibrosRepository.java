package org.iesch.ad.Ev1_Ej3.repository;

import org.iesch.ad.Ev1_Ej3.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrosRepository extends JpaRepository<Libro, Long> {

    List<Libro> encontrarPorEditorial(String nombre);
}
