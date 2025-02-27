package org.example.WebservicesAssessmentTask1.entity;

import org.example.entity.Student;
import org.example.entity.Subject;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StudentTest {
    @Test
    void testStudentFields() {
        Student student = new Student("Bob", 25, false, 3.5f, 'B',
                Arrays.asList(new Subject("History", 4)));
        assertEquals("Bob", student.getName());
        assertEquals(25, student.getAge());
        assertFalse(student.isEnrolled());
    }
}
