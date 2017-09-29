package com.foodora.countryapp.models;

import javax.persistence.*;

/**
 * simple Model class
 *
 * @author Mohamad Alaloush
 */
@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="country_code")
    private String code;

    @Column(name = "country_name")
    private String name;

    /**
     * an important constructor the existance of a default constructor is very
     * important for jdbc to work properly
     */
    public Country(){

    }

    /**
     * extra constructor for convenience
     *
     * @param code
     * @param name
     */
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (code != null ? !code.equals(country.code) : country.code != null) return false;
        return name != null ? name.equals(country.name) : country.name == null;
    }
}