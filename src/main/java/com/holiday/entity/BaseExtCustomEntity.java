package com.holiday.entity;

import java.util.Map;
import java.util.LinkedHashMap;

import com.baomidou.mybatisplus.annotation.TableField;
import com.diboot.core.util.JSON;
import com.diboot.core.util.V;

/**
* 自定义BaseExtEntity，增加扩展属性字段
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
* Copyright © Elvis.com
*/
public class BaseExtCustomEntity extends BaseCustomEntity {
    private static final long serialVersionUID = -9213123137157921405L;

    @TableField
    private String extdata; //JSON字符串扩展字段

    @TableField(exist = false)
    private Map<String, Object> extdataMap;

    public String getExtdata() {
        if(V.isEmpty(this.extdataMap)){
            return null;
        }
        return JSON.toJSONString(this.extdataMap);
    }

    public void setExtdata(String extdata) {
        if(V.notEmpty(extdata)){
            this.extdataMap = JSON.toLinkedHashMap(extdata);
        }
    }

    /***
    * 从extdata JSON中提取扩展属性值
    * @param extAttrName
    * @return
    */
    public Object getFromExt(String extAttrName){
        if(this.extdataMap == null){
            return null;
        }
        return this.extdataMap.get(extAttrName);
    }

    /***
    * 添加扩展属性和值到extdata JSON中
    * @param extAttrName
    * @param extAttrValue
    */
    public void addIntoExt(String extAttrName, Object extAttrValue){
        if(extAttrName == null && extAttrValue == null){
            return;
        }
        if(this.extdataMap == null){
            this.extdataMap = new LinkedHashMap<>();
        }
        this.extdataMap.put(extAttrName, extAttrValue);
    }

}