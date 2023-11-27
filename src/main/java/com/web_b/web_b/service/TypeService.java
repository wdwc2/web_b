package com.web_b.web_b.service;

import com.web_b.web_b.pojo.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {

    List<Type> findAllType();

    Type findType(Type type);

    void addType(Type type);

    void deleteType(Type type);

    Type updateType(Type type);
}
