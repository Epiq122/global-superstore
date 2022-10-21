package com.ltp.globalsuperstore.web;


import com.ltp.globalsuperstore.Constants;
import com.ltp.globalsuperstore.domain.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SuperstoreController {

    List<Item> items = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model) {
//        Create an Item object and bind it to the form.
        model.addAttribute("item", new Item());

        model.addAttribute("categories", Constants.CATEGORIES);
        return "form";
    }

    @GetMapping("/inventory")
    public String getInventory() {
        return "inventory";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(Item item) {
        items.add(item);
        return "redirect:/inventory";
    }
}
