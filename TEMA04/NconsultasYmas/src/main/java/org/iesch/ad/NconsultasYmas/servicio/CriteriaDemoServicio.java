package org.iesch.ad.NconsultasYmas.servicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.iesch.ad.NconsultasYmas.modelo.Autor;
import org.iesch.ad.NconsultasYmas.modelo.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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
    public void ejemploConsultaConLike() {

        System.out.println("Consulta con like");
        System.out.println("select * from atores where nombre like '%Jorge'");

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Autor> cq = cb.createQuery(Autor.class);
        Root<Autor> autor = cq.from(Autor.class);

        //Where nombre like '%Jorge%'
        cq.select(autor)
                .where(cb.like(autor.get("nombre"), "%Jorge%"));
        TypedQuery<Autor> query = entityManager.createQuery(cq);
        List<Autor> autores = query.getResultList();

        System.out.println("Resultados encontrados " + autores.size());
        for (Autor a: autores){
            System.out.println(" - " + a.getNombre() + " " + a.getApellido());
        }

    }

    @Transactional
    public void ejemploConsultaConJoin() {

        System.out.println("Consulta con Join");
        System.out.println("Mio: select * from Libro l join l.autor a where a.nacionalidad = 'Colombiana'");

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Libro> cq = cb.createQuery(Libro.class);
        Root<Libro> libro = cq.from(Libro.class);

        //JOIN con la tabla autor
        Join<Libro, Autor> autorJoin = libro.join("autor");
        //where
        cq.select(libro)
                .where(cb.equal(autorJoin.get("nacionalidad"), "Colombiana"));
        TypedQuery<Libro> query = entityManager.createQuery(cq);
        List<Libro> libros = query.getResultList();

        System.out.println("Libros colombianos: " + libros.size());
        for (Libro l: libros){
            System.out.println(" - " + l.getTitulo() + " (" + l.getAnioPublicacion() + ")");
        }
    }

    @Transactional
    public void ejemploConsultaMultiplesCondiciones() {

        System.out.println("Consulta con multiples condiciones");
        System.out.println("Consulta: select * from Libros where precio > 15 and anio_publicacion > 1960");

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Libro> cq = cb.createQuery(Libro.class);
        Root<Libro> libro = cq.from(Libro.class);

        //Multiples condiciones
        Predicate precioMayorA15 = cb.gt(libro.get("precio"), 15.0);
        Predicate anioMayorA1960 = cb.gt(libro.get("anioPublicacion"), 1960);

        //where
        cq.select(libro)
                .where(cb.and(precioMayorA15, anioMayorA1960));
        TypedQuery<Libro> query = entityManager.createQuery(cq);
        List<Libro> libros = query.getResultList();

        System.out.println("Libros >15$ and >1960: ");
        for (Libro l: libros){
            System.out.println(" - " + l.getTitulo() + " (" + l.getPrecio() + "; " + l.getAnioPublicacion() + ")");
        }
    }

    @Transactional
    public void ejemploConsultaDinamica(String nacionalidad, Double precioMin, Integer anioMin) {

        System.out.println("Consulta Dinamica");
        System.out.println("Dinamica: select * from Libro l join l.autor a where a.nacionalidad = ? and precio > ? and anio_publicacion > ?");

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Libro> cq = cb.createQuery(Libro.class);
        Root<Libro> libro = cq.from(Libro.class);

        //JOIN con la tabla autor
        Join<Libro, Autor> autorJoin = libro.join("autor");

        //Lista predicacos
        List<Predicate> predicates = new ArrayList<>();

        //Anado condidiones
        if (nacionalidad != null && nacionalidad.isEmpty()){
            predicates.add(cb.equal(autorJoin.get("nacionalidad"), nacionalidad));
        }

        if (precioMin != null){
            predicates.add(cb.ge(libro.get("precio"), precioMin));
        }

        if (anioMin != null){
            predicates.add(cb.ge(libro.get("anioPublicacion"), anioMin));
        }

        //Combinar
        if (!predicates.isEmpty()){
            cq.select(libro)
                    .where(cb.and(predicates.toArray(new Predicate[0])));
        }else {
            cq.select(libro);
        }
        TypedQuery<Libro> query = entityManager.createQuery(cq);
        List<Libro> libros = query.getResultList();

        System.out.println("Libros con criterios dinamicos");
        for (Libro l: libros){
            System.out.println(" - " + l.getTitulo() + " (" + l.getPrecio() + "; " + l.getAnioPublicacion() + ")");
        }
    }

    @Transactional
    public void ejemploConsultaOrderBy() {
        System.out.println("Consulta Order by");
        System.out.println("Dinamica: select * from libro order by anio_publicacion");

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Libro> cq = cb.createQuery(Libro.class);
        Root<Libro> libro = cq.from(Libro.class);

        //order by año de publicacion
        cq.select(libro)
                .orderBy(cb.desc(libro.get("anioPublicacion")));

        TypedQuery<Libro> query = entityManager.createQuery(cq);
        List<Libro> libros = query.getResultList();

        System.out.println("Libro ordenados por año de publicacion");
        for (Libro l: libros){
            System.out.println(" - " + l.getTitulo() + " (" + l.getAnioPublicacion() + ")");
        }
    }

    @Transactional
    public void ejemploConsultaConAgregaciones() {

        System.out.println("Consulta Group by y contamos libros por autor");

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> contQuery = cb.createQuery(Object[].class);
        Root<Libro> libro = contQuery.from(Libro.class);
        //join
        Join<Libro, Autor> autorJoin = libro.join("autor");

        contQuery.multiselect(
                autorJoin.get("nombre"),
                autorJoin.get("apellido"),
                cb.count(libro)
        ).groupBy(autorJoin.get("id"), autorJoin.get("nombre"), autorJoin.get("apellido"));

        TypedQuery<Object[]> query = entityManager.createQuery(contQuery);
        List<Object[]> resultado = query.getResultList();

        System.out.println("Contamos: ");
        for (Object[] result: resultado){
            System.out.println(" - " + result[0] + " " + result[1] +
                    ": " + result[2] + " Libros");
        }

        //Buscar el libro con el precio maximo
        System.out.println("Precio maximo");

        CriteriaQuery<Double> maxQ = cb.createQuery(Double.class);
        Root<Libro> libroRoot = maxQ.from(Libro.class);
        maxQ.select(cb.max(libroRoot.get("precio")));

        Double precioMax = entityManager.createQuery(maxQ).getSingleResult();
        System.out.println("\t - precio maximo: " + precioMax);

    }
}
