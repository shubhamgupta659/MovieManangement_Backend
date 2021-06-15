package com.vmo.backendservices.persistance.Repository;

import com.vmo.backendservices.persistance.Domain.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Long> {

    @Query("SELECT e.department,count(*) FROM EmployeeDetails e GROUP BY e.department ORDER BY e.department ASC")
    List<Object[]> findDepartmentWithCounts();

}
