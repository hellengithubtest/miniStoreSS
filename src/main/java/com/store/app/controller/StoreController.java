package com.store.app.controller;

import com.store.app.entity.Product;
import com.store.app.service.StoreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StoreController {
    private StoreService service;

    public StoreController(StoreService service) {
        this.service = service;
    }

    @GetMapping(value = {"/products"})
    public ModelAndView listOfProducts(@RequestParam(value = "filter", required = false) String filter,
                                       @PageableDefault(size = 15) Pageable pageable,
                                       ModelMap modelMap){
        Page<Product> pages;
        if(filter != null && !filter.isEmpty()){
            pages = service.search(filter, pageable);
        } else {
            pages = service.findAll(pageable);
        }
        modelMap.addAttribute("filter", filter);
        modelMap.addAttribute("list", pages.getContent());
        modelMap.addAttribute("size", pages.getSize());
        modelMap.addAttribute("number", pageable.getPageNumber());
        modelMap.addAttribute("totalPages", pages.getTotalPages());

        return new ModelAndView("listOfProducts", modelMap);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String productInformation(@PathVariable(value = "id") int id, Model model) {
        try {
            model.addAttribute("product", service.findById(id));
            return "productInformation";
        } catch (RuntimeException e) {
            return "redirect:/products";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        service.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("product", service.findById(id));
        return "edit";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("cost") int cost){
        Product product = new Product(id, name, cost);
        service.update(product);
        return "redirect:/products";
    }

    @GetMapping("product/new")
    public String add(){
        return "add";
    }

    @PostMapping("product/new")
    public String newProduct(@RequestParam("name") String name, @RequestParam("cost") int cost) {
        Product newproductBean = new Product();
        newproductBean.setName(name);
        newproductBean.setCost(cost);
        service.save(newproductBean);
        return "redirect:/products";
    }

}
