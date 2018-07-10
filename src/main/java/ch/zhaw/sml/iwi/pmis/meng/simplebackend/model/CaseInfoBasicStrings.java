/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.zhaw.sml.iwi.pmis.meng.simplebackend.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.criteria.CriteriaBuilder;
import lombok.Data;

/**
 *
 * @author peterhe
 */
@Entity
@Data
@DiscriminatorValue("CaseInfoBasicStrings")
public class CaseInfoBasicStrings extends CaseInfo {

    public CaseInfoBasicStrings() {
    }

    
    public CaseInfoBasicStrings(String doctorDefinition, String patientDefinition, String teamDefinition) {
        this.doctorDefinition = doctorDefinition;
        this.patientDefinition = patientDefinition;
        this.teamDefinition = teamDefinition;
    }
    
    @Lob
    private String doctorDefinition;
    
    @Lob
    private String patientDefinition;
    
    @Lob
    private String teamDefinition;

}
