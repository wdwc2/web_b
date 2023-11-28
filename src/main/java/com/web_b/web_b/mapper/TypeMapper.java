package com.web_b.web_b.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web_b.web_b.pojo.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TypeMapper
        extends BaseMapper<Type> {

    @Select("select * from type order by update_time desc")
    List<Type> findAllType();

    @Select("select * from type where type=#{type}")
    Type findType(Type type);

    @Insert("insert into type (type,description,update_time) values (#{type}, #{description}, #{updateTime})")
    void addType(Type type);

    @Delete("delete from type where type=#{type}")
    void deleteType(Type type);

    @Update("update type set description=#{description},update_time=#{updateTime} where type=#{type}")
    void updateType(Type type);
}
