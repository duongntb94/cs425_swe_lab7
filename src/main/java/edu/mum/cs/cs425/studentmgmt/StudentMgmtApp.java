package edu.mum.cs.cs425.studentmgmt;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.ClassroomRepository;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.mum.cs.cs425.studentmgmt.repository.TranscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class StudentMgmtApp implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private TranscriptRepository transcriptRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentMgmtApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Task 1.
        Student student1 = new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.of(2019, 5, 24));
        Student studentResult = saveStudent(student1);
        System.out.println("Student result: " + studentResult);

        // Task 2.
        Student student2 = new Student("000-61-0002", "Duong", "Thai", "Nguyen", 4.0, LocalDate.of(2020, 5, 24));
        student2 = saveStudent(student2);
        Transcript transcript2 = new Transcript("MS Computer Science");
        transcript2.setStudent(student2);
        Transcript transcriptResult = saveTranscript(transcript2);
        System.out.println("Transcript result: " + transcriptResult);

        // Task 3.
        Classroom classroom4 = new Classroom("McLaughlin", "M113");
        Student student3 = new Student("000-61-0003", "Thong", "Anh", "Tran", 4.0, LocalDate.of(2020, 8, 24));
        Student student4 = new Student("000-61-0004", "Nhan", "Thanh", "Nguyen", 4.0, LocalDate.of(2020, 8, 24));
        student3.setClassroom(classroom4);
        student4.setClassroom(classroom4);
        classroom4.setStudents(Arrays.asList(student3, student4));
        Classroom classroomResult = saveClassroom(classroom4);
        System.out.print("Classroom result: " + classroomResult);
    }

    private Student saveStudent(Student student) {
        return this.studentRepository.save(student);
    }

    private Transcript saveTranscript(Transcript transcript) {
        return this.transcriptRepository.save(transcript);
    }

    private Classroom saveClassroom(Classroom classroom) {
        return this.classroomRepository.save(classroom);
    }

}
