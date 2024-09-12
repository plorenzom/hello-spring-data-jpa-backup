package es.thefactory.hellospringdatajpa.dal.repo;

import es.thefactory.hellospringdatajpa.dal.entity.Carmaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Pablo Lorenzo Manzano.
 */
public interface CarmakerRepository extends JpaRepository<Carmaker, Short> {
    
    /**
     *
     * @return List<Carmaker>
     */
    List<Carmaker> findAllByOrderByCarmakerId();
    
    /**
     *
     * @param originCountry
     * @return List<Carmaker>
     */
    List<Carmaker> findByOriginCountry(String originCountry);
}
