package project.projectspring.mapper;



import org.apache.ibatis.annotations.*;
import project.projectspring.data.Entity.UserProfile;

import java.util.List;

@Mapper
public interface UserProfileMapper {

    //getUserProfile를 호출했을 때 이 SQL문이 실행되어 UserProfile형태로 데이터를 가져옴
    @Select("SELECT * from UserProfile WHERE id=#{id}") //파라미터와 id를 연결할 때는 $가 아니라 #로 표시해야 함.
    UserProfile getUserProfile(@Param("id") String id);

    @Select("SELECT * from UserProfile")
    List<UserProfile> getUserProfileList();

    @Select("SELECT * from UserProfile WHERE id=#{id} AND name=#{name}")
    UserProfile getUserName(@Param("id") String id, @Param("name") String name);

    //insert, update, delete 는 결과로 int값 즉 이 SQL문으로 영향을 받은 레코드 개수가 반환됨.
    @Insert("INSERT INTO UserProfile VALUES(#{id}, #{name}, #{phone}, #{address})")
    void insertUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone,  @Param("address") String address);

    @Update("UPDATE UserProfile SET name=#{name}, phone=#{phone}, address=#{address} WHERE id=#{id}")
    void updateUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone,  @Param("address") String address);

    @Delete("DELETE from UserProfile WHERE id=#{id}")
    void deleteUserProfile(@Param("id") String id);


}