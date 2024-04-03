package com.ActivityDetails.service.Imp;

import com.ActivityDetails.mapper.PictureListMapper;
import com.ActivityDetails.model.OSSFileNameInfo;
import com.ActivityDetails.model.PictureResponse;
import com.ActivityDetails.service.GetPictureUrl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class GetPictureUrlImp extends ServiceImpl<PictureListMapper, OSSFileNameInfo> implements GetPictureUrl {
    @Autowired
    PictureListMapper pictureListMapper;
    @Override
    public List<PictureResponse> getPictureResponse(Long id) {
        List<OSSFileNameInfo> list;
        LambdaQueryWrapper<OSSFileNameInfo> qw = new LambdaQueryWrapper<>();
        qw.eq(OSSFileNameInfo::getId, id);
        list = list(qw);
        List<PictureResponse> responses = new ArrayList<>();
        for (OSSFileNameInfo fileNameInfo : list) {
            PictureResponse response = new PictureResponse();
            response.setPictureUrl(fileNameInfo.getPictureUrl());
            responses.add(response);
        }
        return responses;

    }
}
