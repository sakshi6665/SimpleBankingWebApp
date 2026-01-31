package com.sakshi.simplebankingwebapp.controller;

import com.sakshi.simplebankingwebapp.model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BankController {

    private BankAccount account;
    private String message = "";

    @GetMapping("/")
    public String createAccountPage() {
        return "create-account";
    }

    @PostMapping("/create")
    public String createAccount(@RequestParam String name,
                                @RequestParam int accNo) {
        account = new BankAccount(name, accNo, 0);
        message = "Account created successfully!";
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("account", account);
        model.addAttribute("message", message);
        return "dashboard";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam double amount) {
        message = account.deposit(amount);
        return "redirect:/dashboard";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam double amount) {
        message = account.withdraw(amount);
        return "redirect:/dashboard";
    }
}
