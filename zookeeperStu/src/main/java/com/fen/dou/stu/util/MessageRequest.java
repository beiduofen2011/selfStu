package com.fen.dou.stu.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 落叶 on 2019/10/27.
 */
public class MessageRequest implements java.io.Serializable{

  private static final long serialVersionUID = -4685871752240575206L;

  private String transID = UUID.randomUUID().toString().replaceAll("-","");

  private String path;

  private String data;

  private String topic;

  private String userId = "";

  private String projectId;

  private String roleId;

  private Map<String,Object> params = new HashMap<>();

  public MessageRequest() {
  }

  public MessageRequest(String path, String data) {
    this.path = path;
    this.data = data;
  }

  public String getJSON(){
    //TODO 暂时用json后期换kryo
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("transID",transID);
    jsonObject.put("path",path);
    jsonObject.put("data",data);
    jsonObject.put("topic",topic);
    jsonObject.put("params",params);
    jsonObject.put("userId",userId);
    return jsonObject.toJSONString();
  }

  public String getTransID() {
    return transID;
  }

  public void setTransID(String transID) {
    this.transID = transID;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getData() {
    return data;
  }

  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public void setParams(Map<String, Object> params) {
    this.params = params;
  }


}
