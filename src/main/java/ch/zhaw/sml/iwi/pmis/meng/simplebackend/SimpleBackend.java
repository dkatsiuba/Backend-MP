package ch.zhaw.sml.iwi.pmis.meng.simplebackend;

import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.CaseInfo;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.CaseInfoBasicStrings;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.Consultation;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.Doctor;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.Patient;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.UserAccount;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.UserRole;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.repository.CaseInfoRepository;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.repository.ConsultationRepository;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.repository.DoctorRepository;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.repository.PatientRepository;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.repository.UserAccountRepository;
import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleBackend  {
  public static void main(String[] args) {
        SpringApplication.run(SimpleBackend.class, args);
    }

   /* public SimpleBackend() {

    }
    */
    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    
    @Autowired
    private CaseInfoRepository caseInfoRepository;
    
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            
            UserAccount u = new UserAccount();
            u.setLoginName("gregory");
            u.setAndHashPassword("abc123");
            u.setRoles(new UserRole[]{UserRole.ROLE_USER, UserRole.ROLE_DOCTOR});
            userAccountRepository.save(u);
            
            u = new UserAccount();
            u.setLoginName("george");
            u.setAndHashPassword("abc123");
            u.setRoles(new UserRole[]{UserRole.ROLE_USER, UserRole.ROLE_PATIENT});
            userAccountRepository.save(u);
            
            Doctor d = new Doctor("Gregory","House");
            Patient p = new Patient(123456,"George","Clooney");
            p.setUserAccount(u);
            doctorRepository.save(d);
            patientRepository.save(p);
            
            CaseInfo ci;
            ci = new CaseInfoBasicStrings("Was für House", "Was für Clooney", "Für's Memorial State Hospital");
            caseInfoRepository.save(ci);
            
            Consultation cons = new Consultation();
            cons.setDoctor(d);
            cons.setPatient(p);
            cons.getCaseInfos().add(ci);
            consultationRepository.save(cons);
            
        };
    }

}
