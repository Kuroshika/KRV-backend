package com.kuka.krv.service.impl;

import com.kuka.krv.entity.Info;
import com.kuka.krv.dao.InfoRepository;
import com.kuka.krv.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoRepository infoRepository;

    @Override
    public Info getInfoById(int id){
        return infoRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
