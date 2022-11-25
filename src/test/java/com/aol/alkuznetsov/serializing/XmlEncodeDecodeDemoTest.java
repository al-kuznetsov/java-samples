package com.aol.alkuznetsov.serializing;

import com.aol.alkuznetsov.serializing.XmlEncodeDecodeDemo.Person;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class XmlEncodeDecodeDemoTest {

  @Test
  public void givenPerson_whenEncodeDecode_thenEqualObjects() throws IOException {
    Person person = new Person("Ivan", "Man", 25);
    String tmpFileName = System.getProperty("java.io.tmpdir") + "person.xml";
    Files.deleteIfExists(Paths.get(tmpFileName));

    XmlEncodeDecodeDemo demo = new XmlEncodeDecodeDemo();

    demo.xmlEncode(person, tmpFileName);
    Person decodedPerson = demo.xmlDecode(tmpFileName);

    Files.deleteIfExists(Paths.get(tmpFileName));

    Assertions.assertEquals(person, decodedPerson,
        "XML encoded object and the decoded object are not equal");
  }

}
