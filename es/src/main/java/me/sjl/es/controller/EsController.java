package me.sjl.es.controller;

import me.sjl.es.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EsController {

    @Autowired
    private EsService esService;

    @GetMapping("/initEs")
    public String initEs() {
        esService.init();
        return "init success";
    }

    @GetMapping("createIndexByString")
    public String createIndexByString() {
        esService.createIndexByString();
        return "create string index success";
    }

    @GetMapping("/getIndex")
    public String getIndex() {
        esService.getIndex();
        return "get Request Index";
    }

    @GetMapping("/delIndex")
    public String delIndex() {
        esService.delIndex();
        return "del index";
    }
}
