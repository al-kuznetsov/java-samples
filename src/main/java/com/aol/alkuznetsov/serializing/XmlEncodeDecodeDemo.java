package com.aol.alkuznetsov.serializing;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Objects;

/**
 * We can serialize Java objects as XML with the help of XMLEncoder.
 */
public class XmlEncodeDecodeDemo {

  // Sample class we try to encode as XML
  // XMLEncoder requires a class to comply with Java Bean spec:
  // no-arg constructor
  // getter / setter methods
  public static class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person() {
    }

    public Person(String firstName, String lastName, int age) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
    }

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Person person = (Person) o;
      return age == person.age && Objects.equals(firstName, person.firstName)
          && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
      return Objects.hash(firstName, lastName, age);
    }

  }

  public void xmlEncode(Person person, String fileName) {
    try (XMLEncoder xmlEncoder = new XMLEncoder(
        new BufferedOutputStream(new FileOutputStream(fileName)))) {
      // This is a demo. Useful in case of recoverable exceptions
      xmlEncoder.setExceptionListener(e -> System.out.println("Exception: " + e.toString()));
      xmlEncoder.writeObject(person);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public Person xmlDecode(String fileName) {
    try(XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(fileName)))) {
      return (Person) xmlDecoder.readObject();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

}
