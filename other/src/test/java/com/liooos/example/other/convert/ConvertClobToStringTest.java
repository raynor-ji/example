package com.liooos.example.other.convert;

import org.junit.jupiter.api.Test;

import javax.sql.rowset.serial.SerialClob;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.sql.Clob;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertClobToStringTest {
    @Test
    public void givenCLOB_whenConvertToString_thenCorrect() throws SQLException, IOException {
        String sampleText = "This is a sample CLOB content.";
        Clob clob = new SerialClob(sampleText.toCharArray());

        String clobAsString;
        try (Reader reader = clob.getCharacterStream();
             StringWriter w = new StringWriter()) {
            char[] buffer = new char[4096];
            int charsRead;
            while ((charsRead = reader.read(buffer)) != -1) {
                w.write(buffer, 0, charsRead);
            }
            clobAsString = w.toString();
        }

        assertEquals(sampleText, clobAsString);
    }

    @Test
    public void givenString_whenConvertToCLOB_thenCorrect() throws SQLException {
        String sampleText = "This is a sample text to be stored as CLOB.";
        char[] charArray = sampleText.toCharArray();
        Clob clob = new SerialClob(charArray);

        assertEquals(sampleText, clob.getSubString(1, (int) clob.length()));
    }
}
