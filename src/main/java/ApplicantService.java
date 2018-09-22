import org.kie.api.runtime.KieSession;

public class ApplicantService {

    private KieSession kieSession = new DroolsBeanFactory().getKieSession();

    public String suggestARoleForApplicant(Applicant applicant) {
        kieSession.insert(applicant);
        kieSession.fireAllRules();
        return applicant.getSuggestedRole();

    }
}
