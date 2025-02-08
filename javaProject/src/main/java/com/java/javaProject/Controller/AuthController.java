package com.java.javaProject.Controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.javaProject.Entity.RoleEnum;
import com.java.javaProject.Entity.User;
import com.java.javaProject.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {
	private final UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("roles", RoleEnum.values());
		return "auth/register";
	}

	@PostMapping("/registerAdd")
	public String register(@ModelAttribute User user, RedirectAttributes redirectAttributes, Model model) {

		if (!userService.registerUser(user)) {

			model.addAttribute("roles", RoleEnum.values());
			return "auth/register";
		}
		redirectAttributes.addFlashAttribute("sweetAlertMessage",
				"Üyelik başarılı! Giriş ekranına yönlendiriliyorsunuz.");
		redirectAttributes.addFlashAttribute("sweetAlertType", "success");
		redirectAttributes.addFlashAttribute("sweetAlertAction", "register");
		redirectAttributes.addFlashAttribute("registeredUserName", user.getNameSurname());
		return "redirect:/auth/login";
	}

	@GetMapping("/login")
	public String showLoginPage() {
		return "auth/login";
	}

	@PostMapping("/loginAdd")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session,
			Model model) {
		Optional<User> user = userService.authenticateUser(username, password);

		if (user == null) {
			model.addAttribute("error", "Geçersiz kullanıcı adı veya şifre.");
			return "auth/login";
		}

		session.setAttribute("loggedInUser", user.get());
		return "redirect:/";
	}

	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
