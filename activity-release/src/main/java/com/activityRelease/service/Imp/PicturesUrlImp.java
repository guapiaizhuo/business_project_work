package com.activityRelease.service.Imp;

import com.activityRelease.mapper.PicturesMapper;
import com.activityRelease.model.OSSFileNameInfo;
import com.activityRelease.service.PicturesUrlService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PicturesUrlImp extends ServiceImpl<PicturesMapper, OSSFileNameInfo> implements PicturesUrlService {
}
