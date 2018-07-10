package ch.zhaw.sml.iwi.pmis.meng.simplebackend.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne (fetch = FetchType.EAGER)
    private Patient patient;

    @ManyToOne (fetch = FetchType.EAGER)
    private Doctor doctor;

    @OneToMany
    private  List<CaseInfo> caseInfos = new ArrayList<>();

}
