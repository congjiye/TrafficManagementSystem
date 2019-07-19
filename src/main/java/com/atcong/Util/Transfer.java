package com.atcong.Util;

import com.atcong.entity.BusRouteEntity;
import com.atcong.entity.BusStationEntity;
import com.atcong.entity.SubwayStationEntity;

import java.util.*;

public class Transfer {



    public List<Integer> compare(Set<Integer>start,Set<Integer>end){
        List<Integer>list = new ArrayList<>();
        for(Iterator iterator = start.iterator();iterator.hasNext();){
            Integer ite = (Integer) iterator.next();
            for(Iterator iterator1 = end.iterator();iterator1.hasNext();){
                Integer ite1 = (Integer) iterator1.next();
                if(ite == ite1){
                    list.add(ite);
                }
            }
        }
        return list;
    }

    public List<Integer> getRoute(Set<Integer>start){
        List<Integer>list = new ArrayList<>();
        for(Iterator iterator = start.iterator();iterator.hasNext();){
            Integer ite = (Integer) iterator.next();
            list.add(ite);
        }
        return list;
    }

    public Set<Integer> setRoute(List<BusStationEntity>list){
        Set<Integer>set = new TreeSet<>();
        for(int i = 0 ; i < list.size() ; i++){
            set.add(list.get(i).getRouteId());
        }
        return set;
    }

    public Set<Integer>setRouteSubway(List<SubwayStationEntity>list){
        Set<Integer>set = new TreeSet<>();
        for(int i = 0 ; i < list.size() ; i++){
            set.add(list.get(i).getRouteId());
        }
        return set;
    }

    public Map<String,String> findRoute(List<BusStationEntity>list){
        Map<String,String>map = new HashMap<>();
        if(list.size() >= 2){
            map.put("mid",list.get(0).getStationName());
        }
        return map;
    }

}
