package de.tum.in.www1.artemis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.tum.in.www1.artemis.domain.Participation;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {
}
