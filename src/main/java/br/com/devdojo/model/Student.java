package br.com.devdojo.model;

import javax.persistence.Entity;

/**
 * @author William Suane for DevDojo on 6/5/17.
 */
@Entity
public class Student extends AbstractEntity {
    
    private static final long serialVersionUID = 1L;
    private String name;
    
    
    // @NotEmpty
    // @Email(message = "Digite um email válido")
    // private String email;

    // public Student() {
    // }

    // public Student(String name, String email) {
    //     this.name = name;
    //     this.email = email;
    // }
    // public Student(Long id, String name, String email) {
    //     this.id = id;
    //     this.name = name;
    //     this.email = email;
    // }

    // @Override
    // public String toString() {
    //     return "Student{" +
    //             "name='" + name + '\'' +
    //             ", email='" + email + '\'' +
    //             '}';
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
