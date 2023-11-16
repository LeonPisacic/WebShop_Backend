package com.luv2code.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.ecommerce.entity.State;

@RepositoryRestResource()
public interface StateRepository extends JpaRepository<State, Integer> {

    // comments
    List<State> findByCountryCode(@Param("code") String code); // this will allow to search state for specific country
                                                               // code

}
