package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends CrudRepository<Registration, Long> {

    @Query("SELECT r FROM Registration r")
    List<Registration> getRegistrations();

    List<RegistrationReport> getRegistrationReports();

}
