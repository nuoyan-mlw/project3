package com.crazycode.mapper;

import com.crazycode.pojo.Member;
import com.crazycode.pojo.Traveller;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TravellerMapper {
    //查找Traveller
    public List<Traveller> queryTravellerById(String tId)throws Exception;
}
