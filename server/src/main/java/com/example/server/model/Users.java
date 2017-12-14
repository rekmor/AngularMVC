package com.example.server.model;

import javax.persistence.*;

/**
 * Created by RekMor on 10/26/17.
 */
@Entity
@Table(name = "cars")
public class Users {

    @Id
    @GeneratedValue
    @Column(name="car_id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name= "model")
    private String model;
    @Column(name="year")
    private Integer year;
    @Column(name="price")
    private Integer price;


    public Users() {

    }

    public Users(int id , String name, String model, int year, int price){
        super();
        this.id = id;
        this.name= name;
        this.model=model;
        this.year= year;
        this.price = price;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}
