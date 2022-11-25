package com.aol.alkuznetsov.files.content.comparison;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CompareFilesApacheIOUnitTest {

  public static Path filePath1;
  public static Path filePath2;

  @BeforeAll
  public static void setup() throws IOException {
    filePath1 = Files.createTempFile(
        CompareFilesApacheIOUnitTest.class.getSimpleName() + "-test-file-01", ".txt");
    filePath2 = Files.createTempFile(
        CompareFilesApacheIOUnitTest.class.getSimpleName() + "-test-file-02", ".txt");
  }

  @Test
  public void whenFilesIdentical_thenReturnTrue() throws IOException {

    Files.writeString(filePath1, "Test line 1" + System.lineSeparator() + "Test line 2");
    Files.writeString(filePath2, "Test line 1" + System.lineSeparator() + "Test line 2");

    BufferedReader reader1 = Files.newBufferedReader(filePath1);
    BufferedReader reader2 = Files.newBufferedReader(filePath2);

    Assertions.assertTrue(IOUtils.contentEquals(reader1, reader2));
  }

  @Test
  public void whenFilesDifferent_thenReturnFalse() throws IOException {

    Files.writeString(filePath1, "Test line 13" + System.lineSeparator() + "Test line 2");
    Files.writeString(filePath2, "Test line 1" + System.lineSeparator() + "Test line 2");

    BufferedReader reader1 = Files.newBufferedReader(filePath1);
    BufferedReader reader2 = Files.newBufferedReader(filePath2);

    Assertions.assertFalse(IOUtils.contentEquals(reader1, reader2));
  }

  @AfterAll
  public static void cleanup() {
    filePath1.toFile().deleteOnExit();
    filePath2.toFile().deleteOnExit();
  }

}
