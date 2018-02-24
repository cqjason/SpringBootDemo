package com.mongodb.repository;

import com.mongodb.domain.DemoInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Jason on 2018/1/16.
 */
public interface DemoInfoRepository extends MongoRepository<DemoInfo,String> {

    public DemoInfo findByName(String Name);

    public List<DemoInfo> findByAge(int age);

}
