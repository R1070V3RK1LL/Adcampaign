package com.telecom.controller;

import com.telecom.model.Company;
import com.telecom.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@Controller

@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepo;

    @GetMapping("/products")
    public String listAll(Model model) {
        List<Company> listCompanies = companyRepo.findAll();
        model.addAttribute("listCompanies", listCompanies);
        return "companies";
    }

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewCompany(@RequestParam LocalDate starting_date
            , @RequestParam long budget) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Company c= new Company();
        c.setStartingDate(starting_date);
        c.setBudget(budget);
        companyRepo.save(c);
        return "Saved";
    }
}