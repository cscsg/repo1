package com.zl.ssm.controller;

import com.zl.ssm.dao.Role;
import com.zl.ssm.dao.Users;
import com.zl.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/updateuser.do")
    public void updateuser(){
        System.out.println("用户名:"+"-------------------");
    }

    @RequestMapping("deleteRoleToUser.do")
    public String deleteRoleToUser(@RequestParam(name ="userId",required = true) Integer userId,@RequestParam(name = "ids",required = true) Integer[] roleIds){
        iUserService.deleteRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

    //给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name ="userId",required = true) Integer userId,@RequestParam(name = "ids",required = true) Integer[] roleIds){
        iUserService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

    //查询用户以及用户可以删除的角色
    @RequestMapping("/findUserByIdAndAllRoleDel.do")
    public ModelAndView findUserByIdAndAllRoleDel(@RequestParam(name = "id", required = true) Integer userid) throws Exception {
        ModelAndView mv = new ModelAndView();
        //1.根据用户id查询用户
        Users userInfo = iUserService.findById(userid);
        List<Role> roleList=iUserService.findRoles(userid);
        mv.addObject("user", userInfo);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-delete");
        return mv;
    }

    //查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) Integer userid) throws Exception {
        ModelAndView mv = new ModelAndView();
        //1.根据用户id查询用户
        Users userInfo = iUserService.findById(userid);
        //2.根据用户id查询可以添加的角色
        List<Role> otherRoles = iUserService.findOtherRoles(userid);
        mv.addObject("user", userInfo);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Users users) throws Exception {
        iUserService.save(users);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Users> userList=iUserService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id)throws Exception{
        ModelAndView mv=new ModelAndView();
        System.out.println("======================="+id+"===================================");
        Users users=iUserService.findById(id);
        System.out.println(users.getId()+users.getUsername());
        System.out.println("=====================================================================");
        mv.addObject("user",users);
        mv.setViewName("user-show");
        return mv;
    }
}
