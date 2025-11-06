package org.iesch.ad.demoJPA_coches.repositorio;

import org.iesch.ad.demoJPA_coches.modelo.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepositorio extends JpaRepository<Coche, Long> {



}
