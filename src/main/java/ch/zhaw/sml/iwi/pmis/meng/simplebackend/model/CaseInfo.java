package ch.zhaw.sml.iwi.pmis.meng.simplebackend.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import javax.persistence.DiscriminatorColumn;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @Type(value = CaseInfoBasicStrings.class, name = "CaseInfoBasicStrings")
})
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "Type")
public abstract class CaseInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
