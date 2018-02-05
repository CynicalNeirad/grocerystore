package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    CleaningItemsRepository cleaningRepository;
    @Autowired
    SnacksRepository snacksRepository;
    @Autowired
    CosmeticsRespository cosmeticsRespository;

    @GetMapping("/")
    public String getinvintory(Model model) {
        model.addAttribute(cosmetics, cosmeticsRespository.findAll());
        model.addAttribute(snacks, snacksRepository.findAll());
        model.addAttribute(cleanings, cleaningRepository.findAll());
        return "mainpage";
    }


    @GetMapping("/addCosmetics")
    public String addCosmetics(Model model) {
        model.addAttribute("cosmetics", new Cosmetics()):
        return "cosmeticGet";
    }
    @GetMapping("/addSnacks")
    public String addSnacks(Model model) {
        model.addAttribute("snacks", new Snacks()):
        return "snacksGet";
    }
    @GetMapping("/addCleaning")
    public String addCleaning(Model model) {
        model.addAttribute(cleanings, new CleaningItems());
        return "cleaningGet":

    }

    @PostMapping("/processSnacks")
    public String processSkills(@Valid Snacks snacks, BindingResult result) {
        if (result.hasErrors()) {
            return "snacksGet";
        }
        snacksRepository.save(snacks);
        return "redirect:/";
    }

    @PostMapping("/processCleaning")
    public String processCleaning(@Valid CleaningItems cleaningItems, BindingResult result){
        if (result.hasErrors()) {
            return "cleaningGet";
        }
        cleaningRepository.save(cleaningItems);
        return "redirect:/";
    }

    @PostMapping("/processesCosmetics")
    public String processCosmetics(@Valid Cosmetics cosmetics, BindingResult result){
        if (result.hasErrors()) {
            return "cosmeticsGet";
        }
        cosmeticsRespository.save(cosmetics);
        return "redirect:/";
    }





}
