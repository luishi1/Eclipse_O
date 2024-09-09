package com.crudgestion.demo.interfaces;

import com.crudgestion.demo.model.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBuyer extends CrudRepository<Buyer, Integer>{

}