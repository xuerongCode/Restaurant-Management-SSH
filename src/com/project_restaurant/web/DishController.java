package com.project_restaurant.web;

import com.project_restaurant.entity.Cuisine;
import com.project_restaurant.entity.Dish;
import com.project_restaurant.service.CuisineService;
import com.project_restaurant.service.DishService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by xuero on 2017/8/2.
 */
@RequestMapping("/dish")
@Controller
public class DishController {

    @Autowired
    private DishService dishService;
    @Autowired
    private CuisineService cuisineService;
    @Autowired
    ServletContext context;

    @RequestMapping("/list")
    public ModelAndView listingAllDishes(){
        List<Dish> dishes = dishService.getAllDishes();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("detail/dishList");
        mav.addObject("dishes",dishes);
        System.out.println(context);
        return mav;
    }

    @RequestMapping("/delete/{dishId}")
    public String deleteDish(@PathVariable("dishId") Integer dishId){
        dishService.deleteDish(dishId);
        return "redirect:/dish/list.do";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView searchDishes(@RequestParam("name") String dishName){
        List<Dish> dishes = dishService.getDishesByName(dishName);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("detail/dishList");
        mav.addObject("dishes",dishes);
        return mav;
    }

    @RequestMapping(value = "/update/{dishId}")
    public ModelAndView gotoUpdateDishView(@PathVariable("dishId") Integer dishId){
        Dish dish = dishService.getDishById(dishId);
        List<Cuisine> cuisines = cuisineService.getAllCuisines();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("detail/updateDishView");
        mav.addObject("dish",dish);
        mav.addObject("cuisines",cuisines);
        return mav;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateDish(@RequestParam("cuisine_id") Integer cuisineId, Dish dish, @RequestParam("file")MultipartFile file) throws IOException {
        if(!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String realPath = context.getRealPath("/backEnd/img");
            fileName = UUID.randomUUID() + "_" + fileName;
            String location = realPath + File.separator + fileName;

            File directory = new File(realPath);
            if (!directory.exists()) {
                directory.mkdir();
            }

            file.transferTo(new File(location));
            dish.setImgPath("/backEnd/img/"+fileName);
        }
        dishService.updateDish(dish,cuisineId);
        return "redirect:/dish/list.do";
    }

    @RequestMapping("/add/view")
    public ModelAndView gotoAddDishView(){
        List<Cuisine> cuisines = cuisineService.getAllCuisines();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("detail/saveDish");
        mav.addObject("cuisines",cuisines);
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addDish(@RequestParam("cuisineId") Integer cuisineId, Dish dish, @RequestParam("file")MultipartFile file) throws IOException {
        if(!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String realPath = context.getRealPath("/backEnd/img");
            fileName = UUID.randomUUID() + "_" + fileName;
            String location = realPath + File.separator + fileName;

            File directory = new File(realPath);
            if (!directory.exists()) {
                directory.mkdir();
            }
            file.transferTo(new File(location));
            dish.setImgPath("/backEnd/img/"+fileName);
        }
        dish.setCuisine(new Cuisine(cuisineId));
        dishService.registerDish(dish);
        return "redirect:/dish/list.do";
    }
}
