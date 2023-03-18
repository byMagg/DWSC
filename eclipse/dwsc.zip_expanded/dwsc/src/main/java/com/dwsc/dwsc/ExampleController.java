package com.dwsc.dwsc;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {
	@RequestMapping("/")
	public @ResponseBody String sayHello() {
		return "Hello!";
	}

	@RequestMapping("/{name}")
	public String sayHello(Map<String, String> model, @PathVariable String name) {
		model.put("name", name);
		return "hellotemplate";
	}

}
