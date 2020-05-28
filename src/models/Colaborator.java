package models;

import java.util.regex.Pattern;

public class Colaborator {

    private String code;
    private String fullName;
    private String email;

    private final Pattern patt = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])");

    /**
     *
     * @param c Code
     * @param fName Full name
     * @param e E-mail
     * @throws IllegalArgumentException Invalid e-mail
     */
    public Colaborator(String c, String fName, String e) throws IllegalArgumentException {
        if(isEmailValid(e)){
            this.fullName = fName;
            this.code = c;
            this.email = e;
        }
        else{
            throw new IllegalArgumentException("The email is not correct.");
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(isEmailValid(email)){
            this.email = email;
        }
    }

    /**
     * Checks with regex if a given e-mail is valid.
     * @param email E-mail address
     * @return boolean
     */
    private boolean isEmailValid(String email){
        return patt.matcher(email).matches();
    }

}
