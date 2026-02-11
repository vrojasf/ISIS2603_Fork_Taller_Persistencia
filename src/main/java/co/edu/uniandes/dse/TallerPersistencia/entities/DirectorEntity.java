package co.edu.uniandes.dse.TallerPersistencia.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Data
public class DirectorEntity extends BaseEntity{
    
    private String nombre;
    private String biografia;

    @PodamExclude
    @OneToMany(mappedBy = "director")
    private List<PeliculaEntity> peliculas = new ArrayList<>();
}
