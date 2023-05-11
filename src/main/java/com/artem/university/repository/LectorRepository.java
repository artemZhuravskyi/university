package com.artem.university.repository;

import com.artem.university.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {

    @Query("SELECT COUNT(l) FROM Lector l JOIN l.departments d WHERE d.name = :departmentName")
    Optional<Integer> countLectorsByDepartmentName(@Param("departmentName") String departmentName);

    @Query("SELECT AVG(l.salary) FROM Lector l JOIN l.departments d WHERE d.name = :departmentName")
    Optional<Integer> findAverageSalaryByDepartmentName(@Param("departmentName") String departmentName);

    List<Lector> findByFullNameContaining(String fullName);
}
