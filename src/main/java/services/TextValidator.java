package services;

import utils.ConnectionManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.regex.Pattern;

public class TextValidator {
    String pattern;

    public TextValidator(String regex) {
        pattern = regex;
    }

    public boolean validate(String text) {
        return Pattern.compile(pattern).matcher(text).find();
    }

    /*
    This method exists only to create a good example of testing and mocking. This is a nonsense method.
     */
    public int thisIsMyTestMethod(boolean test) throws IOException {
        FileReader fileReader = new FileReader(new File("someFile.txt"));
        // oops need to look up the proper way to mock constructors with other mocks as parameters
        Connection conn = ConnectionManager.getConnection();
        //String testStr = fileReader.

        //there would be program logic here
        //lets pretend our method should return the value 5

        if(test) {
            return 5;
        } else {
            return -1;
        }
    }

}
