package com.example.server.model;

import com.example.server.model.Users;
import javax.persistence.*;

/**
 * Created by RekMor on 10/26/17.
 */

@Entity
@Table(name = "engines")
public class Engines {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name= "model")
    private String model;


    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    private Users user;


    public Engines() {

    }

    public Engines(int id , String model, int usersId){
        super();
        this.id = id;
        this.model=model;
        this.user=new Users(usersId,"","",'\0','\0');

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }


}
