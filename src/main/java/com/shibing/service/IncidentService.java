package com.shibing.service;

import com.shibing.entity.Incident;
import com.shibing.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Incident createIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    public Incident updateIncident(Long id, Incident incidentDetails) {
        Incident incident = incidentRepository.findById(id).orElseThrow(() -> new RuntimeException("Incident not found"));
        incident.setTitle(incidentDetails.getTitle());
        incident.setDescription(incidentDetails.getDescription());
        return incidentRepository.save(incident);
    }

    public void deleteIncident(Long id) {
        incidentRepository.deleteById(id);
    }

    public Incident getIncidentById(Long id) {
        return incidentRepository.getReferenceById(id);
    }
}
