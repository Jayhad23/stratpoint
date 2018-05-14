package com.stratpoint.assessment.controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stratpoint.assessment.service.ProfileService;

import model.Profile;

@Controller
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
//	@GetMapping("/profiles")
//    public String profiles(Model model) throws JSONException, IOException {
//        model.addAttribute("profiles", profileService.getProfiles());
//        return "list";
//    }
	
	@ResponseBody
	@GetMapping(value = "/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Profile> getProfiles(@RequestParam(name="name", required=false) String name) throws JSONException, IOException {
		return profileService.getProfiles(name);
	}

	@GetMapping("/profile/{id}")
    public String getProfile(@PathVariable String id, Model model) throws JSONException, IOException {
		model.addAttribute("profile", profileService.getProfile(id));
        return "profile";
    }
}
