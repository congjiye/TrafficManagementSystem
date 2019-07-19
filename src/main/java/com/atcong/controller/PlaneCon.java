package com.atcong.controller;

import com.atcong.Util.LayuiJson;
import com.atcong.Util.PlaneFindJson;
import com.atcong.entity.PlaneDetailsEntity;
import com.atcong.entity.PlaneInfoEntity;
import com.atcong.service.PlaneDetailsService;
import com.atcong.service.PlaneRouteService;
import com.atcong.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PlaneCon {

    @Autowired
    private PlaneService planeService;
    @Autowired
    private PlaneRouteService planeRouteService;
    @Autowired
    private PlaneDetailsService planeDetailsService;

    @RequestMapping("/planeInfo")
    public String planeInfo(){
        return "Plane/findAllPlane";
    }

    @RequestMapping("/planeJson")
    @ResponseBody
    public LayuiJson planeJson(){
        LayuiJson layuiJson = new LayuiJson();
        Integer count = planeService.findAll().size();
        layuiJson.data(count,planeService.findAll());
        return layuiJson;
    }

    @RequestMapping("/planeAdd")
    public String planeAdd(){
        return "Plane/planeAdd";
    }

    @RequestMapping("/getPlaneId")
    @ResponseBody
    public Integer getPlaneId(){
        Integer count = planeService.findall().get(planeService.findall().size() - 1).getPlaneId();
        return count;
    }

    @RequestMapping("/modifyPlaneDetails")
    public void modifyPlaneDetails(@RequestParam("start")String start,
                                   @RequestParam("end")String end,
                                   @RequestParam("plane_id")Integer planeId){
        PlaneDetailsEntity planeDetailsEntity = new PlaneDetailsEntity();
        if(planeDetailsService.findPlaneDetails(planeId) != null){
            planeDetailsEntity = planeDetailsService.findPlaneDetails(planeId);
            planeDetailsEntity.setPlaneBeginTime(start);
            planeDetailsEntity.setPlaneEndTime(end);
            planeDetailsService.modifyPlaneDetails(planeDetailsEntity);
        }else {
            planeDetailsService.addPlaneDetails(planeId,start,end);
        }
    }

    @RequestMapping("/planeDetails")
    public String planeDetails(@RequestParam("planeName")String planeName,Model model){
        Integer count = planeService.findPlane(planeName).getPlaneId();
        model.addAttribute("plane",planeService.findPlane(planeName));
        model.addAttribute("planeDet",planeDetailsService.findPlaneDetails(count));
        return "Plane/planeDetails";
    }

    @RequestMapping("/planeDelete")
    public Map<String,String> planeDelete(@RequestParam("planeName")String planeName,
                                          @RequestParam("routeName")String routeName){
        Map<String,String>map = new HashMap<>();
        planeService.removePlane(planeName);
        map.put("state","success");
        return map;
    }

    @RequestMapping("/planeSelectJson")
    @ResponseBody
    public LayuiJson planeSelectJson(@RequestParam("planeName")String planeName){
        if(planeName.equals("")){
            return this.planeJson();
        }
        LayuiJson layuiJson = new LayuiJson();
        Integer count = planeService.findAll(planeName).size();
        layuiJson.data(count,planeService.findAll(planeName));
        return layuiJson;
    }

    @RequestMapping("/addPlane")
    public void addPlane(@RequestParam("planeId")Integer planeId,
                         @RequestParam("planeName")String planeName,
                         @RequestParam("routeName")String routeName){
        Integer routeId = null;
        if(planeRouteService.findPlaneRoute(routeName) == null){
            planeRouteService.addPlaneRoute(routeName);
        }
        routeId = planeRouteService.findPlaneRoute(routeName).getRouteId();
        planeService.addPlane(planeId,planeName,routeId);
    }

    @RequestMapping("/planeRouteId")
    @ResponseBody
    public List<String> planeRouteName(){
        List<String>strings = new ArrayList<>();
        for(int i = 0 ; i < planeRouteService.findAllPlaneRoute().size() ; i++){
            strings.add(planeRouteService.findAllPlaneRoute().get(i).getRouteName());
        }
        return strings;
    }

    @RequestMapping("/editPlane")
    public void editPlane(@RequestParam("planeName")String planeName,
                          @RequestParam("planeRoute")Integer planeRoute){
        PlaneInfoEntity planeInfoEntity = planeService.findPlane(planeName);
        planeInfoEntity.setPlaneRoute(planeRouteService.findPlaneRoute(planeRoute).getRouteId());
        planeService.modifyPlane(planeInfoEntity);
    }

    @RequestMapping("/planeModify")
    public String planeModify(@RequestParam("planeName")String planeName, Model model){
        model.addAttribute("plane",planeService.findPlane(planeName));
        return "Plane/planeModify";
    }
}
