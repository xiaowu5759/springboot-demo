package com.xiaowu.backspringboot.service.impl;

import com.xiaowu.backspringboot.dao.*;
import com.xiaowu.backspringboot.mapper.CourseMapper;
import com.xiaowu.backspringboot.mapper.SCMapper;
import com.xiaowu.backspringboot.mapper.StudentMapper;
import com.xiaowu.backspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    SCMapper scMapper;

    @Override
    public List queryByName(String studentName) {

        // 学生信息
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria studentExampleCriteria = studentExample.createCriteria();
        studentExampleCriteria.andNameLike("studentName");
        List<Student> students = studentMapper.selectByExample(studentExample);

        //SC表
        List<Long> studentIds = students.stream().map(Student::getStudentId).distinct().collect(Collectors.toList());
        System.out.println(studentIds);
        SCExample scExample = new SCExample();
        SCExample.Criteria scExampleCriteria = scExample.createCriteria();
        scExampleCriteria.andStudentIdIn(studentIds);
        List<SC> scs = scMapper.selectByExample(scExample);

        //课程信息
        List<Long> courseIds = scs.stream().map(SC::getCourseId).distinct().collect(Collectors.toList());
        System.out.println(courseIds);
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria courseExampleCriteria = courseExample.createCriteria();
        courseExampleCriteria.andCourseIdIn(courseIds);
        List<Course> courses = courseMapper.selectByExample(courseExample);

        if(courses.size() != 0) {
            return courses;
        }
        else {
            return null;
        }

    }
}
