package com.amadousarr.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Table(name = "types")
public class PetType extends BaseEntity{
    @Column(name = "name")
   private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
