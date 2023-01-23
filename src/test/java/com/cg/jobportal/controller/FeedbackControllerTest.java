
package com.cg.jobportal.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cg.jobportal.entity.Feedback;
import com.cg.jobportal.entity.Recruiter;
import com.cg.jobportal.service.FeedbackService;




@WebMvcTest(FeedbackController.class)
class FeedbackControllerTest{

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FeedbackService feedbackService;

	private Feedback feedback;


	private Recruiter recruiter;

	@BeforeEach
	void setup() {
		feedback = new Feedback(14, 4, "smith", recruiter);

		

		recruiter= new Recruiter(12, "john", "doe", "pass123", "johndoe");


	}

	@Test
	void testAddFeedback() throws Exception {

		Feedback feedbackEntity = new Feedback(14, 8, "smith", recruiter);
		Mockito.when(feedbackService.addFeedback(feedbackEntity)).thenReturn(feedback);
		mockMvc.perform(MockMvcRequestBuilders.post("/Feedback/save").contentType(MediaType.APPLICATION_JSON).content(
				"{\r\n" + "  \"id\": 12,\r\n" + "  \"firstname\": \"john\",\r\n" + "  \"lastname\":\"doe\",\r\n"
						+ "\"password\": \"pass123\",\r\n" + "  \"username\": \"johndoe\"\r\n" + "}"))
		.andExpect(MockMvcResultMatchers.status().isCreated());
	}
}