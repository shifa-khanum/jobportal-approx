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

import com.cg.jobportal.entity.Admin;
import com.cg.jobportal.service.AdminService;

@WebMvcTest(AdminController.class)
class AdminControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AdminService adminService;

	private Admin admin;

	@BeforeEach
	void setup() {
		admin = new Admin(14, "sam", "smith", "samsmith", "sam@gmail.com", "pass123");

	}

	@Test
	void testSaveAdmin() throws Exception {
		Admin adminEntity = new Admin(14, "sam", "smith", "samsmith", "sam@gmail.com", "pass123");
		Mockito.when(adminService.saveAdmin(adminEntity)).thenReturn(admin);
		mockMvc.perform(MockMvcRequestBuilders.post("/Admin/save").contentType(MediaType.APPLICATION_JSON).content(
				"{\r\n" + "  \"id\": 12,\r\n" + "  \"firstname\": \"john\",\r\n" + "  \"lastname\":\"doe\",\r\n"
						+ "\"password\": \"pass123\",\r\n" + "  \"username\": \"johndoe\"\r\n" + "}"))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}
}