package ch.zhaw.sml.iwi.pmis.meng.simplebackend.repository;

import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.Consultation;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.Patient;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE p.userAccount = ?1")
    Patient getPatientByUserAccount(UserAccount u);
}
