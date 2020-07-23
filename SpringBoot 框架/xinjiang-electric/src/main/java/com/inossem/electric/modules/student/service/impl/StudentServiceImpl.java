package com.inossem.electric.modules.student.service.impl;

import com.inossem.electric.modules.student.entity.Student;
import com.inossem.electric.modules.student.dao.StudentMapper;
import com.inossem.electric.modules.student.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author inossem
 * @since 2020-07-23
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Override
    public  IPage<Student> findListByPage(Integer page, Integer pageCount){
        IPage<Student> wherePage = new Page<>(page, pageCount);
        Student where = new Student();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Student student){
        return baseMapper.insert(student);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Student student){
        return baseMapper.updateById(student);
    }

    @Override
    public Student findById(Long id){
        return  baseMapper.selectById(id);
    }
}
