package com.atcong.controller;

import com.atcong.Util.LayuiJson;
import com.atcong.entity.SubwayDetailsEntity;
import com.atcong.entity.SubwayInfoEntity;
import com.atcong.entity.SubwayRouteEntity;
import com.atcong.entity.SubwayStationEntity;
import com.atcong.service.SubwayDetailsService;
import com.atcong.service.SubwayRouteService;
import com.atcong.service.SubwayService;
import com.atcong.service.SubwayStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SubwayCon {

    @Autowired
    private SubwayService subwayService;
    @Autowired
    private SubwayDetailsService subwayDetailsService;
    @Autowired
    private SubwayRouteService subwayRouteService;
    @Autowired
    private SubwayStationService subwayStationService;

    //跳转车次管理页面
    @RequestMapping("/subwayInfo")
    public String subwayInfo(){
        return "subway/findAllSubway";
    }

    @RequestMapping("/subwayStation")
    public String subwayStation(){
        return "subway/findAllSubwayStation";
    }

    //跳转添加界面
    @RequestMapping("/subwayAdd")
    public String subwayAdd(){
        return "subway/subwayAdd";
    }

    //显示全部地铁信息
    @RequestMapping("/subwayJson")
    @ResponseBody
    public LayuiJson subwayJson(){
        LayuiJson layuiJson = new LayuiJson();
        Integer count = subwayService.findAll().size();
        layuiJson.data(count,subwayService.findAll());
        return layuiJson;
    }

    //显示车站全部信息
    @RequestMapping("/subwayStationJson")
    @ResponseBody
    public LayuiJson stationJson(){
        LayuiJson layuiJson = new LayuiJson();
        Integer count = subwayStationService.findAllSubwayStation().size();
        layuiJson.data(count,subwayStationService.findAllSubwayStation());
        return layuiJson;
    }

    //显示路线详细信息
    @RequestMapping("/subway/SubwayRouteDetails")
    public String subwayRouteDetails(@RequestParam("routeName")String routeName,Model model){
        int route_id = subwayRouteService.findSubwayRoute(routeName).getRouteId();
        List<SubwayStationEntity>subwayStation = subwayStationService.findAllSubwayStation(route_id);
        model.addAttribute("subway",subwayStation);
        return "subway/SubwayStationDetails";
    }

    //添加地铁
    @RequestMapping("/addSubway")
    public void addSubway(@RequestParam("subwayId")Integer subwayId,
                          @RequestParam("subwayName")String subwayName,
                          @RequestParam("subwayRoute")Integer subwayRoute){
        if(subwayService.findSubway(subwayId) != null){
            return;
        }
        subwayService.addSubway(subwayName,subwayRoute,subwayId);
    }

    //根据地铁名查询地铁
    @RequestMapping("/subwaySelectJson")
    @ResponseBody
    public LayuiJson subwaySelectJson(@RequestParam("subwayName")String subwayName){
        LayuiJson layuiJson = new LayuiJson();
        if(subwayName.equals("")){
            return this.subwayJson();
        }
        if(subwayService.findAll(subwayName) == null){
            return layuiJson;
        }
        layuiJson.data(subwayService.findAll(subwayName).size(),subwayService.findAll(subwayName));
        return layuiJson;
    }

    @RequestMapping("/subwayStationSelectJson")
    @ResponseBody
    public LayuiJson subwayStationSelect(@RequestParam("stationName")String stationName){
        LayuiJson layuiJson = new LayuiJson();
        if(stationName.equals("")){
            return this.stationJson();
        }
        layuiJson.data(subwayStationService.findAllSubwayStation(stationName).size(),subwayStationService.findAllSubwayStation(stationName));
        return layuiJson;
    }

    @RequestMapping("/subway/SubwayModify")
    public String subwayModify(@RequestParam("subwayName")String subwayName,Model model){
        model.addAttribute("subway",subwayService.findSubway(subwayName));
        return "/subway/SubwayEdit";
    }

    @RequestMapping("/subwayId")
    @ResponseBody
    public List<String> getRoute(){
        List<String>strings = new ArrayList<>();
        List<SubwayRouteEntity>subway = subwayRouteService.findAllSubwayRoute();
        for(int i = 0 ; i < subway.size() ; i++){
            strings.add(subway.get(i).getRouteName());
        }
        return strings;
    }

    @RequestMapping("/routeInfoName")
    @ResponseBody
    public String routeInfoName(@RequestParam("routeId")Integer routeId){
        return subwayRouteService.findSubwayRoute(routeId).getRouteName();
    }

    @RequestMapping("/StationAdd")
    public String addStation(){
        return "/subway/StationAdd";
    }

    @RequestMapping("/getSubwayStationId")
    @ResponseBody
    public Integer getStationId(){
        Integer count = subwayStationService.findAllSubwayStation().size();
        return subwayStationService.findAllSubwayStation().get(count - 1).getStationId();
    }

    @RequestMapping("/addSubwayStation")
    public void addSubwayStation(@RequestParam("subwayStationId")Integer stationId,
                                 @RequestParam("StationName")String stationName,
                                 @RequestParam("subwayRoute")Integer route){
        if(subwayStationService.findSubwayStation(stationId) != null){
            return;
        }
        subwayStationService.addSubwayStation(stationId,stationName,route);
    }

    @RequestMapping("/stationEdit")
    public void stationEdit(@RequestParam("stationName")String stationName,
                            @RequestParam("stationId")Integer stationId){
        SubwayStationEntity subwayStationEntity = subwayStationService.findSubwayStation(stationId);
        subwayStationEntity.setStationName(stationName);
        subwayStationService.modifySubwayStation(subwayStationEntity);
    }

    @RequestMapping("/editSubway")
    public void modifySubway(@RequestParam("subwayName")String subwayName,
                             @RequestParam("subwayRoute")Integer subwayRoute){
        subwayService.modifySubway(subwayName,subwayRoute);
    }



    //获取地铁Id
    @RequestMapping("/getSubwayId")
    @ResponseBody
    public Integer getSubwayId(){
        Integer count = subwayService.findall().get(subwayService.findall().size() - 1).getSubwayId();
        return count;
    }

    //获取全部路线供选择
    @RequestMapping("/subwayRouteId")
    @ResponseBody
    public List<String> subwayRouteId(){
        List<String>subway = new ArrayList<>();
        List<SubwayRouteEntity>subwayRouteEntities = subwayRouteService.findAllSubwayRoute();
        for(int i = 0 ; i < subwayRouteEntities.size() ; i++){
            subway.add(subwayRouteEntities.get(i).getRouteName());
        }
        return subway;
    }

    //删除地铁
    @RequestMapping("/subwayDelete")
    @ResponseBody
    public Map<String,String> subwayDelete(@RequestParam("subwayId")Integer subwayId){
        Map<String,String>map = new HashMap<>();
        subwayService.removeSubway(subwayId);
        map.put("state","success");
        return map;
    }

    //获取地铁详细信息
    @RequestMapping("/subway/SubwayDetails")
    public String subwayDetails(HttpServletRequest request, Model model){
        String route_name = request.getParameter("subwayName");
        SubwayInfoEntity subwayInfoEntity = subwayService.findSubway(route_name);
        int i = subwayInfoEntity.getSubwayId();
        SubwayDetailsEntity subwayDetailsEntity = subwayDetailsService.findSubwayDetails(i);
        model.addAttribute("subway",subwayInfoEntity);
        model.addAttribute("subwayDetail",subwayDetailsEntity);
        return "subway/subwayDetails";
    }

    //修改地铁详细信息
    @RequestMapping("/modifySubwayDetails")
    public void modifySubwayDetails(@RequestParam("start")String data_start,
                                    @RequestParam("end")String data_end,
                                    HttpServletRequest request){
        String subwayId = request.getParameter("subway_id");
        Integer subway_id = Integer.parseInt(subwayId);
        System.out.println(subway_id);
        if(subwayDetailsService.findSubwayDetails(subway_id) != null) {
            SubwayDetailsEntity subwayDetailsEntity = subwayDetailsService.findSubwayDetails(subway_id);
            subwayDetailsEntity.setSubwayBeginTime(data_start);
            subwayDetailsEntity.setSubwayEndTime(data_end);
            subwayDetailsService.modifySubwayDetails(subwayDetailsEntity);
        }else {
            subwayDetailsService.addSubwayDetails(subway_id,subwayService.findSubway(subway_id).getSubwayRoute(),data_start,data_end);
        }
    }

    //删除站点信息
    @RequestMapping("/subwayStationDelete")
    @ResponseBody
    public Map<String,String> deleteStation(@RequestParam("stationId")Integer stationId){
        Map<String,String>map = new HashMap<>();
        subwayStationService.removeSubwayStation(stationId);
        map.put("state","success");
        return map;
    }


}
