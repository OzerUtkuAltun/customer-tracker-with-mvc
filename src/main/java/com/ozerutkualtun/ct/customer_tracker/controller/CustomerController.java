package com.ozerutkualtun.ct.customer_tracker.controller;

import com.ozerutkualtun.ct.customer_tracker.model.Customer;
import com.ozerutkualtun.ct.customer_tracker.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {

        model.addAttribute("customers", customerService.getCustomers());
        return "customer-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAddingCustomer(Model model) {

        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {

        customerService.saveCustoemr(customer);
        return "redirect:/customers/list";
    }


}
