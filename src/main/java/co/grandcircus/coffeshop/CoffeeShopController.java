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
			@RequestParam("password") String password){
		
		// `story` matches the name of the JSP file
		ModelAndView mav = new ModelAndView("summary");
		// `word1` matches `${ word1 } in the JSP
		mav.addObject("word1", first);
		mav.addObject("word2", last);
		mav.addObject("word3", email);
		mav.addObject("word4", phone);
		mav.addObject("word5", password);
		return mav;
	}
	
}
