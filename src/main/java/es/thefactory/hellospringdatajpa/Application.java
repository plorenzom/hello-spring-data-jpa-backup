package es.thefactory.hellospringdatajpa;

import es.thefactory.hellospringdatajpa.dal.entity.Carmaker;
import es.thefactory.hellospringdatajpa.dal.repo.CarmakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author Pablo Lorenzo Manzano.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    
    /**
     *
     */
    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());
    
    /**
     *
     */
    @Autowired
    private CarmakerRepository carmakerRepo;
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    /**
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Entering method run()");
        final short VOLKSWAGEN_GROUP_ID = 1;
        
        LOGGER.info("Añadir fabricantes de coches:");
        carmakerRepo.save(new Carmaker("Volkswagen Group", "-"));
        carmakerRepo.save(new Carmaker("Toyota Motor", "Japón"));
        carmakerRepo.save(new Carmaker("Mercedes-Benz Group", "Alemania"));
        carmakerRepo.save(new Carmaker("Ford Motor", "EEUU"));
        carmakerRepo.findAllByOrderByCarmakerId().forEach(carmaker -> {
            LOGGER.info(carmaker.getName() + "/" + carmaker.getOriginCountry());
        });
        LOGGER.info("");
        
        LOGGER.info("Actualizar el país de origen del fabricante 'Volkswagen Group':");
        Optional<Carmaker> optionalCarmaker = carmakerRepo.findById(VOLKSWAGEN_GROUP_ID);
        optionalCarmaker.ifPresent(carmaker -> {
            carmaker.setOriginCountry("Alemania");
            carmakerRepo.save(carmaker);
        });
        carmakerRepo.findAllByOrderByCarmakerId().forEach(carmaker -> {
            LOGGER.info(carmaker.getName() + "/" + carmaker.getOriginCountry());
        });
        LOGGER.info("");
        
        LOGGER.info("Listar fabricantes de 'Alemania':");
        carmakerRepo.findByOriginCountry("Alemania").forEach(carmaker -> {
            LOGGER.info(carmaker.getName() + "/" + carmaker.getOriginCountry());
        });
        LOGGER.info("");
        
        LOGGER.info("Eliminar el fabricante 'Volkswagen Group':");
        carmakerRepo.deleteById(VOLKSWAGEN_GROUP_ID);
        carmakerRepo.findAll().forEach(carmaker -> {
            LOGGER.info(carmaker.getName() + "/" + carmaker.getOriginCountry());
        });
        
        LOGGER.info("Exiting method run()");
    }
}
