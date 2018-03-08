package com.js.controller;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jason on 2018/3/8.
 */
@RestController
public class Controller {
    @Autowired
    private TransportClient client;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/get/bank/doc")
    @ResponseBody //it can be threw away
    public ResponseEntity get(@RequestParam(name = "id",defaultValue = "") String id){
        if(id.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        GetResponse result = this.client.prepareGet("bank","doc",id).get();

        if(!result.isExists())
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(result.getSource(), HttpStatus.OK);
    }
}
