package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

}
