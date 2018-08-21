package co.grandcircus.coffeshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeShopController {
	@RequestMapping("/")
	public ModelAndView showHomePage() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("first", "Amna");
		mav.addObject("last", "Anjum ");
		// Always return a ModelAndView
		return mav;
	}
	
	// This controller is accessed at localhost:8080/madlib-form
	@RequestMapping("/registration-form")
	public ModelAndView showForm() {
		// The new ModelAndView indicates what JSP to render
		ModelAndView mav = new ModelAndView("registrationform");
		return mav;
	}
	
	// `/madlib-story` matches the URL in the browser
	@RequestMapping("/summary")
	public ModelAndView showMSummary(
			@RequestParam("first") String first,
			@RequestParam("last") String last,
			@RequestParam("email") String email,
			@RequestParam("phone") String phone,
			@RequestParam("password") String password,
			@RequestParam("age") String age,
			@RequestParam("date") String date ,
			@RequestParam("username") String username ){
		
		//Construct a user from the url params
		User user = new User();
		user.setFirst(first);
		user.setLast(last);
		user.setPhone(phone);
		user.setEmail(email);
		user.setPassword(password);
		user.setAge(age);
		user.setDate(date);
		user.setUsername(username);
		
		
		
		// `story` matches the name of the JSP file
		ModelAndView mav = new ModelAndView("summary");
		// `word1` matches `${ word1 } in the JSP
		mav.addObject("user" , user);
	
		return mav;
	}
	
}
