package com.xiaowu.springbootmybatis.service.impl;

import com.xiaowu.springbootmybatis.dao.*;
import com.xiaowu.springbootmybatis.mapper.CourseMapper;
import com.xiaowu.springbootmybatis.mapper.SCMapper;
import com.xiaowu.springbootmybatis.mapper.StudentMapper;
import com.xiaowu.springbootmybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private SCMapper scMapper;


    @Override
    public List queryByName(String name) {

        // 学生信息
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria studentExampleCriteria = studentExample.createCriteria();
        studentExampleCriteria.andNameLike("%studentName%");
        List<Student> students = studentMapper.selectByExample(studentExample);

        //SC表
        List<Long> studentIds = students.stream().map(Student::getStudentId).distinct().collect(Collectors.toList());
        SCExample scExample = new SCExample();
        SCExample.Criteria scExampleCriteria = scExample.createCriteria();
        scExampleCriteria.andStudentIdIn(studentIds);
        List<SC> scs = scMapper.selectByExample(scExample);

        //课程信息
        List<Long> courseIds = scs.stream().map(SC::getCourseId).distinct().collect(Collectors.toList());
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria courseExampleCriteria = courseExample.createCriteria();
        courseExampleCriteria.andCourseIdIn(courseIds);
        List<Course> courses = courseMapper.selectByExample(courseExample);

        if (students.size() != 0) {
            return students;
        } else {
            return null;
        }
//        return null;
    }
}
