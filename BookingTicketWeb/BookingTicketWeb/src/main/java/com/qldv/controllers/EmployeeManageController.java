 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qldv.controllers;

import com.qldv.pojo.Driver;
import com.qldv.pojo.Employee;
import com.qldv.service.EmployeeService;
import com.qldv.service.RouteService;
import com.qldv.service.UserService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("admin/employees")
public class EmployeeManageController {
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private RouteService routeService;
    
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String viewEmployeeList(ModelMap mm) {
        mm.addAttribute("listEmployees", employeeService.getListNav(0, 8));
        mm.addAttribute("totalItem", employeeService.totalItem() / 8);
        return "employees";
    }

    @GetMapping("/list/{page}")
    public String viewEmployeeListByPage(ModelMap mm, @PathVariable("page") int page) {
        mm.addAttribute("listEmployees", employeeService.getListNav((page - 1) * 8, 8));
        mm.addAttribute("totalItem", employeeService.totalItem() / 8);
        return "employees";
    }

    @GetMapping("/addemployee")
    public String viewEmployeeNew(ModelMap mm) {
        mm.addAttribute("employee", new Employee());
        return "addemployee";
    }

    @GetMapping("/editemployee/{employeeId}")
    public String viewEmployeeEdit(ModelMap mm, @PathVariable("employeeId") int employeeId) {
        mm.addAttribute("employee", employeeService.findById(employeeId));
        mm.addAttribute("user", userService.getById(employeeId));
        return "updateemployee";
    }
   

    @RequestMapping("/deleteemployee/{employeeId}")
    public String viewRouteRemove(ModelMap mm, @PathVariable("employeeId") int employeeId) {
        employeeService.deleteEmployee(employeeId);
        viewEmployeeList(mm);
        return "employees";
    }

    @GetMapping("/search")
    public String search(@RequestParam Map<String, String> params, ModelMap mm) {
        if (params.get("kw").equals("")) {
            return "redirect:/admin/employees/list";
        }
        mm.addAttribute("listEmployees", employeeService.getEmployees(params, 0, 8));
        mm.addAttribute("totalItem", routeService.totalItem() / 8);
        return "employees";
    } 
}
