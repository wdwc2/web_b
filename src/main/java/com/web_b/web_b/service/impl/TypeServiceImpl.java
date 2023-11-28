package com.web_b.web_b.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web_b.web_b.mapper.TypeMapper;
import com.web_b.web_b.pojo.Type;
import com.web_b.web_b.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TypeServiceImpl
        extends ServiceImpl<TypeMapper, Type>
        implements TypeService {

    @Autowired // 注入mapper
    private TypeMapper typeMapper;


    @Override
    public List<Type> findAllType() {
        return typeMapper.findAllType();
    }

    @Override
    public Type findType(Type type) {
        return typeMapper.findType(type);
    }

    @Override
    public void addType(Type type) {
        // 设置更新时间
        type.setUpdateTime(LocalDateTime.now());
        typeMapper.addType(type);
    }

    @Override
    public void deleteType(Type type) {
        typeMapper.deleteType(type);
    }

    @Override
    public Type updateType(Type type) {
        // 设置更新时间
        type.setUpdateTime(LocalDateTime.now());
        typeMapper.updateType(type);
        return typeMapper.findType(type);
    }
}
