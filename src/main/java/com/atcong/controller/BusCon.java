package com.atcong.controller;

import antlr.collections.impl.LList;
import com.atcong.Util.BusFindJson;
import com.atcong.Util.LayuiJson;
import com.atcong.entity.BusDetailsEntity;
import com.atcong.entity.BusInfoEntity;
import com.atcong.entity.BusRouteEntity;
import com.atcong.entity.BusStationEntity;
import com.atcong.service.BusDetailsService;
import com.atcong.service.BusRouteService;
import com.atcong.service.BusService;
import com.atcong.service.BusStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class BusCon {

    private boolean removeBusSuccessOrFailed = false;
    private boolean busAddResult = false;

    @Autowired
    private BusService busService;
    @Autowired
    private BusDetailsService busDetailsService;
    @Autowired
    private BusRouteService busRouteService;
    @Autowired
    private BusStationService busStationService;


    //跳转页面
    //跳转添加公交
    @RequestMapping("/busAdd")
    public String moveAdd(){
        return "Bus/busAdd";
    }

    //跳转查询所有路线信息
    @RequestMapping("/busRoute")
    public String busRoute(){
        return "Bus/findAllBusRoute";
    }

    //跳转查询所有公交信息
    @RequestMapping("/busInfo")
    public String busInfo(){
        return "Bus/findAllBus";
    }

    //跳转添加路线信息
    @RequestMapping("/routeAdd")
    public String moveRouteAdd(){
        return "Bus/routeAdd";
    }

    @RequestMapping("/stationAdd")
    public String moveStationAdd(){
        return "Bus/stationAdd";
    }

    //跳转公交信息修改界面
    @RequestMapping("/busModify")
    public String busModify(@RequestParam("bus_name")String bus_name,Model model){
        model.addAttribute("bus",busService.findBus(bus_name).getBusName());
        return "Bus/busModify";
    }

    //跳转查询所有公交站点信息
    @RequestMapping("/busStation")
    public String busStation(){
        return "Bus/findAllBusStation";
    }

    //跳转点击事件
    //跳转点击显示公交详细信息
    @RequestMapping("/Bus/BusDetails")
    public String moveBusDetails(HttpServletRequest request,Model model){
        String bus_name = request.getParameter("bus_name");
        BusInfoEntity busInfoEntity = busService.findBus(bus_name);
        int bus_id = busInfoEntity.getBusId();
        BusDetailsEntity busDetailsEntity = busDetailsService.findBusDetails(bus_id);
        model.addAttribute("busDetails",busDetailsEntity);
        model.addAttribute("busInfo",busInfoEntity);
        return "Bus/BusDetails";
    }

    //跳转点击显示路线中的站点
    @RequestMapping("/Bus/RouteDetails")
    public String RouteDetails(HttpServletRequest request,Model model){
        String route_name = request.getParameter("route_name");
        int i = busRouteService.findBusRoute(route_name).getRouteId();
        model.addAttribute("routeList",busStationService.findAllBusStation(i));
        return "Bus/BusRoute";
    }

    //点击显示站点中的路线
    @RequestMapping("/stationDetail")
    @ResponseBody
    public String stationDetails(@RequestParam("routeId")Integer routeId){
        return busRouteService.findBusRoute(routeId).getRouteName();
    }

    //添加
    //添加公交信息
    @RequestMapping("/add")
    @ResponseBody
    public String save(@RequestParam("busName")String name,
                       @RequestParam("route")int route){
        if(busService.findBus(name) != null){
            return "false";
        }else {
            busService.addBus(name,route);
            return "true";
        }
    }

    //添加路线信息
    @RequestMapping("/addRoute")
    @ResponseBody
    public String saveRoute(@RequestParam("routeId")Integer routeId,
                          @RequestParam("routeName")String routeName){
        if(busRouteService.findBusRoute(routeId) == null && !routeName.equals("")){
            busRouteService.addBusRoute(routeId,routeName);
            return "true";
        }
        return "false";
    }

    //添加站点信息
    @RequestMapping("/addStation")
    @ResponseBody
    public String saveStation(@RequestParam("stationId")Integer stationId,
                            @RequestParam("stationName")String stationName,
                            @RequestParam("route")Integer routeId,
                            @RequestParam("stationPosition")String position){
        if(busStationService.findBusStation(position,routeId) != null){
            Integer count = busStationService.findAllBusStation(routeId).size();
            for(Integer i = count ; i >= Integer.parseInt(position) ; i--){
                BusStationEntity busStationEntity = busStationService.findBusStation(i.toString(),routeId);
                Integer change = i + 1;
                busStationEntity.setBusPostison(change.toString());
                System.out.println(busStationEntity.getBusPostison());
            }
            busStationService.addBusStation(routeId,stationName,stationId,position);
            return "true";
        }else {
            busStationService.addBusStation(routeId,stationName,stationId,position);
            return "true";
        }
    }

    //表格数据显示
    //显示所有公交信息并返回json格式数据
    @RequestMapping("/busJson")
    @ResponseBody
    public LayuiJson busJson(){
        LayuiJson layuiJson = new LayuiJson();
        Integer count = busService.findAll().size();
        layuiJson.data(count,busService.findAll());
        return layuiJson;
    }

    //显示查询的公交信息并返回json格式数据
    @RequestMapping("/busSelectJson")
    @ResponseBody
    public LayuiJson busSelectJson(@RequestParam("bus_name")String bus_name){
        if(bus_name.equals("")){
            return this.busJson();
        }
        LayuiJson layuiJson = new LayuiJson();
        if(busService.findAll(bus_name) != null){
            layuiJson.data(1, busService.findAll(bus_name));
        }
        return layuiJson;
    }

    //显示所有路线信息并返回json格式数据
    @RequestMapping("/routeJson")
    @ResponseBody
    public LayuiJson routeJson(){
        LayuiJson layuiJson = new LayuiJson();
        Integer count = busRouteService.findAllBusRoute().size();
        layuiJson.data(count,busRouteService.findAllBusRoute());
        return layuiJson;
    }

    //显示查询的路线信息并返回json格式数据
    @RequestMapping("/routeSelectJson")
    @ResponseBody
    public LayuiJson routeSelectJson(@RequestParam("routeId")Integer route_id){
        if(route_id == null){
            return this.routeJson();
        }
        LayuiJson layuiJson = new LayuiJson();
        List<BusRouteEntity>busList = new ArrayList<>();
        if(busRouteService.findBusRoute(route_id) != null){
            busList.add(busRouteService.findBusRoute(route_id));
            layuiJson.data(1,busList);
        }
        return layuiJson;
    }

    //显示所有站点信息
    @RequestMapping("/stationJson")
    @ResponseBody
    public LayuiJson stationJson(@RequestParam("page")Integer page,
                                 @RequestParam("limit")Integer limit){
        LayuiJson layuiJson = new LayuiJson();
        Integer count = busStationService.findAllBusStation().size();
        List<?>bus = layuiJson.data(page,limit,count,busStationService.findAllBusStation());
        layuiJson.data(count,bus);
        return layuiJson;
    }

    //显示查询的路线包含的站点
    @RequestMapping("/stationSelectJson")
    @ResponseBody
    public LayuiJson stationSelectJson(@RequestParam("routeId")Integer route_id,
                                       @RequestParam("page")Integer page,
                                       @RequestParam("limit")Integer limit){
        if(route_id == null){
            return this.stationJson(page,limit);
        }
        LayuiJson layuiJson = new LayuiJson();
        Integer count = busStationService.findAllBusStation(route_id).size();
        List<?>bus = layuiJson.data(page,limit,count,busStationService.findAllBusStation(route_id));
        layuiJson.data(count,bus);
        return layuiJson;
    }

    //动态加载公交路线select选择
    @RequestMapping("/routeId")
    @ResponseBody
    public List<String> routeSelect(){
        List<String> strings = new ArrayList<>();
        List<BusRouteEntity> busRouteEntities = busRouteService.findAllBusRoute();
        for(int i = 0 ; i < busRouteEntities.size() ; i++){
            strings.add(busRouteEntities.get(i).getRouteName());
        }
        return strings;
    }

    //动态获取routeId
    @RequestMapping("/getRouteId")
    @ResponseBody
    public List<Integer> getRouteId(){
        List<Integer>integers = new ArrayList<>();
        List<BusRouteEntity> busRouteEntities = busRouteService.findAllBusRoute();
        for(int i = 0 ; i < busRouteEntities.size() ; i++){
            integers.add(busRouteEntities.get(i).getRouteId());
        }
        return integers;
    }

    //动态获取stationId
    @RequestMapping("/getStationId")
    @ResponseBody
    public Integer getStationId(){
        List<BusStationEntity>busStationEntities = busStationService.findAllBusStation();
        Integer maxId = busStationEntities.get(busStationEntities.size()-1).getStationId();
        return maxId;
    }

    //删除
    //删除路线信息
    @RequestMapping("/routeDelete")
    @ResponseBody
    public Map<String,String> routeDelete(@RequestParam("routeId")Integer routeId){
        System.out.println(routeId);
        Map<String,String>map = new HashMap<>();
       if(busRouteService.removeBusRoute(routeId)){
           map.put("state","success");
           return map;
       }
       map.put("state","failed");
       return map;
    }

    //删除公交信息
    @RequestMapping("/busDelete")
    @ResponseBody
    public Map<String,String> busDelete(@RequestParam("bus_name")String name){
        Map<String,String> map = new HashMap<String,String>();
        if(busService.removeBusById(busService.findBus(name).getBusId())){
            removeBusSuccessOrFailed = true;
            map.put("state","success");
            return map;
        }
        removeBusSuccessOrFailed = false;
        map.put("state","failed");
        return map;
    }

    //删除站点信息
    @RequestMapping("/stationDelete")
    @ResponseBody
    public Map<String,String> stationDetele(@RequestParam("stationId")Integer stationId){
        Map<String,String> map = new HashMap<>();
        busStationService.removeBusStation(stationId);
        map.put("state","success");
        return map;
    }


    //修改
    //修改公交车详细信息
    /**
     * modify busDetails by bus_id (HttpServletRequest)
     * 这个写的是真的偷懒什么都没考虑就是笨方法瞎吉儿写根本就不符合controller层的写法23333333
     */
    @RequestMapping("/modifyBusDetails")
    public void modifyBusDetails(@RequestParam("date")String date,
                                 @RequestParam("company")String company,
                                 @RequestParam("pay")Integer pay,
                                 @RequestParam("status")String status,
                                 HttpServletRequest request){
        String bus_id = request.getParameter("bus_id");
        BusDetailsEntity busDetailsEntity = new BusDetailsEntity();
        if(busDetailsService.findBusDetails(Integer.parseInt(bus_id)) != null){
            busDetailsEntity = busDetailsService.findBusDetails(Integer.parseInt(bus_id));
            busDetailsEntity.setBusRunDate(date);
            busDetailsEntity.setBusCompany(company);
            busDetailsEntity.setBusPay(pay);
            busDetailsEntity.setBusStatus(status);
            busDetailsService.modifyBusDetails(busDetailsEntity);
        }else {
            busDetailsEntity.setBusId(Integer.parseInt(bus_id));
            busDetailsEntity.setRouteId((busService.findBus(Integer.parseInt(bus_id))).getRouteId());
            busDetailsEntity.setBusRunDate(date);
            busDetailsEntity.setBusCompany(company);
            busDetailsEntity.setBusPay(pay);
            busDetailsEntity.setBusStatus(status);
            busDetailsService.addBusDetails(busDetailsEntity);
        }
    }


    //修改公交车信息
    @RequestMapping("/modify")
    public void busModify(@RequestParam("busName")String busName,
                                        @RequestParam("route")Integer route){
        if(busService.modifyBus(busName,route)){
            return;
        }
    }



    @RequestMapping("/busEdit")
    @ResponseBody
    public String busEdit(@RequestParam("bus_name")String name,
                        @RequestParam("route_name")String route){
        int routeId = 0;
        if(busRouteService.findBusRoute(route) != null){
            routeId = busRouteService.findBusRoute(route).getRouteId();
            if(busService.modifyBus(name,routeId)){
                return "true";
            }
        }
        return "false";
    }


    @RequestMapping("/busCheckFind")
    @ResponseBody
    public Set<String> busCheckFind(@RequestParam("start")String start,
                                    @RequestParam("end")String end){
        List<BusStationEntity> busStation = busStationService.findAllBusStation();
        Set<String> strings = new TreeSet<>();
        for(int i = 0 ; i < busStation.size() ; i++){
            if(busStation.get(i).getStationName().indexOf(start) != -1){
                strings.add(busStation.get(i).getStationName());
            }
        }
        return strings;
    }


}
