package com.project_restaurant.web;

import com.project_restaurant.entity.Table;
import com.project_restaurant.service.TableService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * Created by xuero on 2017/8/2.
 */

@Controller
@RequestMapping("/table")
public class TableController {

    @Autowired
    private TableService tableService;

    @RequestMapping("/list")
    public ModelAndView listingAllTables(){
        List<Table> tables = tableService.getAllTables();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("detail/boardList");
        mav.addObject("tableList",tables);
        return mav;
    }

    @RequestMapping("/delete/{tableId}")
    public ModelAndView deleteTable(@PathVariable("tableId") String tableId){
        tableService.deleteTable(Integer.parseInt(tableId));
        return new ModelAndView("redirect:"+"/table/list.do");
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addTable(Table table){
        System.out.println(table);
        tableService.register(table);
        return new ModelAndView("redirect:"+"/table/list.do");
    }

    @RequestMapping(value = "/cancel/{tableId}")
    public ModelAndView cancelReservedTable(@PathVariable("tableId") String tableId){
        tableService.cancelReservedTable(Integer.parseInt(tableId));
        return new ModelAndView("redirect:"+"/table/list.do");
    }

    @RequestMapping(value = "/reserve/{tableId}")
    public ModelAndView reserveTableView(@PathVariable("tableId") String tableId){
        Table table = tableService.getTableById(Integer.parseInt(tableId));
        ModelAndView mav = new ModelAndView();
        mav.setViewName("detail/reserveView");
        mav.addObject("table",table);
        return mav;
    }

    @RequestMapping(value = "/reserve/{tableId}/edit",method = RequestMethod.POST)
    public ModelAndView reserveTable(@PathVariable("tableId") String tableId, @RequestParam("reserveDate")Date date){
        tableService.reserveTable(Integer.parseInt(tableId),date);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:"+"/table/list.do");
        return mav;
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public ModelAndView listingTablesByName(@RequestParam("key")String key){
        List<Table> tables = tableService.getTablesByName(key);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("detail/boardList");
        mav.addObject("tableList",tables);
        return mav;
    }


}
