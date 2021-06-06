
package com.vmo.backendservices.persistance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vmo.backendservices.persistance.Domain.EmployeeDetails;;import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer> {

    @Query("SELECT e.department,count(*) FROM EmployeeDetails e GROUP BY e.department ORDER BY e.department ASC")
    List<Object[]> findDepartmentWithCounts();

}
