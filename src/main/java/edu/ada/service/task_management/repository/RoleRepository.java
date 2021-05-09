package edu.ada.service.task_management.repository;


import edu.ada.service.task_management.model.dto.ERole;
import edu.ada.service.task_management.model.dto.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
