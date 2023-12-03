package org.unc.api.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Transactional
    public void saveStudent(StudentEntity student) {
        studentRepository.save(student);
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Object[]> countStudentsByProgramAndMajor() {
        return studentRepository.countStudentsByProgramAndMajor();
    }
    
    public StudentEntity getStudentById(Long id) {
    	
    	return studentRepository.findById(id).orElseThrow(
    			() -> new RuntimeException("Student not found with id" + id));
    }
    
    public StudentEntity updateStudent(Long id, StudentEntity student) {
        StudentEntity existingStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        return studentRepository.save(existingStudent);
    }
    
    public void deleteStudent(Long id) {
        StudentEntity existingStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        studentRepository.delete(existingStudent);
    }
}
