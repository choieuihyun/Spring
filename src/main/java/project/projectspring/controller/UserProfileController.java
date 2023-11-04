package project.projectspring.controller;

import jakarta.annotation.PostConstruct;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.*;
import project.projectspring.data.Entity.UserProfile;
import project.projectspring.mapper.UserProfileMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserProfileController {

    private UserProfileMapper mapper;

    //생성자. mapper를 전달받아서 private변수에 설정함.
    public UserProfileController(UserProfileMapper mapper) {
        this.mapper = mapper; //전달받은 mapper 로 api를 호출 가능.
    }

    //    @GetMapping("/user/{id}") // 왜 이렇게 하면 getUserName이 안되고
//    public UserProfile getUserProfile(@PathVariable("id") String id) {
//        return mapper.getUserProfile(id);
//    }
    @GetMapping("/user/") // 여기가 url을 왜 이렇게 해야 되는거냐? 각각 url 따로 노는거 아님?
    // @PathVariable("id") 이거 차이였네 id를 경로에서 추출하는거라 내가 url에 id를 넣어야만 get이 된거였음.
    // 근데 그러면 @PathVariable는 Post 구조에는 없어야겠네?
    public UserProfile getUserProfile(String id) {
        return mapper.getUserProfile(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList() {
        return mapper.getUserProfileList();
    }

    @GetMapping("/user/{id}/{name}")
    public UserProfile getUserName(@PathVariable("id") String id, @PathVariable("name") String name) {
        return mapper.getUserName(id, name);
    }

    //데이터 생성
    @PostMapping("/user/")
    public void postUserProfile(String id, String name, String phone, String address) {
        mapper.insertUserProfile(id, name, phone, address);
    }

//    @PostMapping("/user/")
//    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
//        mapper.insertUserProfile(id, name, phone, address);
//    }

    //데이터 수정
    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        mapper.updateUserProfile(id, name, phone, address);
    }

    //데이터 삭제
    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id) {
        mapper.deleteUserProfile(id);
    }
}
