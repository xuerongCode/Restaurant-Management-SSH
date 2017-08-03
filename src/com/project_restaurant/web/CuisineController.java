package com.project_restaurant.web;

import com.project_restaurant.entity.Cuisine;
import com.project_restaurant.service.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by xuero on 2017/8/2.
 */
@Controller
@RequestMapping("/cuisine")
public class CuisineController {

    @Autowired
    private CuisineService cuisineService;

    @RequestMapping("/list")
    public ModelAndView listingAllCuisines(){
        List<Cuisine> cuisines = cuisineService.getAllCuisines();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("detail/cuisineList");
        mav.addObject("cuisineList",cuisines);
        return mav;
    }

    @RequestMapping("/delete/{cuisineId}")
    public String deleteCuisine(@PathVariable("cuisineId") Integer cuidineId){
        cuisineService.deleteCuisine(cuidineId);
        return "redirect:/cuisine/list.do";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCuisine(Cuisine cuisine){
        cuisineService.registerCuisine(cuisine);
        return "redirect:/cuisine/list.do";
    }

    @RequestMapping(value = "/updateView/{cuisineId}")
    public ModelAndView gotoUpdateCuisineView(@PathVariable("cuisineId") Integer cuidineId){
        Cuisine cuisine = cuisineService.getCuisineById(cuidineId);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("detail/updateCuisineView");
        mav.addObject("cuisine",cuisine);
        return mav;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateCuisine(Cuisine cuisine){
        cuisineService.updateCuisine(cuisine);
        return "redirect:/cuisine/list.do";
    }

    @RequestMapping(value = "/search")
    public ModelAndView searchCuisines(@RequestParam("name")String cuisineName){
        List<Cuisine> cuisines = cuisineService.getCuisineByName(cuisineName);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("detail/cuisineList");
        mav.addObject("cuisineList",cuisines);
        return mav;
    }

}
