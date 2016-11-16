package com.niit.kfc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.project.Dao.CategoryDao;
import com.niit.project.Dao.ProductDao;
import com.niit.project.Dao.UserDao;
import com.niit.project.model.Category;
import com.niit.project.model.Product;
import com.niit.project.model.User;






@Controller
public class HomeController {
	
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private Category category;
	@Autowired
	private Product product;
	
	
@RequestMapping(value="/")
public ModelAndView showindex(Model mod)
{
	mod.addAttribute("Defaultpage","true");
	ModelAndView mv=new ModelAndView("/index");
	List<Category> CategoryList = categoryDao.list();
	List<Product> List = productDao.list(); 
	mv.addObject("productList",List);
	mv.addObject("categoryList",CategoryList);
	return mv;

		
}


@RequestMapping(value="/index")
public String showHome(Model mod)
{
	mod.addAttribute("Defaultpage","true");
	return "index";
}
	
		@RequestMapping("/registeruser")
    public String registerUser(Model model) {

    	User user = new User();
       
        model.addAttribute("user", user);

        return "registeruser";

    }
		
		@RequestMapping("/signup")
		public ModelAndView registerUser(@ModelAttribute User user, @RequestParam(value ="email") String email, ModelMap model) {
			ModelAndView mv ;
			String message;
		
			
			if(userDao.isAllReadyRegister(email, true))		{
				
				model.addAttribute("isAllReadyRegister", true);	
				model.addAttribute("isLoginClicked", true);
				message = "Your Email Id All Ready Registered";
			}
			else {
				user.setRole("ROLE_USER");
				userDao.saveorupdate(user);
				model.addAttribute("isLoginClicked", true);
				message = "Your Have Successfully Registered";
			}
			
		
			mv = new ModelAndView("success");
			mv.addObject("message", message);
			return mv;
		}
		
		/*
			
    /*
     * registerUserPost method is used to register user into  the system and to show registration related errors
     *//*
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUserPost(@ModelAttribute("user") User user, BindingResult result,
                                       Model model) {
    	System.out.println("jithu");
        if (result.hasErrors()) {
            return "registeruser";
        }

            user.setRole("ROLE_USER");
        //usersDetail.setEnabled(true);
        //usersDetailService.addUser(usersDetail);
userDao.saveorupdate(user);
        return "success";

    }
    
    */
    @RequestMapping("/Loginpage")

    public String Login()
    {
    
    return "login";

    }
}