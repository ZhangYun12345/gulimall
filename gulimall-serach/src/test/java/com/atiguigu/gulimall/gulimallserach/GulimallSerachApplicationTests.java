package com.atiguigu.gulimall.gulimallserach;

import com.alibaba.fastjson.JSON;
import com.atiguigu.gulimall.gulimallserach.config.GulimallElasticSearch;
import lombok.Data;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
 public class GulimallSerachApplicationTests {



    @Autowired
    private RestHighLevelClient client ;

    @Test
    public void contextLoads() {
     System.out.println(client);
    }
    @Test
    public void indexData() throws IOException {
        IndexRequest indexRequest = new IndexRequest("users") ;
        indexRequest.id("1") ;
        User user = new User() ;
        String jsonString =  JSON.toJSONString(user) ;
        indexRequest.source(jsonString, XContentType.JSON) ;
        IndexResponse index = client.index(indexRequest,GulimallElasticSearch.COMMON_OPTIONS) ;
        System.out.println(index);
    }
    @Data
    class User
    {
        private  String userName ;
        private String gender ;
        private  Integer age ;
    }


}
