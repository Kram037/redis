package co.develhope.redisCache.controllers;

import co.develhope.redisCache.entities.jpa.UserJPA;
import co.develhope.redisCache.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public UserJPA create(@RequestBody UserJPA user){
        return userService.create(user);
    }

    @GetMapping("/list")
    public List<UserJPA> readAll(){
        return userService.readAll();
    }

    @GetMapping("/{id}")
    public UserJPA readOne(@PathVariable Long id){
        return userService.readOne(id);
    }

    @GetMapping("/{id}/fast")
    public void readOneFast(@PathVariable Long id){
        userService.readOneFast(id);
    }

    @PutMapping("/update/{id}")
    public UserJPA update(@PathVariable Long id, @RequestBody UserJPA user){
        return userService.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

}
