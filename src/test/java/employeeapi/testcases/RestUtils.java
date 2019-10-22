import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
    public static String getFirstName(){
        String generated_string = RandomStringUtils.randomAlphabetic(1);
        return ("Uday  " + generated_string);
    }

    public static String getLastName(){
        String generated_string = RandomStringUtils.randomAlphabetic(1);
        return ("Sree  " + generated_string);
    }

    public static String getUserName(){
        String generated_string = RandomStringUtils.randomAlphabetic(3);
        return ("Emani  " + generated_string);
    }

    public static String getPassword(){
        String generated_string = RandomStringUtils.randomAlphabetic(3);
        return ("uemani  " + generated_string);
    }

    public static String getEmail(){
        String generated_string = RandomStringUtils.randomAlphabetic(3);
        return (generated_string + "@gmail.com");
    }
}
