package com.covid.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.covid.dao.CovidDao;
import com.covid.model.Covid;

@Controller
public class CovidController {
	
	@Autowired
	private CovidDao cvDao;

	@RequestMapping(value = "/fetch")
	public ModelAndView CovidList() throws IOException {
		ModelAndView model = new ModelAndView();
		List<Covid> covidCases = cvDao.cvlist();
		model.addObject("covidCases", covidCases);
		model.setViewName("index");
		return model;
	}
}
