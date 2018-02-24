package com.mongodb.controller;

import com.mongodb.domain.DemoInfo;
import com.mongodb.domain.Result;
import com.mongodb.repository.DemoInfoRepository;
import com.mongodb.server.demoServer;
import com.mongodb.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.SimpleTimeZone;

/**
 * Created by Jason on 2018/1/16.
 */
@RestController
public class DemoController {

    @Autowired
    private DemoInfoRepository demoInfoRepository;

    @Autowired
    private demoServer demoserver;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(){

        return "Hello!!";
    }

    /**
     * add a demoInfo
     * @param name
     * @param age
     * @return
     */
    @PostMapping("save")
    public DemoInfo save(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("age") int age){
        return demoserver.insert(id,name,age);
    }

    @PostMapping("resave")
    public Result<DemoInfo> resave(@Valid DemoInfo demoInfo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
            return null;
        }

        return ResultUtil.success(demoserver.insert(demoInfo));
    }

    @GetMapping("find")
    public List<DemoInfo> findAll(){
        System.out.println("before return");
        return demoInfoRepository.findAll();
    }

    @GetMapping("findOne")
    public  DemoInfo findOne(@RequestParam("id") String id){
        return demoInfoRepository.findOne(id);
    }

    @GetMapping("findByName/{name}")
    public DemoInfo findByName(@PathVariable("name") String name) {

        return demoInfoRepository.findByName(name);
    }

    @PutMapping("put")
    public DemoInfo put(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("age") int age){
        return demoserver.insert(id,name,age);
    }

    @DeleteMapping("delet/{id}")
    public  void delet(@PathVariable("id") String  id){
        demoInfoRepository.delete(id);
    }

    @PostMapping("two")
    public List<DemoInfo> insertTwo(){
        return demoserver.insertTwo();
    }

    @GetMapping("getAge/{id}")
    public void getAge(@PathVariable("id") String id) throws Exception{
        demoserver.getAge(id);
    }
 }
