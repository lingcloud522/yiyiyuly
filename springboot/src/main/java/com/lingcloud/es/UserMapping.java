package com.lingcloud.es;

import org.elasticsearch.common.xcontent.XContentBuilder;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;


/**
 * Created by wushiyuan on 2018/5/11 0011.
 */
public class UserMapping {

  public static XContentBuilder getMapping(){
    XContentBuilder mapping = null;
    try{
      mapping = jsonBuilder()
              .startObject()
              //开启倒计时功能
              .startObject("_ttl")
              .field("enabled",false)
              .endObject()
              .startObject("properties")
              .startObject("title.conf")
              .field("type","string")
              .endObject()
              .startObject("question")
              .field("type","string")
              .field("index","not_analyzed")
              .endObject()
              .startObject("answer")
              .field("type","string")
              .field("index","not_analyzed")
              .endObject()
              .startObject("category")
              .field("type","string")
              .field("index","not_analyzed")
              .endObject()
              .startObject("author")
              .field("type","string")
              .field("index","not_analyzed")
              .endObject()
              .startObject("date")
              .field("type","string")
              .field("index","not_analyzed")
              .endObject()
              .startObject("answer_author")
              .field("type","string")
              .field("index","not_analyzed")
              .endObject()
              .startObject("answer_date")
              .field("type","string")
              .field("index","not_analyzed")
              .endObject()
              .startObject("description")
              .field("type","string")
              .field("index","not_analyzed")
              .endObject()
              .startObject("keywords")
              .field("type","string")
              .field("index","not_analyzed")
              .endObject()
              .startObject("read_count")
              .field("type","integer")
              .field("index","not_analyzed")
              .endObject()
              //关联数据
              .startObject("list").field("type","object").endObject()
              .endObject()
              .endObject();

    }catch(IOException e){
      e.printStackTrace();
    }
    return mapping;
  }


  public static void createBangMapping(){

   /* CreateIndexRequest request = new CreateIndexRequest("index_1");
    client.admin().indices().create(request);
    PutMappingRequest mapping = Requests.putMappingRequest("index_1").type(TYPE).source(UserMapping.getMapping());
    client.admin().indices().putMapping(mapping).actionGet();*/
  }

}
