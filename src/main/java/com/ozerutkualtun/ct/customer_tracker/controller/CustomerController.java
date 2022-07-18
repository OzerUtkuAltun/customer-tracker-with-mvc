package com.ozerutkualtun.ct.customer_tracker.controller;

import com.ozerutkualtun.ct.customer_tracker.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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


}
