package com.stratpoint.assessment.controller;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.stratpoint.assessment.controller.ProfileController;
import com.stratpoint.assessment.service.ProfileService;

import model.Profile;

@RunWith(SpringRunner.class)
@WebMvcTest(ProfileController.class)
public class ProfileControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ProfileService profileService;
	
	@Test
	public void givenProfiles_whenGetProfile_thenReturnJsonArray() throws Exception {
		Profile profile = new Profile();
		profile.setId("59914e16322c1b042d4fdf2b");
		
		List<Profile> profiles = Arrays.asList(profile);
		
		given(profileService.getProfiles(null)).willReturn(profiles);

		mvc.perform(get("/profiles")
               .contentType( MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$", hasSize(1)))
               .andExpect(jsonPath("$[0].id", is(profile.getId())))
               ;
	}
}
