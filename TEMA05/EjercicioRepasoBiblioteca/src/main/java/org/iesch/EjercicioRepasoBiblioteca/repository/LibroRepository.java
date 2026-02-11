package org.iesch.EjercicioRepasoBiblioteca.repository;

@Repository
public interface LibroRepository extends MongoRepository<Libro, String> {

    /**
     * Buscar libros por título (ignorando mayúsculas)
     */
    List<Libro> findByTituloContainingIgnoreCase(String titulo);

    /**
     * Buscar libros con precio entre dos valores
     */
    List<Libro> findByPrecioBetween(Double precioMin, Double precioMax);

    /**
     * Buscar libros publicados después de un año dado
     */
    List<Libro> findByAnioPublicacionGreaterThan(Integer anio);

    /**
     * Buscar libros por nombre de autor (documento embebido)
     */
    List<Libro> findByAutoresNombre(String nombre);

    /**
     * Buscar libros con precio inferior a X O año de publicación posterior a Y
     */
    @Query("{$or: [{'precio': {$lt: ?0}}, {'anioPublicacion': {$gt: ?1}}]}")
    List<Libro> buscarEconomicosORecientes(Double precio, Integer anio);
}
}
