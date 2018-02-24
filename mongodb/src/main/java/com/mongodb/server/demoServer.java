package com.mongodb.server;

import com.mongodb.domain.DemoInfo;
import com.mongodb.enums.ResultEnum;
import com.mongodb.exception.DemoException;
import com.mongodb.repository.DemoInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 2018/1/24.
 */

@Service
public class demoServer {
    @Autowired
    private DemoInfoRepository demoInfoRepository;

    @Transactional
    public List<DemoInfo> insertTwo(){
        DemoInfo demoInfo1 = new DemoInfo();

        demoInfo1.setId("7");
        demoInfo1.setName("bob");
        demoInfo1.setAge(18);

        demoInfoRepository.save(demoInfo1);

        DemoInfo demoInfo2 = new DemoInfo();

        demoInfo2.setId("8");
        demoInfo2.setName("Bob");
        demoInfo2.setAge(18);

        demoInfoRepository.save(demoInfo2);

        List <DemoInfo> demoInfoList = new ArrayList<DemoInfo>();
        demoInfoList.add(demoInfo1);
        demoInfoList.add(demoInfo2);

        return demoInfoList;
    }

    public DemoInfo insert(String id,String name,int age){
        DemoInfo demoInfo = new DemoInfo();

        demoInfo.setId(id);
        demoInfo.setName(name);
        demoInfo.setAge(age);

        demoInfoRepository.save(demoInfo);

        return demoInfo;
    }

    public DemoInfo insert(DemoInfo demoInfoParam){
        DemoInfo demoInfo = new DemoInfo();

        demoInfo.setId(demoInfoParam.getId());
        demoInfo.setName(demoInfoParam.getName());
        demoInfo.setAge(demoInfoParam.getAge());

        demoInfoRepository.save(demoInfo);

        return demoInfo;
    }

    public void getAge(String id) throws Exception{
        DemoInfo demoInfo = demoInfoRepository.findOne(id);
        int age = demoInfo.getAge();
        if(age < 18){
            throw new DemoException(ResultEnum.BOY);
        }else {
            throw new DemoException(ResultEnum.MAN);
        }

    }

    public DemoInfo findOne(String id){
        return demoInfoRepository.findOne(id);
    }
}
