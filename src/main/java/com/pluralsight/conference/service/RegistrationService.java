package com.pluralsight.conference.service;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationReport;

import java.util.List;

public interface RegistrationService {

    Registration addRegistration(Registration registration);
    Registration updateRegistration(Registration registration);
    List<Registration> getRegistrations();
    List<RegistrationReport> getRegistrationReports();

}
