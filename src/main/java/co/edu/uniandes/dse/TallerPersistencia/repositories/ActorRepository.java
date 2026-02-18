package co.edu.uniandes.dse.TallerPersistencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.TallerPersistencia.entities.ActorEntity;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Long> {
    List<ActorEntity> findByNombre(String nombre);
    List<ActorEntity> findByNacionalidad(String nacionalidad);

}