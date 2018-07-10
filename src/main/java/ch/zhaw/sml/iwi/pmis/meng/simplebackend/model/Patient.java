package ch.zhaw.sml.iwi.pmis.meng.simplebackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int patientenNr;
    
    private String firstName;
    private String lastName;

    public Patient() {
    }

    @OneToOne
    private UserAccount userAccount;
    
    public Patient(int patientenNr, String firstName, String lastName) {
        this.patientenNr = patientenNr;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    
    
}
