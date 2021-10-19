package services;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import utils.ConnectionManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;

public class TextValidatorTest {
    /*
        Test: We want to test the validator, see if the pattern given in the constructor
        passes a validation when a good string is given, and fails when a bad string is given.

        SUT: (our unit) the validate method in the tested class
        TextValidator.validate(String text);

        We won't actually write a test for this, just because the code is so simple that we aren't doing anything
        other than invoking some other method, and being outside our SUT we would just mock it anyway.
        So, there's basically nothing to test.
     */

    //let's test our nonsense method
    @Test
    public void Test_testOurNonsenseMethodForTrue() throws IOException {
        //arrange
        TextValidator sut = new TextValidator("pattern");
        //FileReader mockFileReader = Mockito.mock(FileReader.class);
        Connection mockConn = Mockito.mock(Connection.class);
        Mockito.when(ConnectionManager.getConnection()).thenReturn(mockConn);
        MockedConstruction<FileReader> mockedFileReaderConstruction = Mockito.mockConstruction(FileReader.class);
        MockedConstruction<File> mockedFileConstruction = Mockito.mockConstruction(File.class);
        File mockFile = new File("test.txt");
        FileReader mockFileReader = new FileReader(mockFile);


        //act

        //assert
        Assert.assertEquals(sut.thisIsMyTestMethod(true), 5);
        Assert.assertEquals(sut.thisIsMyTestMethod(false), -1);
    }
}
