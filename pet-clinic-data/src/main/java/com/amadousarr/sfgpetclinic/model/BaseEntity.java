package com.amadousarr.sfgpetclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
/*@MappedSuperclass is saying hey JPA, we're going to inherit from this class or other classes are going inherit it
* we don't need this specific class mapped to the database. We are doing inheritance but don't worry about doing anything
*  special for it
* */
@MappedSuperclass

public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
