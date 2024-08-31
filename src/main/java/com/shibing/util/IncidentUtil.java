package com.shibing.util;

import com.shibing.model.Incident;
import com.shibing.to.IncidentTo;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class IncidentUtil {

    public static List<IncidentTo> getTos(Collection<Incident> incident) {
        return incident.stream()
                         .map(IncidentUtil::createTo)
                         .collect(Collectors.toList());
    }

    public static IncidentTo createTo(Incident incident) {
        return new IncidentTo(incident.getId(), incident.getLocalDate(), incident.getDescription(), incident.getTitle());
    }

    public static Incident createNewFromTo(IncidentTo incidentTo) {
        return new Incident(null, incidentTo.getTitle(), incidentTo.getDescription(), incidentTo.getLocalDate());
    }

    public static Incident updateFromTo(Incident incident, IncidentTo incidentTo) {
        incident.setTitle(incidentTo.getTitle());
        incident.setDescription(incidentTo.getDescription());
        return incident;
    }
}
