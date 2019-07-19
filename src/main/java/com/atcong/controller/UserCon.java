package com.atcong.controller;

import com.atcong.Util.GraphicsUtil;
import com.atcong.Util.LayuiJson;
import com.atcong.entity.UserInfoEntity;
import com.atcong.service.Impl.EmailImpl;
import com.atcong.service.UserAuthorityService;
import com.atcong.service.UserSafeService;
import com.atcong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserCon {

    @Autowired
    private UserService userService;
    @Autowired
    private UserAuthorityService userAuthorityService;
    @Autowired
    private UserSafeService userSafeService;
    @Autowired
    private EmailImpl email;

    @RequestMapping("/exit")
    public String exit(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.invalidate();
        return "User/UserLogin";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        HttpServletRequest request){
        if(userService.userLogin(username,password)){
            HttpSession session = request.getSession(true);
            session.setAttribute("username",username);
            if(userAuthorityService.findUserAuthority(userService.findUser(username).getUserId()).getUserAuthority() == 1) {
                return "index";
            }else {
                return "indexPerson";
            }
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("errMsg","账号或密码错误");
        return "User/UserLogin";
    }

    @RequestMapping("/userInfo")
    public String userInfo(){
        return "User/UserInfo";
    }

    /**
     * 获取用户基本信息并返回json格式数据
     * @return
     */
    @RequestMapping("/userJson")
    @ResponseBody
    public LayuiJson userJson(){
        LayuiJson layuiJson = new LayuiJson();
        Integer count = userService.findAll().size();
        layuiJson.data(count,userService.findAll());
        return layuiJson;
    }

    @RequestMapping("/authorityJson")
    @ResponseBody
    public LayuiJson authorityJson(){
        LayuiJson layuiJson = new LayuiJson();
        Integer count = userAuthorityService.findAll().size();
        layuiJson.data(count,userAuthorityService.findAll());
        return layuiJson;
    }

    @RequestMapping("/userSelectJson")
    @ResponseBody
    public LayuiJson userSelectJson(@RequestParam("userName")String username){
        if(username.equals("")){
            return this.userJson();
        }
        LayuiJson layuiJson = new LayuiJson();
        List<UserInfoEntity> user = new ArrayList<>();
        user.add(userService.findUser(username));
        layuiJson.data(1,user);
        return layuiJson;
    }

    @RequestMapping("/userEdit")
    public void userEdit(@RequestParam("userId")Integer id,
                           @RequestParam("userName")String username,
                           @RequestParam("userPassword")String password){
        userService.modifyUser(id,username,password);
    }

    @RequestMapping("/editAuthority")
    public void editAuthority(@RequestParam("userId")Integer id,
                              @RequestParam("authority")String authority){
        Integer aut = 0;
        if(authority.equals("管理员")){
            aut = 1;
        } else if (authority.equals("普通用户")) {
            aut = 0;
        }
        userAuthorityService.modifyUserAuthority(id,aut);
    }


    @RequestMapping("/userAdd")
    public String userAdd(){
        return "User/UserAdd";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(@RequestParam("username")String username,
                          @RequestParam("password")String password,
                          @RequestParam("authority")Integer authority){
        if(userService.findUser(username) != null || username.equals("")){
            return "false";
        }else {
            userService.addUser(username,password);
            userAuthorityService.addUserAuthority(userService.findUser(username).getUserId(),authority);
            return "true";
        }
    }

    @RequestMapping("/addUserInfo")
    @ResponseBody
    public String addUserInfo(){
        return "true";
    }

    @RequestMapping("/userDelete")
    public void deleteUser(@RequestParam("userId")Integer user_id){
        userAuthorityService.removeByUserId(user_id);
        userService.removeUser(user_id);
    }

    @RequestMapping("/userAuthority")
    public String moveUserAuthority(){
        return "/User/UserAuthorityInfo";
    }

    @RequestMapping("/forget")
    public String userForget(){
        return "User/UserForget";
    }

    @RequestMapping("/getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-control","no-cache");
        response.setDateHeader("Expires",0);
        response.setContentType("image/jpeg");

        Map<String,Object>map = new GraphicsUtil().getGraphics();
        System.out.println(map.get("rand"));
        request.getSession().setAttribute("rand",map.get("rand"));
        ImageIO.write((RenderedImage)map.get("image"),"JPEG",response.getOutputStream());
    }

    @RequestMapping("/userCheck")
    @ResponseBody
    public String userCheck(@RequestParam("user")String user){
        if(user.equals("")){
            return "null";
        }else if(userService.findUser(user) == null){
            return "false";
        }else {
            return "true";
        }
    }

    @RequestMapping("/sendMail")
    @ResponseBody
    public void sendMail(@RequestParam("email")String mail,
                         @RequestParam("user")String user){
        String content = "请勿回复本邮件.点击下面的链接,重设密码" + "\"http://localhost:8080/emailCheck?user=" + user + "\"";
        email.sendMail(mail,content);
    }

    @RequestMapping("/userChange")
    public String userChange(@RequestParam("user")String user,
                             @RequestParam("password")String password){
        userService.modifyUser(userService.findUser(user).getUserId(),user,password);
        return "User/UserForgetFinal";
    }

    @RequestMapping("/userSafeInfo")
    public String userSafeInfo(Model model,@RequestParam("user")String user){
        model.addAttribute("mail",userSafeService.findUserSafe(Integer.parseInt(user)));
        return "User/UserSafe";
    }

    @RequestMapping("/userDetail")
    public String userDetail(Model model,@RequestParam("user")String user){
        model.addAttribute("mail",userSafeService.findUserSafe(Integer.parseInt(user)));
        return "User/UserDetail";
    }

}
