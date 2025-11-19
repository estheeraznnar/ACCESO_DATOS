package org.iesch.ad.NconsultasYmas.servicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.iesch.ad.NconsultasYmas.modelo.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class CriteriaDemoServicio {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void ejemploConsultaSimple() {

        System.out.println("SELECT * FROM autores");

        //1 Me creo el Builder
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //2 Entidad a obtener
        CriteriaQuery<Autor> cq = cb.createQuery(Autor.class);
        //3 Crear root (FROM)
        Root<Autor> autor = cq.from(Autor.class);
        //4 Construit el select
        cq.select(autor);
        //5 crear y ejecutar la consulta
        TypedQuery<Autor> query = entityManager.createQuery(cq);
        //6 Resultado
        List<Autor> autores = query.getResultList();

        System.out.println("Resultados encontrados " + autores.size());
        for (Autor a: autores){
            System.out.println(" - " + a.getNombre() + " " + a.getApellido());
        }

    }

    @Transactional
    public void ejemploConsultaConWhere() {
        System.out.println("Ej: Select * from autores where macionalidad = 'Argentina'");

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Autor> cq = cb.createQuery(Autor.class);
        Root<Autor> autor = cq.from(Autor.class);

        //Where
        cq.select(autor)
                .where(cb.equal(autor.get("nacionalidad"), "Argentina"));

        TypedQuery<Autor> query = entityManager.createQuery(cq);
        //6 Resultado
        List<Autor> autores = query.getResultList();

        System.out.println("Resultados encontrados " + autores.size());
        for (Autor a: autores){
            System.out.println(" - " + a.getNombre() + " " + a.getApellido());
        }
    }
}
