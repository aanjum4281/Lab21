package co.grandcircus.coffeeshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.coffeeshop.dao.ItemsDaoHibernate;
import co.grandcircus.coffeeshop.dao.UserDaoHibernate;

@Controller
public class CoffeeShopController {

	@Autowired
	private UserDaoHibernate userDao;

	@Autowired
	private ItemsDaoHibernate itemsDao;

	@RequestMapping("/")
	public ModelAndView showHomePage() {
		ModelAndView mav = new ModelAndView("index");
		List<Items> items = itemsDao.findAll();
		mav.addObject("first", "Amna");
		mav.addObject("last", "Anjum ");
		mav.addObject("items", items);

		// Always return a ModelAndView
		return mav;

	}

	@RequestMapping("/registration-form")
	public ModelAndView showForm() {
		// The new ModelAndView indicates what JSP to render
		ModelAndView mav = new ModelAndView("registrationform");
		return mav;
	}

	@RequestMapping("/admin-form")
	public ModelAndView showAdmin() {
		ModelAndView mav = new ModelAndView("adminform");
		List<Items> items = itemsDao.findAll();
		mav.addObject("first", "Amna");
		mav.addObject("last", "Anjum ");
		mav.addObject("items", items);

		// Always return a ModelAndView
		return mav;
	}

	@RequestMapping("/add-item")
	public ModelAndView showAdd() {
		ModelAndView mav = new ModelAndView("additem");
		return mav;

	}

	// `/madlib-story` matches the URL in the browser
	@PostMapping("/summary")
	public ModelAndView showMSummary(@RequestParam("first") String first, @RequestParam("last") String last,
			@RequestParam("email") String email, @RequestParam("phone") String phone,
			@RequestParam("password") String password, @RequestParam("age") String age,
			@RequestParam("date") String date, @RequestParam("username") String username) {

		// Construct a user from the url params
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

		ModelAndView mav = new ModelAndView("/summary");
		mav.addObject("user", user);

		return mav;

	}

	@RequestMapping("/add")
	public ModelAndView showNew(

			@RequestParam("name") String name, @RequestParam("description") String description,
			@RequestParam("quantity") String quantity, @RequestParam("price") String price) {

		Items items = new Items();

		items.setName(name);
		items.setDescription(description);
		items.setQuantity(quantity);
		items.setPrice(price);

		itemsDao.create(items);
		ModelAndView mav = new ModelAndView("/summary");
		mav.addObject("items", items);

		return mav;

	}

	// path variable required to identify which food we're editing
	@RequestMapping("/update-item")
	public ModelAndView showEditForm(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("updateitem");
		mav.addObject("items", itemsDao.findById(id));
		mav.addObject("title", "Edit Items");
		return mav;
	}

	// same URL but different method
	@RequestMapping( "/update-item-form")
	public ModelAndView submitEditForm(Items items) {
		
		itemsDao.update(items);
		return new ModelAndView("redirect:/");
	}

	// delete item
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("id") Long id) {
		itemsDao.delete(id);
		return new ModelAndView("redirect:/");
	}

}
