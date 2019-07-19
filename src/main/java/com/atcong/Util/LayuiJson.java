package com.atcong.Util;

import com.atcong.entity.BusStationEntity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class LayuiJson extends LinkedHashMap<String,Object> {
    public LayuiJson data(Integer count, List<?> data){
        this.put("code",0);
        this.put("msg","");
        this.put("count",count);
        this.put("data",data);
        return this;
    }

    public List<?> data(Integer page,Integer limit,Integer count,List<BusStationEntity>list){
        List<BusStationEntity>o = new ArrayList();
        if(page * limit > count){
            for(int i = (page - 1) * limit ; i < count ; i++){
                o.add(list.get(i));
            }
        }else {
            for (int i = (page - 1) * limit; i < limit * page; i++) {
                o.add(list.get(i));
            }
        }
        return o;
    }
}
