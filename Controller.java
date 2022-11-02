package com.Tele.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@PropertySource(value = { "C:\\Users\\User - 2\\Downloads\\Get\\src\\main\\java\\com\\Tele\\Controller\\read.properties" })
@SpringBootApplication(scanBasePackages = ("com.calculation"))
@RestController
@RequestMapping("/api/")
public class Controller {
	long ans;
	
	@Autowired TestService objTestService;

	@RequestMapping(value = "testApi", method = RequestMethod.GET)
	public ResponseEntity<?> testApi(@RequestParam String operation, @RequestParam long number1,
			@RequestParam long number2) throws Exception {

		switch (operation) {
		case "add":
			ans = objTestService.add(number1, number2);
			break;
		case "sub":
			ans = objTestService.sub(number1, number2);
			break;
		case "mul":
			ans = objTestService.mul(number1, number2);
			break;
		case "div":
			ans = objTestService.div(number1, number2);
			break;
		default:
			ans = -1;
			break;

		}
		// requestParams.put("Service" , );
		return new ResponseEntity<>(ans, HttpStatus.OK);

	}
}
