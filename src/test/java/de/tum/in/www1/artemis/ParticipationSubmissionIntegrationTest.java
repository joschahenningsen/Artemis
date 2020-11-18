package de.tum.in.www1.artemis;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;

import de.tum.in.www1.artemis.domain.*;
import de.tum.in.www1.artemis.repository.ExerciseRepository;
import de.tum.in.www1.artemis.repository.ResultRepository;
import de.tum.in.www1.artemis.repository.SubmissionRepository;

public class ParticipationSubmissionIntegrationTest extends AbstractSpringIntegrationBambooBitbucketJiraTest {

    @Autowired
    SubmissionRepository submissionRepository;

    @Autowired
    ExerciseRepository exerciseRepo;

    @Autowired
    ResultRepository resultRepository;

    private TextExercise textExercise;

    @BeforeEach
    public void initTestCase() {
        database.addUsers(2, 2, 2);
        Course course = database.addCourseWithOneReleasedTextExercise();
        textExercise = database.findTextExerciseWithTitle(course.getExercises(), "Text");
    }

    @AfterEach
    public void tearDown() {
        database.resetDatabase();
    }

    @Test
    @WithMockUser(username = "instructor1", roles = "INSTRUCTOR")
    public void deleteSubmissionOfParticipation() throws Exception {
        Submission submissionWithResult = database.addSubmission(textExercise, new TextSubmission(), "student1");
        submissionWithResult = database.addResultToSubmission(submissionWithResult, null);
        Long participationId = submissionWithResult.getParticipation().getId();
        Long submissionId = submissionWithResult.getId();

        // There should be a submission found by participation.
        assertThat(submissionRepository.findByParticipationId(participationId)).hasSize(1);

        request.delete("/api/submissions/" + submissionId + "/", HttpStatus.OK);
        Optional<Submission> submission = submissionRepository.findById(submissionId);

        // Submission should now be gone.
        assertThat(submission.isPresent()).isFalse();
        // Make sure that also the submission was deleted.
        assertThat(submissionRepository.findByParticipationId(participationId)).hasSize(0);
        // Result is deleted.
        assertThat(resultRepository.findById(submissionWithResult.getResult().getId()).isPresent()).isFalse();
    }

    @Test
    @WithMockUser(username = "student1", roles = "USER")
    public void deleteParticipation_forbidden_student() throws Exception {
        request.delete("/api/submissions/" + 1, HttpStatus.FORBIDDEN);
    }

    @Test
    @WithMockUser(username = "tutor1", roles = "TA")
    public void deleteParticipation_forbidden_tutor() throws Exception {
        request.delete("/api/submissions/" + 1, HttpStatus.FORBIDDEN);
    }

    @Test
    @WithMockUser(username = "instructor1", roles = "INSTRUCTOR")
    public void deleteParticipation_notFound() throws Exception {
        request.delete("/api/submissions/" + 1, HttpStatus.NOT_FOUND);
    }
}
