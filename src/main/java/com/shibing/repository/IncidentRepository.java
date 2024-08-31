package com.shibing.repository;

import com.shibing.model.Incident;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface IncidentRepository extends BaseRepository<Incident>{
}
