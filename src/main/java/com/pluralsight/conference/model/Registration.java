package com.pluralsight.conference.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "REGISTRATION")
@NamedQueries({
        @NamedQuery(name = Registration.REGISTRATION_REPORT, query = Registration.REGISTRATION_REPORT_JPQL)
})
public class Registration {

    public static final String REGISTRATION_REPORT = "Registration.getRegistrationReports";
    public static final String REGISTRATION_REPORT_JPQL = "SELECT new com.pluralsight.conference.model.RegistrationReport" +
            "(r.name, c.name, c.description) FROM Registration r, Course c " +
            "WHERE r.id = c.registration.id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "registration", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();

}
