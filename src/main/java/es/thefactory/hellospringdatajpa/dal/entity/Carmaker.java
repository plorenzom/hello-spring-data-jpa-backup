package es.thefactory.hellospringdatajpa.dal.entity;

import jakarta.persistence.*;

/**
 * @author Pablo Lorenzo Manzano.
 */
@Entity
@Table(name = "Carmaker")
public class Carmaker {
    
    /**
     *
     */
    public Carmaker() {
    }
    
    /**
     *
     * @param name
     * @param originCountry
     */
    public Carmaker(String name, String originCountry) {
        this.name = name;
        this.originCountry = originCountry;
    }
    
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short carmakerId;
    
    /**
     *
     */
    private String name;
    
    /**
     *
     */
    private String originCountry;
    
    /**
     *
     * @return short
     */
    public short getCarmakerId() {
        return carmakerId;
    }
    
    /**
     *
     * @param carmakerId
     */
    public void setCarmakerId(short carmakerId) {
        this.carmakerId = carmakerId;
    }
    
    /**
     *
     * @return String
     */
    public String getName() {
        return name;
    }
    
    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     *
     * @return String
     */
    public String getOriginCountry() {
        return originCountry;
    }
    
    /**
     *
     * @param originCountry
     */
    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }
}
