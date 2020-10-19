package com.ybzbcq.mapper;

import java.util.List;

import com.ybzbcq.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

//@Mapper
@CacheConfig(cacheNames = "userCache")
public interface UserMapper {
	@Cacheable
	@Select("SELECT ID ,NAME,AGE FROM users where id=#{id}")
	List<Users> getUser(@Param("id") Integer id);
}
