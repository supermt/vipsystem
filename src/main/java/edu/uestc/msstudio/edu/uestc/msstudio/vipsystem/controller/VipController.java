package edu.uestc.msstudio.edu.uestc.msstudio.vipsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uestc.msstudio.edu.uestc.msstudio.vipsystem.model.Userinfo;
import edu.uestc.msstudio.edu.uestc.msstudio.vipsystem.model.VIPRank;
import edu.uestc.msstudio.edu.uestc.msstudio.vipsystem.repository.UserRepository;
import edu.uestc.msstudio.edu.uestc.msstudio.vipsystem.service.VipOperations;

/**
 * Created by MT on 2017/5/3.
 */
@RestController
public class VipController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    public String test() {
        this.addTestUsers();
        return "hello you guys";
    }
    @GetMapping("/list")
    public List<Userinfo> listAll() {
        return userRepository.findAll();
    }
    @GetMapping("/selectByName")
    public List<Userinfo> listAllUser(@RequestParam String name) {
        return userRepository.findByName(name);
    }
    @GetMapping("/selectById/{id}")
    public Userinfo queryOne(@PathVariable Long id) {
        return userRepository.findById(id);
    }
    @PostMapping("/create")
    public Userinfo createOne(@RequestBody Userinfo input) {
        Userinfo result = userRepository.save(input);
        return result;
    }
    @DeleteMapping("/delete/{id}")
    public Userinfo deleteOne(@PathVariable Long id) {
        Userinfo target = userRepository.findById(id);
        userRepository.delete(id);
        return target;
    }
    @PutMapping("/update")
    public Userinfo modifyOne(@RequestBody Userinfo originEntity) {
        if (userRepository.exists(originEntity.getId())) {
            Userinfo target = userRepository.save(originEntity);
            return target;
        }
        return null;
    }
    @PutMapping("/update/charge")
    public Userinfo chargeMoney(@RequestParam Long userid, @RequestParam Long count) {
        Userinfo target = userRepository.findById(userid);
        target.setBalance(target.getBalance() + count);
        target.setTotalCount(target.getTotalCount() + VipOperations.moneyToScore(count, target.getRank()));
        return userRepository.save(target);
    }
    @PutMapping("/update/consume")
    public Userinfo consuming(@RequestParam Long userid, @RequestParam Long count) {
        Userinfo target = userRepository.findById(userid);
        target.setBalance(target.getBalance() - VipOperations.discount(Float.valueOf(count), target.getRank()));
        return userRepository.save(target);
    }
    private void addTestUsers() {
        Userinfo a = new Userinfo();
        a.setBalance(0l);
        a.setTotalCount(0l);
        a.setName("SuperMT");
        a.setRank(VIPRank.Golden_User);
        userRepository.save(a);
        Userinfo b = new Userinfo();
        b.setBalance(100l);
        b.setTotalCount(0l);
        b.setName("Whatever");
        b.setRank(VIPRank.Silver_User);
        userRepository.save(b);
    }
}
