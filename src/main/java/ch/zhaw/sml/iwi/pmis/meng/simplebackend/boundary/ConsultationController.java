package ch.zhaw.sml.iwi.pmis.meng.simplebackend.boundary;

import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.Consultation;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.Patient;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.UserAccount;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.repository.ConsultationRepository;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.repository.PatientRepository;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ConsultationController {

    public ConsultationController() {
        System.out.println("ch.zhaw.sml.iwi.pmis.meng.simplebackend.boundary.ConsultationsService.<init>()");
    }


    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private ConsultationRepository consultationRepository;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/consultation")
    @Secured({"ROLE_DOCTOR"})
    public List<Consultation> getAllConsultaions() {
        List<Consultation> resList = new ArrayList<>();
        for(Consultation c : consultationRepository.findAll()) {
            resList.add(c);
        }
        return resList;
    }
    
    @GetMapping("/patientRecord")
    @Secured({"ROLE_PATIENT"})
    public Patient getPatientRecord() {
         SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserAccount user = userAccountRepository.findById(authentication.getName()).get();

        return patientRepository.getPatientByUserAccount(user);
    }
    
    
    @GetMapping("/login")
    public Authentication getLoginInfo() {
         SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        return authentication;
    }
    

}
