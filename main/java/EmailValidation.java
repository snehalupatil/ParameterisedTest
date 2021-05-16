import java.util.regex.Pattern;

public class EmailValidation {


    public boolean validateMails(String multipleMailsPattern, String multipleMails) {
        return Pattern.matches(multipleMailsPattern, multipleMails);
    }

    public static void main(String[] args){

    }
}

