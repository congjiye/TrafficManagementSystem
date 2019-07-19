package com.atcong.controller;

import com.atcong.Util.LayuiJson;
import com.atcong.entity.TrainDetailsEntity;
import com.atcong.entity.TrainInfoEntity;
import com.atcong.entity.TrainRouteEntity;
import com.atcong.service.TrainDetailsService;
import com.atcong.service.TrainRouteService;
import com.atcong.service.TrainService;
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
public class TrainCon {

    @Autowired
    private TrainService trainService;
    @Autowired
    private TrainRouteService trainRouteService;
    @Autowired
    private TrainDetailsService trainDetailsService;

    @RequestMapping("/trainInfo")
    public String trainInfo(){
        return "Train/findAllTrain";
    }

    @RequestMapping("/trainJson")
    @ResponseBody
    public LayuiJson trainJson(){
        LayuiJson layuiJson = new LayuiJson();
        Integer count = trainService.findAllTrainInfo().size();
        layuiJson.data(count,trainService.findAllTrainInfo());
        return layuiJson;
    }

    @RequestMapping("/trainStation")
    public String trainStation(){
        return "Train/findAllTrainStation";
    }

    @RequestMapping("/trainSelectJson")
    @ResponseBody
    public LayuiJson trainSelectJson(@RequestParam("trainName")String trainName){
        if(trainName.equals("")){
            return this.trainJson();
        }
        LayuiJson layuiJson = new LayuiJson();
        Integer count = trainService.findAllTrainInfo(trainName).size();
        layuiJson.data(count,trainService.findAllTrainInfo(trainName));
        return layuiJson;
    }

    @RequestMapping("/trainDelete")
    @ResponseBody
    public Map<String,String> trainDelete(@RequestParam("trainId")Integer trainId,
                                          @RequestParam("trainName")String trainName){
        Map<String,String>map = new HashMap<>();
        trainService.removeTrain(trainId);
        map.put("state","success");
        return map;
    }

    @RequestMapping("/trainModify")
    public String modifyTrain(@RequestParam("trainName")String trainName, Model model){
        model.addAttribute("train",trainService.findTrain(trainName));
        return "/Train/trainModify";
    }

    @RequestMapping("/modifyTrain")
    public void TrainModify(@RequestParam("trainName")String trainName,
                            @RequestParam("trainRoute")Integer trainRoute){
        TrainInfoEntity trainInfoEntity = trainService.findTrain(trainName);
        trainInfoEntity.setTrainRoute(trainRoute);
        trainService.modifyTrain(trainInfoEntity);
    }

    @RequestMapping("/trainStationJson")
    @ResponseBody
    public LayuiJson trainStationJsonInfo(){
        LayuiJson layuiJson = new LayuiJson();
        Integer count = trainRouteService.findAllTrainRoute().size();
        layuiJson.data(count,trainRouteService.findAllTrainRoute());
        return layuiJson;
    }

    @RequestMapping("/trainStationSelect")
    @ResponseBody
    public LayuiJson trainStationSelect(@RequestParam("routeName")String routeName){
        LayuiJson layuiJson = new LayuiJson();
        if(routeName.equals("")){
            return this.trainStationJsonInfo();
        }
        List<TrainRouteEntity> list = new ArrayList<>();
        list.add(trainRouteService.findTrainRoute(routeName));
        layuiJson.data(1,list);
        return layuiJson;
    }

    @RequestMapping("/trainStationEdit")
    @ResponseBody
    public void trainStationEdit(@RequestParam("routeId")Integer routeId,
                                 @RequestParam("routeName")String routeName){
        TrainRouteEntity trainRouteEntity = trainRouteService.findTrainRoute(routeId);
        trainRouteEntity.setRouteName(routeName);
        trainRouteService.modifyTrainRoute(trainRouteEntity);
    }

    @RequestMapping("/trainStationDelete")
    public Map<String,String> trainStationDelete(@RequestParam("routeId")Integer routeId,
                                                 @RequestParam("routeName")String routeName){
        Map<String,String>map = new HashMap<>();
        trainRouteService.removeTrainRoute(routeId);
        map.put("state","success");
        return map;
    }

    @RequestMapping("/trainStationAdd")
    public String addTrainStation(){
        return "Train/trainStationAdd";
    }

    @RequestMapping("/getTrainStationId")
    @ResponseBody
    public Integer getTrainStationId(){
        Integer count = trainRouteService.findAllTrainRoute().get(trainRouteService.findAllTrainRoute().size() - 1).getRouteId();
        return count;
    }

    @RequestMapping("/trainDetails")
    public String trainDetailsShow(@RequestParam("trainId")Integer trainId,Model model){
        model.addAttribute("trainDetail",trainDetailsService.findTrainDetail(trainId));
        model.addAttribute("train",trainService.findTrain(trainId));
        return "Train/trainDetail";
    }

    @RequestMapping("/addTrainStation")
    public void addTrainStation(@RequestParam("routeId")Integer routeId,
                                @RequestParam("routeName")String routeName){
        trainRouteService.addTrainRoute(routeId,routeName);
    }

    @RequestMapping("/modifyTrainDetails")
    public void modifyTrainDetails(@RequestParam("train_id")Integer trainId,
                                    @RequestParam("start")String start,
                                    @RequestParam("end")String end){
        if(trainDetailsService.findTrainDetail(trainId) != null){
            TrainDetailsEntity trainDetailsEntity = trainDetailsService.findTrainDetail(trainId);
            trainDetailsEntity.setTrainBeginTime(start);
            trainDetailsEntity.setTrainEndTime(end);
            trainDetailsService.modifyTrainDetails(trainDetailsEntity);
        }else {
            TrainDetailsEntity trainDetailsEntity = new TrainDetailsEntity();
            trainDetailsService.addTrainDetails(trainId,start,end);
        }
    }

    @RequestMapping("/trainId")
    @ResponseBody
    public List<String> trainRouteId(){
        List<String>strings = new ArrayList<>();
        List<TrainRouteEntity>route = trainRouteService.findAllTrainRoute();
        for(int i = 0 ; i < route.size() ; i++){
            strings.add(route.get(i).getRouteName());
        }
        return strings;
    }

    @RequestMapping("/addTrain")
    public void addTrain(@RequestParam("trainName")String trainName,
                         @RequestParam("trainRoute")Integer trainRoute){
        if(trainService.findTrain(trainName) != null){
            return;
        }
        trainService.addTrain(trainName,trainRoute);
    }

    @RequestMapping("/trainAdd")
    public String trainAdd(){
        return "Train/TrainAdd";
    }


}
