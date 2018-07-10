package ch.zhaw.sml.iwi.pmis.meng.simplebackend.service;

import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.Consultation;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.Patient;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.UserAccount;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.repository.ConsultationRepository;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.repository.PatientRepository;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private ConsultationRepository  consultationRepository;

    public Patient getPatientRecord() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserAccount user = userAccountRepository.findById(authentication.getName()).get();

        return patientRepository.getPatientByUserAccount(user);
    }

    public List<Consultation> getAllConsultaions() {
        List<Consultation> resList = new ArrayList<>();
        for(Consultation c : consultationRepository.findAll()) {
            resList.add(c);
        }
        return resList;
    }
}
