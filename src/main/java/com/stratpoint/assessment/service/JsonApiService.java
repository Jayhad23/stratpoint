package com.stratpoint.assessment.service;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;

public interface JsonApiService {
	JSONArray readJsonApi() throws IOException, JSONException;
}
