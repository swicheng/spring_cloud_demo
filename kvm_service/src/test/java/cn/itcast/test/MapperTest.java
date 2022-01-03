package cn.itcast.test;


import cn.itcast.KVMApplication;
import cn.itcast.entity.Student;
import cn.itcast.service.SCService;
import cn.itcast.service.StudentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KVMApplication.class)
public class MapperTest {

    @Resource
    private StudentService studentService;

    @Resource
    private SCService scService;

    @Test
    public void test1(){

        List<Student> ls=  studentService.lambdaQuery().list();

        ls.forEach(student ->{
            QueryWrapper<Student> queryWrapper = new QueryWrapper<>();

        });



        System.out.println(ls);

    }

}
