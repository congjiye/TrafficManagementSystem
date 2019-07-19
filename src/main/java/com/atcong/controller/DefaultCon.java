package com.atcong.controller;

import com.atcong.Util.BusFindJson;
import com.atcong.Util.Transfer;
import com.atcong.entity.*;
import com.atcong.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.atcong.Util.enumPlaneStation;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class DefaultCon {

    @Autowired
    private UserService userService;
    @Autowired
    private UserSafeService userSafeService;
    @Autowired
    private BusService busService;
    @Autowired
    private BusRouteService busRouteService;
    @Autowired
    private BusStationService busStationService;
    @Autowired
    private BusDetailsService busDetailsService;
    @Autowired
    private SubwayService subwayService;
    @Autowired
    private SubwayRouteService subwayRouteService;
    @Autowired
    private SubwayDetailsService subwayDetailsService;
    @Autowired
    private SubwayStationService subwayStationService;
    @Autowired
    private PlaneService planeService;
    @Autowired
    private PlaneRouteService planeRouteService;
    @Autowired
    private PlaneDetailsService planeDetailsService;
    @Autowired
    private TrainService trainService;
    @Autowired
    private TrainRouteService trainRouteService;
    @Autowired
    private TrainDetailsService trainDetailsService;


    @RequestMapping("")
    public String defaultPage(){
        return "User/UserLogin";
    }

    @RequestMapping("/showPage")
    public String showPage(HttpSession session){
        session.removeAttribute("username");
        return "ShowPage";
    }

    @RequestMapping("/index")
    public String intoIndex(){ return "systemIndex"; }

    @RequestMapping("/getMap")
    public String getMap(){
        return "map";
    }

    @RequestMapping("/chooseBus")
    public String chooseBus(){
        return "BusInfo";
    }

    @RequestMapping("/chooseSubway")
    public String chooseSubway(){return "SubwayChoose";}

    public List<String> transferBus(String start,String end){
        Transfer transfer = new Transfer();
        List<String>position = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        Set<Integer>startSet = transfer.setRoute(busStationService.findAllBusStation(start));
        Set<Integer>endSet = transfer.setRoute(busStationService.findAllBusStation(end));
        list = transfer.compare(startSet,endSet);
        if(list.size() != 0){
            position.add(start);
//            return position;
        }else {
            List<Integer>route = transfer.getRoute(startSet);
            for(int i = 0 ; i < route.size() ; i++){
                List<BusStationEntity>bus = busStationService.findAllBusStation(route.get(i));
                for(int j = 0 ; j < bus.size() ; j++){
                    return transferBus(bus.get(j).getStationName(),end);
                }
            }
        }
        return position;
    }


    @RequestMapping("/desBus")
    public String desBus(@RequestParam("start")String start,
                       @RequestParam("end")String end,Model model){
        if(start.equals("") || end.equals("")){
            return "BusInfo";
        }
        model.addAttribute("route",start + "-" + end);
        Transfer transfer = new Transfer();
        Set<Integer>startSet = transfer.setRoute(busStationService.findAllBusStation(start));
        Set<Integer>endSet = transfer.setRoute(busStationService.findAllBusStation(end));
        List<Integer>list = transfer.compare(startSet,endSet);
        List<BusInfoEntity>bus = new ArrayList<>();
        List<String>s = new ArrayList<>();
        List<String>bustr = new ArrayList<>();
        if(list.size() != 0){
            for(int i = 0 ; i < list.size() ; i++){
                bus.addAll(busService.findAllBus(list.get(i)));
            }
        }else {
            List<Integer>routeList = transfer.getRoute(startSet);
            for(int i = 0 ; i < routeList.size() ; i++){
                List<BusStationEntity>station = busStationService.findAllBusStation(routeList.get(i));
                List<String>mid = new ArrayList<>();
                for(int j = 0 ; j < station.size() ; j++){
                    if(busStationService.findAllBusStation(station.get(j).getStationName()).size() >= 2){
                        mid.add(station.get(j).getStationName());
                    }
                }
                for(int j = 0 ; j < mid.size() ; j++){
                    Set<Integer>routeSet = transfer.setRoute(busStationService.findAllBusStation(mid.get(j)));
                    Set<Integer>endSet1 = transfer.setRoute(busStationService.findAllBusStation(end));
                    if(transfer.compare(routeSet,endSet1).size() != 0){
                        List<Integer>ms = new ArrayList<>();
//                        s.add(mid.get(j));
                        ms.add(busStationService.findRouteId(start,mid.get(j)));
                        ms.add(busStationService.findRouteId(mid.get(j),end));
                        s.add(busService.findAllBus(ms.get(0)).get(0).getBusName() + "-" + busService.findAllBus(ms.get(1)).get(0).getBusName() + "-" + mid.get(j));
                    }
                }

            }
        }
        model.addAttribute("s",s);
        model.addAttribute("bus",bus);
        return "BusTransfer";
    }

    @RequestMapping("/desRoute")
    public String desRoute(@RequestParam("busName")String busName,Model model){
        if(busName.equals("")){
            return  "BusInfo";
        }
        if(busService.findBus(busName) == null){
            return "BusInfo";
        }
        model.addAttribute("bus",busService.findBus(busName));
        model.addAttribute("route",busRouteService.findBusRoute(busService.findBus(busName).getRouteId()));
        model.addAttribute("busDetails",busDetailsService.findBusDetails(busService.findBus(busName).getBusId()));
        model.addAttribute("station", busStationService.findAllBusStation(busRouteService.findBusRoute(busService.findBus(busName).getRouteId()).getRouteId()));
        return "BusInfoBySearch";
    }

    @RequestMapping("/desStation")
    public String desStation(@RequestParam("stationName")String stationName,Model model){
        if(stationName.equals("")){
            model.addAttribute("info","不能为空");
            return "BusInfo";
        }
        if(busStationService.findAllBusStation(stationName).size() == 0){
            model.addAttribute("info","站点不存在");
            return "BusInfo";
        }
        model.addAttribute("stationName",stationName);
//        model.addAttribute("station",busStationService.findAllBusStation(stationName));
        Set<Integer>routeSet = new TreeSet<>();
        List<List<BusInfoEntity>>buslist = new ArrayList<>();
        for(int i = 0 ; i < busStationService.findAllBusStation(stationName).size() ; i++){
            routeSet.add(busStationService.findAllBusStation(stationName).get(i).getRouteId());
        }
        for(Iterator iterator = routeSet.iterator();iterator.hasNext();){
            buslist.add(busService.findAllBus((Integer) iterator.next()));
        }
        model.addAttribute("busList",buslist);
        return "BusStation";
    }

    @RequestMapping("/findBus")
    public String findBus(@RequestParam("busName")String busName, Model model){
        List<BusFindJson>list = new ArrayList<>();
        Integer count = busService.findAll().size();
        for(int i = 0 ; i < count ; i++){
            if(busService.findAll().get(i).getBus_name().substring(0,1).equals(busName)){
                list.add(busService.findAll().get(i));
            }
        }
        model.addAttribute("bus",list);
        return "BusInfoByBusName";
    }

    @RequestMapping("/desSubway")
    public String desSubway(@RequestParam("start")String start,
                            @RequestParam("end")String end,Model model){
        if(start.equals("") || end.equals("")){
            return "SubwayChoose";
        }
        List<List<String>>v = new ArrayList<>();//路线表
        Transfer transfer = new Transfer();
        Set<Integer>startSet = transfer.setRouteSubway(subwayStationService.findAllSubwayStation(start));
        Set<Integer>endSet = transfer.setRouteSubway(subwayStationService.findAllSubwayStation(end));
        List<Integer>list = transfer.compare(startSet,endSet);
        List<SubwayInfoEntity>subway = new ArrayList<>();
        List<String>s = new ArrayList<>();
        if(list.size() != 0){
            for(int i = 0 ; i < list.size() ; i++){
                subway.addAll(subwayService.findAll(list.get(i)));
            }
        }else {
            List<Integer>route = transfer.getRoute(startSet);
            for(int i = 0 ; i < route.size() ; i++){
                List<SubwayStationEntity>station = subwayStationService.findAllSubwayStation(route.get(i));
                List<String>mid = new ArrayList<>();
                for(int j = 0 ; j < station.size() ; j++){
                    if(subwayStationService.findAllSubwayStation(station.get(j).getStationName()).size() >= 2){
                        mid.add(station.get(j).getStationName());
                    }
                }
                for(int j = 0 ; j < mid.size() ; j++){
                    Set<Integer>routeSet = transfer.setRouteSubway(subwayStationService.findAllSubwayStation(mid.get(j)));
                    Set<Integer>endSet1 = transfer.setRouteSubway(subwayStationService.findAllSubwayStation(end));
                    if(transfer.compare(routeSet,endSet1).size() != 0){
                        List<Integer>ms = new ArrayList<>();
//                        s.add(mid.get(j));
                        ms.add(subwayStationService.findRouteId(start,mid.get(j)));
                        ms.add(subwayStationService.findRouteId(mid.get(j),end));
                        s.add(subwayService.findAll(ms.get(0)).get(0).getSubwayName() + "-" + subwayService.findAll(ms.get(1)).get(0).getSubwayName() + "-" + mid.get(j));
                    }
                }
            }
        }
        model.addAttribute("s",s);
        model.addAttribute("route",start + "-" + end);
        model.addAttribute("subway",subway);
        return "SubwayTransfer";
    }

    @RequestMapping("/desSubwayRoute")
    public String desSubwayRoute(@RequestParam("subwayName")String subwayName,Model model){
        String name = new String();
        for(int i = 0 ; i < subwayService.findall().size() ; i++){
            if(subwayService.findall().get(i).getSubwayName().indexOf(subwayName) != -1){
                name = subwayService.findall().get(i).getSubwayName();
            }
        }
        model.addAttribute("subway",subwayService.findSubway(name));
        model.addAttribute("route",subwayRouteService.findSubwayRoute(subwayService.findSubway(name).getSubwayRoute()));
        model.addAttribute("station",subwayStationService.findAllSubwayStation(subwayService.findSubway(name).getSubwayRoute()));
        model.addAttribute("detail",subwayDetailsService.findSubwayDetails(subwayService.findSubway(name).getSubwayId()));
        return "SubwayInfoBySearch";
    }

    @RequestMapping("/desSubwayStation")
    public String desSubwayStation(@RequestParam("stationName")String stationName,Model model){
        if(stationName.equals("") || subwayStationService.findAllSubwayStation(stationName).size() == 0){
            return "SubwayChoose";
        }
        model.addAttribute("station",stationName);
        Set<Integer>routeSet = new TreeSet<>();
        List<List<SubwayInfoEntity>>lists = new ArrayList<>();
        for(int i = 0 ; i < subwayStationService.findAllSubwayStation(stationName).size() ; i++){
            routeSet.add(subwayStationService.findAllSubwayStation(stationName).get(i).getRouteId());
        }
        for(Iterator iterator = routeSet.iterator() ; iterator.hasNext();){
            lists.add(subwayService.findAll((Integer) iterator.next()));
        }
        model.addAttribute("subway",lists);
        return "SubwayStationInfo";
    }

    @RequestMapping("/subwayMap")
    public String subwayMap(){
        return "SubwayMap";
    }

    @RequestMapping("/choosePlane")
    public String choosePlane(){
        return "PlaneChoose";
    }

    @RequestMapping("/desPlane")
    public String desPlane(@RequestParam("start")String start,
                           @RequestParam("end")String end,Model model){
        String routeName = start + "-" + end;
        if(start.equals("") || end.equals("") || planeRouteService.findPlaneRoute(routeName) == null){
            return "PlaneChoose";
        }
        model.addAttribute("planeExc",enumPlaneStation.getStationName(routeName));
        model.addAttribute("plane",planeService.findAllPlaneDetails(routeName));
        return "PlaneBySearch";
    }

    @RequestMapping("/findPlane")
    public String findPlane(@RequestParam("planeName")String planeName,Model model){
        model.addAttribute("planeName",planeName);
        model.addAttribute("planeDel",planeDetailsService.findPlaneDetails(planeService.findPlane(planeName).getPlaneId()));
        model.addAttribute("planeRte",planeRouteService.findPlaneRoute(planeService.findPlane(planeName).getPlaneRoute()));
        model.addAttribute("planeEx",enumPlaneStation.getStationName(planeRouteService.findPlaneRoute(planeService.findPlane(planeName).getPlaneRoute()).getRouteName()));
        return "findPlane";
    }

    @RequestMapping("/desPlaneSelect")
    public String desPlaneSelect(@RequestParam("start")String start,
                                 @RequestParam("end")String end,
                                 @RequestParam("date")String date,Model model){
        String routeName = start + "-" + end;
        model.addAttribute("planeExc",enumPlaneStation.getStationName(routeName));
        model.addAttribute("plane",planeService.findAllPlane(date,routeName));
        return "PlaneBySearch";
    }

    @RequestMapping("/chooseTrain")
    public String chooseTrain(HttpServletRequest request,Model model){
        if(request.getParameter("start") != null){
            model.addAttribute("start",request.getParameter("start"));
        }else if(request.getParameter("end") != null){
            model.addAttribute("end",request.getParameter("end"));
        }
        return "TrainChoose";
    }

    @RequestMapping("/desTrain")
    public String desTrain(@RequestParam("start")String start,
                           @RequestParam("end")String end,
                           HttpSession session,
                           Model model){
        String routeName = start + "-" + end;
        Integer max = 0;
        String maxKey = new String();
        if(session.getAttribute(routeName) == null){
            session.setAttribute(routeName,1);
        }else {
            Integer count = (Integer) session.getAttribute(routeName) + 1;
            session.setAttribute(routeName,count);
        }
        Enumeration<String> enumeration = session.getAttributeNames();
        while (enumeration.hasMoreElements()){
            String key = enumeration.nextElement().toString();
            if((Integer)session.getAttribute(key) >= max){
                max = (Integer)session.getAttribute(key);
                maxKey = key;
            }
        }
        model.addAttribute("trainPop",trainService.findAllTrain(maxKey));
        model.addAttribute("train",trainService.findAllTrain(routeName));
        return "TrainInfoBySearch";
    }

    @RequestMapping("/desTrainRoute")
    public String desTrainRoute(@RequestParam("trainName")String trainName,Model model){
        model.addAttribute("train",trainService.findTrain(trainName));
        model.addAttribute("trainRoute",trainRouteService.findTrainRoute(trainService.findTrain(trainName).getTrainRoute()));
        model.addAttribute("trainDel",trainDetailsService.findTrainDetail(trainService.findTrain(trainName).getTrainId()));
        return "TrainFinde";
    }

    @RequestMapping("/desTrainStation")
    public String desTrainStation(@RequestParam("trainStationName")String stationName,Model model){
        model.addAttribute("trainStation",stationName);
        model.addAttribute("trainRouteStation",trainRouteService.findAllTrainRoute(stationName));
        return "TrainStationFinde";
    }

    @RequestMapping("/regCheck")
    @ResponseBody
    public String regCheck(@RequestParam("reg")String reg,HttpSession session){
        if(reg.equals(session.getAttribute("rand"))){
            return "true";
        }else {
            return "false";
        }
    }

    @RequestMapping("/checkCode")
    public String checkCode(@RequestParam("user")String user,
                            @RequestParam("register")String register,
                            HttpSession session,Model model){
        String email = new String();
        if(userService.findUser(user) == null){
            return "User/UserForget";
        }else {
            email = userSafeService.findUserSafe(Integer.parseInt(user));
        }
        if(!register.equals(session.getAttribute("rand"))){
            return "User/UserForget";
        }else {
            model.addAttribute("user",user);
            model.addAttribute("email",email);
            return "User/UserForgetSecond";
        }
    }

    @RequestMapping("/emailCheck")
    public String emailCheck(@RequestParam("user")String user,Model model){
        model.addAttribute("user",userService.findUser(user));
        return "User/UserForgetThird";
    }

    @RequestMapping("/compareStation")
    @ResponseBody
    public String compareStation(@RequestParam("station")String station){
        if(busStationService.findAllBusStation(station).size() >= 2){
            return station;
        }else {
            return "false";
        }
    }


}
