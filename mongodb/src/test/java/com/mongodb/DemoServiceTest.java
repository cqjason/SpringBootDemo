package com.mongodb;

import com.mongodb.domain.DemoInfo;
import com.mongodb.server.demoServer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Jason on 2018/1/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoServiceTest {

    @Autowired
    private demoServer demoServer;

    @Test
    public void findOneTest(){
        DemoInfo demoInfo = demoServer.findOne("11");
        Assert.assertEquals(18,demoInfo.getAge());
    }

}
