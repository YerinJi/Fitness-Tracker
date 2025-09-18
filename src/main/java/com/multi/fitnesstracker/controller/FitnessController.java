package com.multi.fitnesstracker.controller;

import com.multi.fitnesstracker.domain.Fitness;
import com.multi.fitnesstracker.service.FitnessService;
import com.multi.fitnesstracker.support.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FitnessController {
    private final FitnessService fitnessService;

    @GetMapping("/fitness")
    public String fitness(@RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "10") int size,
                          @RequestParam(required = false) String q,
                          @RequestParam(required = false) String startDate,
                          @RequestParam(required = false) String endDate,
                          Model model){
        int total = fitnessService.count(q,startDate,endDate);
        Pagination pagination = new Pagination(page, size, total, 5);
        List<Fitness> fitnessList = fitnessService.find(q,startDate,endDate,pagination.getOffset(),pagination.getSize());
        model.addAttribute("fitness",fitnessList);
        model.addAttribute("pagination", pagination);
        model.addAttribute("q", q==null ? "" : q);
        return "fitness";
    }
    @GetMapping("/fitness/view")
    public String view(@RequestParam int id, Model model){
        model.addAttribute("fitness", fitnessService.getFitnessById(id));
        return "fitness/view";
    }
    @GetMapping({"/fitness/new"})
    public String newFitness(){
        return "fitness/new";
    }

    @GetMapping({"/fitness/edit"})
    public String edit(@RequestParam int id, Model model){
        model.addAttribute("fitness",fitnessService.getFitnessById(id));
        return "fitness/edit";
    }
    @PostMapping({"/fitness/update"})
    public String update(Fitness fitness){
        fitnessService.updateFitness(fitness);
        return "redirect:/fitness";
    }
    @PostMapping({"/fitness/delete"})
    public String delete(@RequestParam int id){
        fitnessService.deleteFitness(id);
        return "redirect:/fitness";
    }

    @PostMapping({"/fitness/insert"})
    public String insert(Fitness fitness){
        fitnessService.insertFitness(fitness);
        return "redirect:/fitness";
    }
}
