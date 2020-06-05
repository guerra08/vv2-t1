package br.com.guerra08.app.model;

import br.com.guerra08.app.helpers.Validator;

import javax.persistence.*;

@Entity
@Table(name = Collaborator.TABLE_NAME)
public class Collaborator {

    public static final String TABLE_NAME= "COLLABORATORS";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String fullName;
    private String email;

    protected Collaborator() {}

    /**
     *
     * @param code Code
     * @param fName Full name
     * @param email E-mail
     * @throws IllegalArgumentException Invalid e-mail
     */
    public Collaborator(String code, String fName, String email) throws IllegalArgumentException {
        if(Validator.isEmailValid(email)){
            this.fullName = fName;
            this.code = code;
            this.email = email;
        }
        else{
            throw new IllegalArgumentException("The email is not correct.");
        }
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

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

    public void setEmail(String email) { if(Validator.isEmailValid(email)) this.email = email; }

    @Override
    public String toString(){
        return String.format("Código: %s - Nome completo: %s - E-mail: %s", this.code, this.fullName, this.email);
    }

}
