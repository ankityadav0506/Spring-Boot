package com.empmgmt.controller;

import com.empmgmt.entity.Employee;
import com.empmgmt.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String index(Model m){
        List<Employee> list = employeeService.getAllEmp();
        m.addAttribute("emp", list);
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employee emp, RedirectAttributes redirectAttributes){
        Employee savedEmp = employeeService.saveEmp(emp);
        if(savedEmp != null){
            redirectAttributes.addFlashAttribute("msg", "Employee Registered!");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Server Error!");
        }
        return "redirect:/save";
    }

    @GetMapping("/save")
    public String show(){
        return "save";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m){
        Employee emp = employeeService.getEmpById(id);
        m.addAttribute("emp", emp);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Employee emp, RedirectAttributes redirectAttributes){
        Employee updatedEmp = employeeService.saveEmp(emp);
        if(updatedEmp != null){
            redirectAttributes.addFlashAttribute("msg", "Employee Update Successfully!");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Server Error!");
        }
        return "redirect:/";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes){
        boolean result = employeeService.deleteEmp(id);
        if(result){
            redirectAttributes.addFlashAttribute("msg", "Employee Deleted Successfully!");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Server Error!");
        }
        return "redirect:/";
    }
}
