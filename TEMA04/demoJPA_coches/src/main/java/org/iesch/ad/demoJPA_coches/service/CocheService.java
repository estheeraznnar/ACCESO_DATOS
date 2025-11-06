package org.iesch.ad.demoJPA_coches.service;

import org.iesch.ad.demoJPA_coches.modelo.Coche;
import org.iesch.ad.demoJPA_coches.repositorio.CocheRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocheService {

    @Autowired
    CocheRepositorio cocheRepositorio;

    public Coche guardar(Coche coche) {

        return  cocheRepositorio.save(coche);

    }

    public List<Coche> obtenerTodos() {

        return cocheRepositorio.findAll();
    }

    public Coche obtenerUno(Long id) {
        return  cocheRepositorio.findById(id).get();
    }

    public Coche updateUno(Long id, Coche coche) {
        Optional<Coche> cocheEnBBDD = cocheRepositorio.findById(id);

        if (cocheEnBBDD.isEmpty()){
            return null;
        }else {
            coche.setId(id);
            return  cocheRepositorio.save(coche);
        }
    }

    public Coche borrarUno(Long id) {

        Coche cocheBBDD = cocheRepositorio.findById(id).get();
        cocheRepositorio.deleteById(id);
        return cocheBBDD;
    }
}
