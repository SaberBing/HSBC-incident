package com.shibing.web.incident;

import com.shibing.model.Incident;
import com.shibing.to.IncidentTo;
import com.shibing.util.IncidentUtil;

import java.time.LocalDate;
import java.util.List;


public class IncidentTestData {

    public static final MatcherFactory.Matcher<Incident> INCIDENT_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Incident.class, "title", "description");
    public static final MatcherFactory.Matcher<IncidentTo> INCIDENT_TO_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(IncidentTo.class);

    public static final int INCIDENT1_ID = 1;
    public static final int INCIDENT2_ID = 2;
    public static final int INCIDENT3_ID = 3;

    public static final Incident incident1 = new Incident(INCIDENT1_ID, "test1", "test1 for test", LocalDate.now());
    public static final Incident incident2 = new Incident(INCIDENT2_ID, "test2", "test2 for test", LocalDate.now());
    public static final Incident incident3 = new Incident(INCIDENT3_ID, "test3", "test3 for test", LocalDate.now());
    public static final Incident incident4 = new Incident(INCIDENT1_ID + 3, "test4", "test4 for test", LocalDate.now());


    public static final List<IncidentTo> incidents = IncidentUtil.getTos(List.of(incident2, incident3, incident1, incident4));


    public static IncidentTo getNewRestaurant() {
        return new IncidentTo(null, LocalDate.now(), "it is a big test", "big test");
    }


    public static IncidentTo getUpdated() {
        return new IncidentTo(INCIDENT1_ID, LocalDate.now(), "it is a big test", "big test");
    }

}

