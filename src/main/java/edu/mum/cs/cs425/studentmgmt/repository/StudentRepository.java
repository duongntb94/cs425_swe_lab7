package edu.mum.cs.cs425.studentmgmt.repository;

import edu.mum.cs.cs425.studentmgmt.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author duong at 7/1/21
 * @project StudentMgmtApp
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
