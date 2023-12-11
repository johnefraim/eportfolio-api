package org.unc.api.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.unc.api.user.User;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    @Query("SELECT s.programAndMajor, COUNT(s) FROM StudentEntity s GROUP BY s.programAndMajor")
    List<Object[]> countStudentsByProgramAndMajor();
    StudentEntity findByUser(User user);
}
