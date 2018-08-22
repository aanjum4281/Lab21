package co.grandcircus.coffeeshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.coffeeshop.dao.UserDao;
import co.grandcircus.coffeeshop.dao.ItemsDao;


@Controller
public class CoffeeShopController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ItemsDao itemsDao;
	
	@RequestMapping("/")
	public ModelAndView showHomePage() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("first", "Amna");
		mav.addObject("last", "Anjum ");
		List<Items> items = itemsDao.findAll();
		// Always return a ModelAndView
		return mav;
		
		
		
		
		
//		ModelAndView mav = new ModelAndView("index");
//		List<Items> items = itemsDao.findAll();
//		return new ModelAndView("items", "items", items);
//		
		// Always return a ModelAndView

	}
	
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
				
		userDao.create(user);
		
		ModelAndView mav = new ModelAndView("redirect:/");
		mav.addObject("user", user);
		
		return mav;

	}
	
	
	
}
