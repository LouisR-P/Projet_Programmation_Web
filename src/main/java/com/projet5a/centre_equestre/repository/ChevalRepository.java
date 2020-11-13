package com.projet5a.centre_equestre.repository;

import com.projet5a.centre_equestre.model.Cheval;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChevalRepository extends CrudRepository<Cheval, Long>  {

    List<Cheval> findByNom(String nom);

    Cheval findById(long id);
}
