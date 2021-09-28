package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.model.RegistrationReport;
import com.pluralsight.conference.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("registration")
    public String getRegistration(@ModelAttribute ("registration")Registration registration) {
        return "registration";
    }

    @GetMapping("registrations")
    @ResponseBody
    public List<Registration> getRegistrations() {
        return registrationService.getRegistrations();
    }

    @GetMapping("registration-reports")
    @ResponseBody
    public List<RegistrationReport> getRegistrationReports() {
        return registrationService.getRegistrationReports();
    }

    @PostMapping("registration")
    public String addRegistration(@Valid @ModelAttribute ("registration")
                                              Registration registration,
                                  BindingResult result) {

        if(result.hasErrors()) {
            System.out.println("There were errors");
            return "registration";
        } else {
            registrationService.addRegistration(registration);
        }

        System.out.println("Registration: " + registration.getName());

        return "redirect:registration";
    }

    @PutMapping("registration")
    @ResponseBody
    public Registration updateRegistration(@RequestBody @Valid Registration registration) {
        return registrationService.updateRegistration(registration);
    }

}
