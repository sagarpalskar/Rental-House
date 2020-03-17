package com.home.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.dao.RegisterDao;
import com.home.model.Login;
import com.home.model.Property;
import com.home.model.Register;

@Controller
public class RegisterControler {
	@Autowired
	RegisterDao dao;

	@ModelAttribute("log")
	public Login loh() {
		return new Login();
	}

	@RequestMapping("/test")
	public String test() {
		return "hello";
	}

	@RequestMapping("/Registration")
	public String showform(Model m) {
		m.addAttribute("command", new Register());
		return "RegForm";
	}

	@RequestMapping("/logout")
	public String logOut(Model m, HttpSession session) {
		session.removeAttribute("log");
		session.invalidate();
		// m.addAttribute("command", new Register());
		return "index";
	}

	@RequestMapping(value = "/save")
	public String save(@ModelAttribute("reg") Register reg) {
		dao.save(reg);
		return "LoginForm";

	}

	@RequestMapping("/Login")
	public String showlogform(Model m) {
		m.addAttribute("command", new Login());

		return "LoginForm";
	}


	@RequestMapping(value = "/login12")
	public String save(@ModelAttribute("log") Login log) {
		List<Login> b = dao.check(log);

		if (b.isEmpty()) {
			return "Error";
		} else {
			return "Welcome";
		}
	}

	@RequestMapping(value = "/add")
	public String addproperty(Model m) {

		m.addAttribute("command", new Property());

		return "AddProperty";

	}

	@RequestMapping(value = "/propertyadd")
	public String save(@ModelAttribute("prop") Property prop) {
		dao.addprop(prop);
		return "Succesfull";
	}

	@RequestMapping(value = "/view")
	public String view(Model m) {

		m.addAttribute("command", new Property());
		return "Viewreg";
	}

	@RequestMapping(value = "/edit{Id}")
	public String edit(@PathVariable int Id, Model m) {
		Property property = dao.getPropertyById(Id);
		m.addAttribute("command", property);
		return "EditForm";
	}

	@RequestMapping(value = "/delete{Id}")
	public String delete(@PathVariable int Id) {
		if ( dao.delete(Id)!= 0 ) {
			return "Viewreg";
		} else {
		}
		return "Welcome";
	}

	@RequestMapping(value = "/edit/editsave")
	public String editsave(@ModelAttribute("property") Property property) {
		dao.update(property);
		return "Viewreg";
	}

	@RequestMapping(value = "/Welcome")
	public String homePage() {

		return "Welcome";
	}

}