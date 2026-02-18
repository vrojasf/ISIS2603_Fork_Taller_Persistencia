package co.edu.uniandes.dse.TallerPersistencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.TallerPersistencia.entities.PeliculaEntity;
import co.edu.uniandes.dse.TallerPersistencia.repositories.ActorRepository;
import co.edu.uniandes.dse.TallerPersistencia.repositories.DirectorRepository;
import co.edu.uniandes.dse.TallerPersistencia.repositories.PeliculaRepository;
import jakarta.transaction.Transactional;

@Service

public class PeliculaService {
    @Autowired 
    private PeliculaRepository peliculaRepository;

    @Autowired 
    private DirectorRepository directorRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Transactional 
    public PeliculaEntity createPelicula(PeliculaEntity pelicula) {

        List<PeliculaEntity> yaExiste = peliculaRepository.findByTitulo(pelicula.getTitulo());

        if (pelicula.getTitulo() != null){
            if (pelicula.getTitulo().isEmpty()) {
                throw new IllegalArgumentException("La pelicula tiene que tener nombre (titulo).");
            }
        } else {
            throw new IllegalArgumentException("El título de la película no puede ser nulo.");
        } 
        
        if (!yaExiste.isEmpty()) {
            throw new IllegalArgumentException("Ya existe una película con ese título.");
        }

        if (pelicula.getAnioLanzamiento() < 1930) {
            throw new IllegalArgumentException("El año de lanzamiento no puede ser antes a 1930.");
        } else {
            return peliculaRepository.save(pelicula);
        }
    }
}



