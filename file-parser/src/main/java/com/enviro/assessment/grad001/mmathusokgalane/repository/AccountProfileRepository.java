package com.enviro.assessment.grad001.mmathusokgalane.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountProfileRepository extends JpaRepository<AccountProfile, Long> {
    AccountProfile findByNameAndSurname(String name, String surname);
}