package com.stratpoint.assessment.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Profile;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private JsonApiService jsonApiService;

	@Override
	public List getProfiles() throws JSONException, IOException {
		return jsonApiService.readJsonApi().toList();
	}
	
	@Override
	public List<Profile> getProfiles(String name) throws JSONException, IOException {
		List<Profile> result = new ArrayList<Profile>();
		JSONArray profiles = jsonApiService.readJsonApi();
		
		if (name != null) {
			for (int i = 0; i < profiles.length(); i++) {
				JSONObject jsonObj = profiles.getJSONObject(i);
				JSONObject nameJsonObj = jsonObj.getJSONObject("name");
				String fullName = nameJsonObj.getString("first") + nameJsonObj.getString("middle") + nameJsonObj.getString("last");
				
				if (fullName.toLowerCase().contains(name.toLowerCase())) 
					result.add(new Profile(jsonObj));
			}
		} else {
			for (int i = 0; i < profiles.length(); i++) {
				result.add(new Profile(profiles.getJSONObject(i)));
			}
		}
		
		return result;
	}
	
	@Override
	public Profile getProfile(String id) throws JSONException, IOException {
		JSONArray profiles = jsonApiService.readJsonApi();
		
		for (int i = 0; i < profiles.length(); i++) {
			JSONObject json = profiles.getJSONObject(i);
			if (id.equals(json.get("id"))) 
				return new Profile(json);
		}
		
		return null;
	}
}
