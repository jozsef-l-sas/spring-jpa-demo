package com.pluralsight.conference.service;

import com.pluralsight.conference.model.Course;
import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationReport;
import com.pluralsight.conference.repository.CourseRepository;
import com.pluralsight.conference.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final CourseRepository courseRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository, CourseRepository courseRepository) {
        this.registrationRepository = registrationRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Registration addRegistration(Registration registration) {
        Course course = Course.builder()
                              .name("Intro")
                              .description("Every attendee must complete the intro.")
                              .registration(registration)
                              .build();
        registration.getCourses().add(course);
        Registration savedRegistration = registrationRepository.save(registration);

        return savedRegistration;
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public List<Registration> getRegistrations() {
        return registrationRepository.getRegistrations();
    }

    @Override
    public List<RegistrationReport> getRegistrationReports() {
        return registrationRepository.getRegistrationReports();
    }

}
