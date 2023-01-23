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

import com.cg.jobportal.entity.Freelancer;
import com.cg.jobportal.service.FreelancerService;






@WebMvcTest(FreelancerController.class)
class FreelancerControllerTest {


		@Autowired
		private MockMvc mockMvc;
		
		@MockBean 
		private FreelancerService freelancerService;
		
		private Freelancer freelancer;
		
		@BeforeEach
		void setup() {
			freelancer=new Freelancer(20, "billsmith", "bill", "smith",  "pass123");
			
		}
		@Test
		void testSavefreelancer() throws Exception {
			Freelancer freelancerEntity = new Freelancer(20, "billsmith", "bill", "smith",  "pass123");
			Mockito.when(freelancerService.saveFreelancer(freelancerEntity)).thenReturn(freelancer);
			mockMvc.perform(MockMvcRequestBuilders.post("/Freelancer/save")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\r\n" + 
							"  \"id\": 20,\r\n" + 
							"  \"username\": \"billsmith\"\r\n" +
							"  \"firstname\": \"bill\",\r\n" + 
							"  \"lastname\":\"smith\",\r\n" +
							"\"password\": \"pass123\",\r\n"+ 
							 
							"}"))
					.andExpect(MockMvcResultMatchers.status().isCreated());
		}
}



