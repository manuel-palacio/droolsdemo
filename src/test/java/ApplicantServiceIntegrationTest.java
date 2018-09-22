import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class ApplicantServiceIntegrationTest {


    private ApplicantService applicantService;

    @Before
    public void setup() {
        applicantService = new ApplicantService();
    }

    @Test
    public void whenCriteriaMatching_ThenSuggestManagerRole() throws IOException {
        Applicant applicant = new Applicant("Davis", 37, 1600000.0, 11);

        assertEquals("Manager", applicantService.suggestARoleForApplicant(applicant));
    }

    @Test
    public void whenCriteriaMatching_ThenSuggestSeniorDeveloperRole() throws IOException {
        Applicant applicant = new Applicant("John", 37, 1200000.0, 8);
        assertEquals("Senior developer", applicantService.suggestARoleForApplicant(applicant));
    }

    @Test
    public void whenCriteriaMatching_ThenSuggestDeveloperRole() throws IOException {
        Applicant applicant = new Applicant("Davis", 37, 800000.0, 3);
        assertEquals("Developer", applicantService.suggestARoleForApplicant(applicant));
    }

    @Test
    public void whenCriteriaNotMatching_ThenNoRole() throws IOException {
        Applicant applicant = new Applicant("John", 37, 1200000.0, 5);
        assertNull(applicantService.suggestARoleForApplicant(applicant));
    }
}
