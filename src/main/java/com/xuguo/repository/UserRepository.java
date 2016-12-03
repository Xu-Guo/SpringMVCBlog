package com.xuguo.repository;

import com.xuguo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xuxu on 12/3/16.
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
/*
（1） findAll()：查找表中所有记录；
（2）findOne(Integer id)：按id来查找某一条记录；
（3）findByXXX(Object xxx)：在这里XXX是一个字段名，根据该字段的值开查找所有记录；
（4）save()和delete()：添加一条记录以及删除一条记录。
*/
}
