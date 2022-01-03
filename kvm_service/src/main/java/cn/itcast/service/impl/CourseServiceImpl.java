package cn.itcast.service.impl;


import cn.itcast.entity.Course;
import cn.itcast.mapper.CourseMapper;
import cn.itcast.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper , Course> implements CourseService {

}
