package com.kuka.krv.controller;

import com.kuka.krv.entity.Info;
import com.kuka.krv.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @Autowired
    private InfoService infoService;

    @GetMapping("/info/{id}")
    public Info getInfoById(@PathVariable int id) {
        System.out.println(id);
        return infoService.getInfoById(id);
    }
}
