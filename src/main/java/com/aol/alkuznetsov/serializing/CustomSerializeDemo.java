package com.aol.alkuznetsov.serializing;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Objects;

/**
 * Using Externalizable interface we can fine-tune the information we want to go to a file. This
 * should produce a file of a smaller size.
 */
public class CustomSerializeDemo {

  // Sample class we try to serialize
  // We define writeExternal and readExternal methods in order to use custom serialization logic.
  // Note: Careful when serializing static classes!
  public static class Person implements Externalizable {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
    }

    // Externalizable API requires a no-arg constructor!
    public Person() {
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
      // write information we can use to restore an object
      out.writeUTF(firstName);
      out.writeUTF(lastName);
      out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
      firstName = in.readUTF();
      lastName = in.readUTF();
      age = in.readInt();

    }
  }

  public void savePerson(Person person, String fileName) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
      oos.writeObject(person);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Person loadPerson(String fileName) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
      return (Person) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

}
