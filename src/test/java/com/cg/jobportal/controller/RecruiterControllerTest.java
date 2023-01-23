package com.cg.jobportal.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.cg.jobportal.entity.Recruiter;
import com.cg.jobportal.service.RecruiterService;



@WebMvcTest(RecruiterController.class)
class RecruiterControllerTest {


		@Autowired
		private MockMvc mockMvc;
		
		@MockBean 
		private RecruiterService recruiterService;
		
		private Recruiter recruiter;
		
		@BeforeEach
		void setup() {
			recruiter=new Recruiter(12, "john", "doe", "pass123", "johndoe");
			
		}
		@Test
		void testSaveRecruiter() throws Exception {
			Recruiter recruiterEntity = new Recruiter(12, "john", "doe", "pass123", "johndoe");
			Mockito.when(recruiterService.saveRecruiter(recruiterEntity)).thenReturn(recruiter);
			mockMvc.perform(MockMvcRequestBuilders.post("/saveRecruiter")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\r\n" + 
							"  \"id\": 12,\r\n" + 
							"  \"firstname\": \"john\",\r\n" + 
							"  \"lastname\":\"doe\",\r\n" +
							"\"password\": \"pass123\",\r\n"+ 
							"  \"username\": \"johndoe\"\r\n" + 
							"}"))
					.andExpect(MockMvcResultMatchers.status().isCreated());
		}
}
