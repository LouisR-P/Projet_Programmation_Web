package com.projet5a.centre_equestre.repository;

import java.util.Optional;

import com.projet5a.centre_equestre.model.ERole;
import com.projet5a.centre_equestre.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}
