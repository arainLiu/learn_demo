package com.nirvana.travel.mybatis.basedemo1.mapper;

import com.nirvana.travel.mybatis.basedemo1.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author arainliu
 * @date 2021/5/16
 */
public interface MainMapper {

  @Select("select * from t_user where id = #{id}")
  List<User> getUserList(@Param("id") Integer id, @Param("name") String name);

}
