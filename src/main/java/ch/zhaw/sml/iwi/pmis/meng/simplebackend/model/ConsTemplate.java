package ch.zhaw.sml.iwi.pmis.meng.simplebackend.model;

import java.util.ArrayList;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ConsTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<CaseInfo> caseInfos = new ArrayList<>();


}
