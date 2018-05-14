package com.stratpoint.assessment.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import model.Profile;

@RunWith(SpringRunner.class)
public class ProfileServiceImplTest {

	@TestConfiguration
    static class ProfileServiceImplTestContextConfiguration {
  
        @Bean
        public ProfileService profileService() {
            return new ProfileServiceImpl();
        }
    }
	
	@Autowired
    private ProfileService profileService;
 
	@MockBean
    private JsonApiService jsonApiService;
	
	private String jsonText = 
			"[\r\n" + 
			"  {\r\n" + 
			"    \"id\": \"59914e16322c1b042d4fdf2b\",\r\n" + 
			"    \"active\": true,\r\n" + 
			"    \"blocked\": false,\r\n" + 
			"    \"balance\": \"2,839.14\",\r\n" + 
			"    \"picture\": \"http://placehold.it/50x50\",\r\n" + 
			"    \"age\": 24,\r\n" + 
			"    \"name\": {\r\n" + 
			"      \"first\": \"Shepard\",\r\n" + 
			"      \"middle\": \"V\",\r\n" + 
			"      \"last\": \"Potts\"\r\n" + 
			"    },\r\n" + 
			"    \"email\": \"shepard.potts@stratpoint.us\",\r\n" + 
			"    \"phone\": \"+63 (881) 451-3628\",\r\n" + 
			"    \"address\": \"167 Woodhull Street, Oberlin, South Carolina, 3258\",\r\n" + 
			"    \"profile\": \"Tempor fugiat cillum occaecat laboris aliqua labore laboris qui velit culpa nostrud cupidatat. Reprehenderit nulla proident cupidatat commodo ex ad nostrud culpa adipisicing nostrud mollit elit adipisicing sint. Pariatur nulla cillum magna labore qui aliqua nulla nisi. Sint voluptate excepteur veniam sunt et ex est. Non et ea incididunt ut non. Nisi consectetur cupidatat aliquip laborum culpa nostrud fugiat ut culpa est ea veniam deserunt pariatur. Reprehenderit sit exercitation anim labore officia fugiat et amet sint do.\",\r\n" + 
			"    \"date_registered\": 1439564911632\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"id\": \"59914e1633eb7f7472171dd3\",\r\n" + 
			"    \"active\": false,\r\n" + 
			"    \"blocked\": true,\r\n" + 
			"    \"balance\": \"3,664.29\",\r\n" + 
			"    \"picture\": \"http://placehold.it/50x50\",\r\n" + 
			"    \"age\": 32,\r\n" + 
			"    \"name\": {\r\n" + 
			"      \"first\": \"Dina\",\r\n" + 
			"      \"middle\": \"B\",\r\n" + 
			"      \"last\": \"Johnson\"\r\n" + 
			"    },\r\n" + 
			"    \"email\": \"dina.johnson@stratpoint.name\",\r\n" + 
			"    \"phone\": \"+63 (916) 448-3464\",\r\n" + 
			"    \"address\": \"704 Oliver Street, Leyner, Marshall Islands, 4403\",\r\n" + 
			"    \"profile\": \"Laboris anim culpa aliqua qui sint quis cupidatat. Aliquip consequat excepteur magna magna fugiat. Amet qui ut elit ipsum non adipisicing Lorem laboris.\",\r\n" + 
			"    \"date_registered\": 1467501490268\r\n" + 
			"  }\r\n" + 
			"]";
	
	@Before
	public void setUp() throws JSONException, IOException {
	    Mockito.when(jsonApiService.readJsonApi())
	      .thenReturn(new JSONArray(jsonText));
	}
	
	@Test
	public void whenGetProfiles() throws JSONException, IOException {
		List<Profile> profiles = profileService.getProfiles(null);

		assertThat(profiles.size()).isEqualTo(2);
	}
	
	@Test
	public void whenGetProfilesWithValidName_thenProfilesShouldBeFound() throws JSONException, IOException {
		String name = "Shepard";
		List<Profile> profiles = profileService.getProfiles(name);

		assertThat(profiles.size()).isEqualTo(1);
		assertThat(profiles.get(0).getFirstName()).isEqualTo(name);
	}
	
	@Test
	public void whenValidId_thenProfileShouldBeFound() throws JSONException, IOException {
		String id = "59914e16322c1b042d4fdf2b";
		Profile found = profileService.getProfile(id);

		assertThat(found.getId())
		.isEqualTo(id);
	}
}
