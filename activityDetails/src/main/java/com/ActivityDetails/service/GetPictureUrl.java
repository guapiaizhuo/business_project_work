package com.ActivityDetails.service;

import com.ActivityDetails.model.OSSFileNameInfo;
import com.ActivityDetails.model.PictureResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface GetPictureUrl extends IService<OSSFileNameInfo> {
    List<PictureResponse> getPictureResponse(Long id);
}
