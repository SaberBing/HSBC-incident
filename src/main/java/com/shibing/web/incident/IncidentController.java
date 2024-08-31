package com.shibing.web.incident;

import com.shibing.model.Incident;
import com.shibing.repository.IncidentRepository;
import com.shibing.to.IncidentTo;
import com.shibing.util.IncidentUtil;
import com.shibing.util.validation.ValidationUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = IncidentController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@CacheConfig(cacheNames = {"incidents","incident"})
@AllArgsConstructor
public class IncidentController {
    static final String REST_URL = "/api/incident";

    IncidentRepository repository;

    @GetMapping("/{id}")
    @Cacheable(value = "incident", key = "#id")
    @Operation(summary = "Get incident")
    public IncidentTo get(@PathVariable int id) {
        log.info("Get incident{} ", id);
        return IncidentUtil.createTo(repository.findById(id).orElseThrow(ValidationUtil.notFound("incident not found")));
    }


    @Cacheable("incidents")
    @GetMapping
    @Operation(summary = "Get all incidents")
    public List<IncidentTo> getAll() {
        log.info("Get all incidents");
        return IncidentUtil.getTos(repository.findAll(Sort.by(Sort.Direction.ASC, "title", "id")));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(allEntries = true)
    @Operation(summary = "Delete an incident by its id")
    public void delete(@PathVariable int id) {
        repository.deleteExisted(id);
    }

    @Transactional
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(allEntries = true)
    @Operation(summary = "Update an incident")
    public void update(@Valid @RequestBody IncidentTo incidentTo, @PathVariable int id) {
        log.info("Update {} for incident {}", incidentTo, id);
        ValidationUtil.assureIdConsistent(incidentTo, id);
        Incident updateRest = repository.findById(id).orElseThrow(ValidationUtil.notFound("No incident found for update"));
        repository.save(IncidentUtil.updateFromTo(updateRest, incidentTo));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @CacheEvict(allEntries = true)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create an incident")
    public ResponseEntity<Incident> create(@Valid @RequestBody IncidentTo incidentTo) {
        log.info("create {}", incidentTo);
        ValidationUtil.checkNew(incidentTo);
        Incident incident = IncidentUtil.createNewFromTo(incidentTo);
        Incident created = repository.save(incident);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                                                          .path(REST_URL + "/{id}")
                                                          .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
