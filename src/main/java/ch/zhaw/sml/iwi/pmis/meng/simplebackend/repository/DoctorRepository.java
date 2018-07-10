package ch.zhaw.sml.iwi.pmis.meng.simplebackend.repository;

import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.Consultation;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
