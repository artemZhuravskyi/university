package com.artem.university.repository;

import com.artem.university.entity.Department;
import com.artem.university.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);

    @Query("SELECT d.head FROM Department d WHERE d.name = :departmentName")
    Optional<Lector> findHeadByDepartmentName(@Param("departmentName") String departmentName);


}
