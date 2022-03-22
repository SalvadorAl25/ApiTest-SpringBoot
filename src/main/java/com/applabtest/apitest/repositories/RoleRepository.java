package com.applabtest.apitest.repositories;

import com.applabtest.apitest.models.RolesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RolesEntity, Long> {

}
