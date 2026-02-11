package co.edu.uniandes.dse.TallerPersistencia.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Data
public class ActorEntity extends BaseEntity{

    private String nombre;
    private String nacionalidad;

    @PodamExclude
    @ManyToMany(mappedBy = "actores")
    private List<PeliculaEntity> peliculas = new ArrayList<>();
    
    
    
}
