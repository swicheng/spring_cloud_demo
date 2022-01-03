package cn.itcast.service.impl;

import cn.itcast.entity.SC;
import cn.itcast.mapper.ScMapper;
import cn.itcast.service.SCService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SCServiceImpl extends ServiceImpl<ScMapper , SC> implements SCService {
}
