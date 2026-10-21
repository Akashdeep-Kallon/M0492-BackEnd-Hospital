package com.hospital.hospital;

import org.hibernate.internal.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface NurseRepository extends CrudRepository <Nurse, Integer> {
	Optional<Nurse> findByUserAndPassword(String user, String password);
}