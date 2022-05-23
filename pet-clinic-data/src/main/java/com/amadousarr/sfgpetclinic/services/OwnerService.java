package com.amadousarr.sfgpetclinic.services;

import com.amadousarr.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);


}
