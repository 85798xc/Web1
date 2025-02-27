package org.example.WebservicesAssessmentTask1.mapper;

import org.example.entity.Student;
import org.example.entity.Subject;
import org.example.mapper.XMLTransformer;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class XMLTransformerTest {
    private static final String TEST_XML_FILE = "test_student.xml";
    private static final String TEST_XSD_FILE = "test_student.xsd";
    @Test
    void testTransformToXML() throws Exception {
        Student student = new Student("Alice", 22, true, 3.9f, 'A',
                Arrays.asList(new Subject("Math", 4), new Subject("Physics", 3)));
        XMLTransformer.transformToXML(student, TEST_XML_FILE);
        File file = new File(TEST_XML_FILE);
        assertTrue(file.exists());
    }

    @Test
    void testTransformToPOJO() throws Exception {
        Student student = XMLTransformer.transformToPOJO(TEST_XML_FILE,TEST_XSD_FILE);
        assertNotNull(student);
        assertEquals("Alice", student.getName());
        assertEquals(22, student.getAge());
        assertEquals(2, student.getSubjects().size());
    }
}
