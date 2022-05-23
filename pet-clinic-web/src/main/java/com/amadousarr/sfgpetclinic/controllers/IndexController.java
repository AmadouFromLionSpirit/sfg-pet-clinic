package com.amadousarr.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    /*What is below means 1st Paramete: is when athere is a equest that comes in to the root context, or root slash or index or index.html,
    * they are all going to match to this RequestMapping*/
    @RequestMapping({"","/","index","index.html"})
    public String index() {
        return "index";
    }
}
