package com.geekster.H2fun.repository;

import com.geekster.H2fun.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository <Users,Integer> {



}
