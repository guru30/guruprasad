package com.niit.kfc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.niit.project.Dao.CartDao;
import com.niit.project.Dao.ProductDao;
import com.niit.project.Dao.UserDao;
import com.niit.project.model.Cart;
import com.niit.project.model.Product;
import com.niit.project.model.User;



@Controller
@SessionAttributes("email")
public class CartController {
	

		@Autowired(required = true)
		private ProductDao productDao;
		
		@Autowired(required = true)
		private UserDao userDao;
		
		@Autowired
		private CartDao cartDao;
		
		@Autowired
		private Cart cart;
	
		@RequestMapping("/cart/{id}")
		public ModelAndView viewProductDetails(@PathVariable("id") String Id, @ModelAttribute(value ="email") String email) {
			Product product = productDao.get(Id);
			ModelAndView mv = new ModelAndView("/success");
			
			mv.addObject("isProductClicked",true);
			mv.addObject("product", product);
			if(email != null){
				mv.addObject("isLoggedInUser", true);
			}
			//mv.addObject(userName);
		  return mv;		  
		 }
	
		@RequestMapping("/addToCart/{username}/{Id}")
		public String addCart(@ModelAttribute("username") String username, @PathVariable("Id") String Id, Model model){
			
			Product product = productDao.get(Id);
			User user = userDao.get(username);
			
			if(product.getProduct_Stock() > 1){
				
				
				cart.setProductName(product.getName());
				cart.setPrice(product.getPrice());
				cart.setQuantity(1);
				cart.setStatus("N");
				cart.setUserName(user.getName());
				cart.setUserId(user.getEmail());
				
			
				
				int stock = product.getProduct_Stock() - 1;
				product.setProduct_Stock(stock);
				
				cartDao.saveOrUpdate(cart);
				productDao.saveOrUpdate(product);
				model.addAttribute("isLoggedInUser", true);
				String message = "You Have Successfully Logged In";
				model.addAttribute("msg", message);
				
				
			}
			else{
				
				model.addAttribute("outOfStock", "Out Of Stock");
				
			}
			
			
			
			
		
			
			//List<Cart> cartList = cartDAO.list(user.getId());
			//long total = cartDAO.getTotalAmount(user.getId());
	 		//ModelAndView mv = new ModelAndView();
	 	//	mv.addObject("isAddToCartClicked", true);
			//mv.addObject("cartList", cartList);
		//	mv.addObject("total", total);
			
			return "redirect:/myCart/{username}";
		}
		
		@RequestMapping("/myCart/{username}")
		public  ModelAndView myCart(@PathVariable("username") String username)
		{	
			User user = userDao.get(username);
			
			List<Cart> cartList = cartDao.list(user.getEmail()); 
		
			
			long total = cartDao.getTotalAmount(user.getEmail());
			
			long count = cartDao.getCount(username);
			
			String message = "You Have Successfully Logged In";
			
			ModelAndView mv = new ModelAndView("/success");
			mv.addObject("msg", message);
			mv.addObject("isLoggedInUser", true);
			mv.addObject("isMyCartClicked", true);
			mv.addObject("numberOfProduct", count);
			mv.addObject("cartList", cartList);
			mv.addObject("total", total);
			
			return mv;
			
		}
		
		@RequestMapping("deletecart/{productName}")
		public String deleteCart(@PathVariable ("productName") String productName, Model model){
		
			cartDao.delete(productName);
			model.addAttribute("isMyCartClicked", true);
			
			model.addAttribute("isLoggedInUser", true);
			String message = "You Have Successfully Logged In";
			model.addAttribute("msg", message);
			return "success";
			
		}
		
		/*@ModelAttribute
		public void commonObject(Model model){	
			
			model.addAttribute("isLoggedInUser", true);
			String message = "You Have Successfully Logged In";
			model.addAttribute("msg", message);
		}*/
		
		
	}



