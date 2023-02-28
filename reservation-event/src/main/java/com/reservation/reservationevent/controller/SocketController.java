package com.reservation.reservationevent.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SocketController {

	@RequestMapping(value="/")
	public String main() {
		return "index";
	}

	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String chat(Locale locale, Model model) {
		return "chat";
	}

	@RequestMapping(value="/admin")
	public String adminPage() {
		return "admin";
	}

	@RequestMapping(value="/member")
	public String memberPage() {
		return "member";
	}

	@RequestMapping(value="/test", method = RequestMethod.POST)
	public String test() {
		return "test";
	}

	@RequestMapping(value="/admin-stomp")
	public String adminStompPage() {
		return "adminStomp";
	}







	@RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
	public void sendMessage(Model model) {
		// model.addAttribute()
	}
}
