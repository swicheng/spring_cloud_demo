package cn.itcast.service.impl;

import cn.itcast.entity.Student;
import cn.itcast.mapper.StudentMapper;
import cn.itcast.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper , Student> implements StudentService {
}
