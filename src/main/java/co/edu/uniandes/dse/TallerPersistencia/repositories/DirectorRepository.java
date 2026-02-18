package co.edu.uniandes.dse.TallerPersistencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DirectorRepository  extends JpaRepository<DirectorEntity, Long>{
        List<DirectorEntity> findByNombre(String nombre);
        List<DirectorEntity> findByBiografia(String biografia);
    
}
