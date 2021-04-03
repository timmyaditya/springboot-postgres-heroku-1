package org.timmyaditya.crudUsingJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.timmyaditya.crudUsingJpa.model.StudentModel;

@Repository
public interface StudentModelRepository extends JpaRepository<StudentModel, Integer> {

}
