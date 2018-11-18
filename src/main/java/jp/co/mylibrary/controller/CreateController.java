package jp.co.mylibrary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(final Model model,
			@RequestParam(value = "error", required = false, defaultValue = "") String error,
			@RequestParam(value = "logout", required = false, defaultValue = "") String logout) {
		model.addAttribute("isError", !error.isEmpty());
		model.addAttribute("fromLogout", !logout.isEmpty());
		model.addAttribute("refer", "create");
		return "create";
	}
}
