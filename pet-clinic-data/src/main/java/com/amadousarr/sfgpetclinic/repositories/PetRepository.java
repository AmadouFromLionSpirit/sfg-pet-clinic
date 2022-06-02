package com.amadousarr.sfgpetclinic.repositories;

import com.amadousarr.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
