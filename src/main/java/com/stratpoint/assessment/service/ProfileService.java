package com.stratpoint.assessment.service;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;

import model.Profile;

public interface ProfileService {
	List getProfiles() throws JSONException, IOException;
	List<Profile> getProfiles(String name) throws JSONException, IOException;
	Profile getProfile(String id) throws JSONException, IOException;
}
