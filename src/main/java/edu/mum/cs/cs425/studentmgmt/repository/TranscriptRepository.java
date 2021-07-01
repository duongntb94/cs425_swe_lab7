package edu.mum.cs.cs425.studentmgmt.repository;

import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import org.springframework.data.repository.CrudRepository;

/**
 * @author duong at 7/1/21
 * @project StudentMgmtApp
 */
public interface TranscriptRepository extends CrudRepository<Transcript, Long> {
}
