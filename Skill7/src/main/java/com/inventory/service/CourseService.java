package com.inventory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.model.Course;

@Service
public class CourseService {

    private List<Course> courseList = new ArrayList<>();

    // CREATE
    public Course addCourse(Course course) {
        courseList.add(course);
        return course;
    }

    // READ ALL
    public List<Course> getAllCourses() {
        return courseList;
    }

    // READ BY ID
    public Course getCourseById(int id) {
        for (Course c : courseList) {
            if (c.getCourseId() == id) {
                return c;
            }
        }
        return null;
    }

    // UPDATE
    public Course updateCourse(int id, Course updatedCourse) {
        for (Course c : courseList) {
            if (c.getCourseId() == id) {
                c.setTitle(updatedCourse.getTitle());
                c.setDuration(updatedCourse.getDuration());
                c.setFee(updatedCourse.getFee());
                return c;
            }
        }
        return null;
    }

    // DELETE
    public boolean deleteCourse(int id) {
        return courseList.removeIf(c -> c.getCourseId() == id);
    }

    // SEARCH BY TITLE
    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course c : courseList) {
            if (c.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(c);
            }
        }
        return result;
    }
}