package cn.bnz.service.controller;


import cn.bnz.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("consumer/user")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    @ResponseBody
    public User queryById(@RequestParam("id")Long id){
        User user = restTemplate.getForObject("http://localhost:8081/user/" + id, User.class);
        return  user;
    }




}
