package jenkins_demo.jenkins;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for {@link JenkinsController}.
 * <p>
 * This class verifies the behavior of the `index` method in the `JenkinsController` class.
 */
@WebMvcTest(controllers = JenkinsController.class)
public class JenkinsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Tests that the `index` endpoint returns the correct response content and status.
     */
    @Test
    void testIndexReturnsExpectedResponse() throws Exception {
        // Perform GET request and verify response
        mockMvc.perform(get("/jenkis"))
            .andExpect(status()
                .isOk())
            .andExpect(content().string("Hello Jenkins!!!!"));
    }
}