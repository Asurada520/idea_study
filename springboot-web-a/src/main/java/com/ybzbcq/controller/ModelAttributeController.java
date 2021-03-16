package com.ybzbcq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ModelAttributeController {

	@ModelAttribute
	public void before(Model model) {
		log.info("before..........");
		model.addAttribute("before", "beforeValue");
	}

	@ModelAttribute(value = "beforeArg")
	public String beforeArg() {
		log.info("beforeArg..........");
		return "beforeArgValue";
	}

	@GetMapping(value = "/modelAttribute")
	public String modelAttribute(Model model, @ModelAttribute(value = "beforeArg") String beforeArg) {

		log.info("--------------------------------------");
		log.info("modelAttribute..........");
		log.info("beforeArg..........{}", beforeArg);
		log.info("{}", model);
		return "success";
	}

	@ModelAttribute
	public void after(Model model) {
		log.info("after..........");
		model.addAttribute("after", "afterValue");
	}

	@ModelAttribute(value = "afterArg")
	public String afterArg() {
		log.info("afterArg..........");
		return "afterArgValue";
	}
}