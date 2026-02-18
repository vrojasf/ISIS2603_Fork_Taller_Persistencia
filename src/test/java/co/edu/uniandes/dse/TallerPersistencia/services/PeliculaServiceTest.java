package co.edu.uniandes.dse.TallerPersistencia.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.TallerPersistencia.entities.PeliculaEntity;
import co.edu.uniandes.dse.TallerPersistencia.exceptions.IllegalOperationException;
import jakarta.transaction.Transactional;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(PeliculaService.class)

public class PeliculaServiceTest {
    @Autowired
    private PeliculaService peliculaService;
    //Se necesita el servicio pues es sobre el cual se ejecutaran las pruebas. Es autowired para poder hacer la inyeccion de dependencias

    @Autowired
    private TestEntityManager entityManager;
    //Sirve para aislar las pruebas para no depender de otros servicios


    private PodamFactoryImpl factory = new PodamFactoryImpl();
    //Es la libreria que permite la creacion de pruebas ficticias
    private List<PeliculaEntity> peliculaList = new ArrayList<>();
    //Tiene las peliculas que ya estan dentro del aplicativo


    @BeforeEach
    void setUp() {
        clearData();
    }

    private void clearData() {
        entityManager.getEntityManager()
                .createQuery("delete from PeliculaEntity")
                .executeUpdate();
        entityManager.getEntityManager();
    }

    @Test
    void createPelicul() throws IllegalOperationException {
        PeliculaEntity newEntity = factory.manufacturePojo(PeliculaEntity.class);

        PeliculaEntity result = peliculaService.createPelicula(newEntity);

        assertNotNull(result);

        PeliculaEntity entity = entityManager.find(PeliculaEntity.class, result.getId());
        assertEquals(newEntity.getTitulo(), entity.getTitulo());

        
    }

}


