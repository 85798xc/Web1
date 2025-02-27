package org.example.mapper;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.example.entity.Student;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLTransformer {

    public static void transformToXML(Student student, String filePath) throws JAXBException, IOException {

        JAXBContext context = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        try (FileWriter writer = new FileWriter(filePath)) {
            marshaller.marshal(student, writer);
        }
    }

    public static Student transformToPOJO(String xmlFilePath, String xsdFilePath) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Student.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        // Load and set the XSD schema
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File(xsdFilePath));
        unmarshaller.setSchema(schema);

        // Perform validation and unmarshalling
        return (Student) unmarshaller.unmarshal(new File(xmlFilePath));
    }
}
