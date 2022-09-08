package com.github.lorellw.socialNetworkRest.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("message")
public class MessageController {

    @GetMapping
    public String readAll(){
        return "readAll";
    }

    @GetMapping("{id}")
    public String readById(@PathVariable String id){
        return "readById " + id;
    }

    @PostMapping
    public String create(@RequestBody Map<String,String> message){
        return "create " + message;
    }

    @PutMapping("{id}")
    public String update(@PathVariable String id, @RequestParam String message){
        System.out.println("update " + id + " " + message);
        return "update " + id + " " + message;
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable String id){
        System.out.println("delete " + id);
        return "delete " + id;
    }
}
