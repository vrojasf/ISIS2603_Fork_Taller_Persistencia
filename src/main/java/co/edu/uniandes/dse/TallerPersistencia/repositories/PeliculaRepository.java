package co.edu.uniandes.dse.TallerPersistencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.TallerPersistencia.entities.PeliculaEntity;

@Repository
public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long> {
    List<PeliculaEntity> findByTitulo(String titulo);
    List<PeliculaEntity> findByAnioLanzamiento(int anioLanzamiento);

}