package edu.uestc.msstudio.edu.uestc.msstudio.vipsystem.repository;

import edu.uestc.msstudio.edu.uestc.msstudio.vipsystem.model.Userinfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by MT on 2017/5/3.
 */
public interface UserRepository extends CrudRepository<Userinfo,Long> {


    @Query("select u from Userinfo u")
    List<Userinfo> findAll();
    
    List<Userinfo> findByName(String name);

    @Query("select u from Userinfo u where id = ?1")
    Userinfo findById(Long id);
    
    @Query("update Userinfo u set enable = false where id = ?1")
    int deleteByid(Long id);

}
