package com.ozerutkualtun.ct.customer_tracker.controller;

import com.ozerutkualtun.ct.customer_tracker.model.Customer;
import com.ozerutkualtun.ct.customer_tracker.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        customerService.saveCustomer(customer);
        return "redirect:/customers/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") Integer customerId, Model model) {

        // get the customer from db

        Customer customer = customerService.getCustomerById(customerId);

        // set customer as a model attribute to pre-populate the form

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("delete")
    public String deleteCustomer(@RequestParam("customerId") Integer customerId) {

        customerService.deleteCustomerById(customerId);

        return "redirect:/customers/list";

    }


}
