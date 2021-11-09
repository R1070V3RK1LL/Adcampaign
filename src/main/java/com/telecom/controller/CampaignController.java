package com.telecom.controller;

import com.telecom.model.Campaign;
import com.telecom.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@Controller

@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class CampaignController {
    @Autowired
    private CampaignRepository campaignRepo;

    @GetMapping("/products")
    public String listAll(Model model) {
        List<Campaign> listCampaigns = campaignRepo.findAll();
        model.addAttribute("listCampaigns", listCampaigns);
        return "campaigns";
    }
    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewCampaign (@RequestParam LocalDate starting_date
            , @RequestParam LocalDate ending_date) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Campaign n = new Campaign();
        n.setStartingDate(starting_date);
        n.setEndingDate(ending_date);
        campaignRepo.save(n);
        return "Saved";
    }

}
