package com.Shop_Pilot.Shop_Pilot.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Shop_Pilot.Shop_Pilot.models.Rag;

public interface RagRepository extends JpaRepository<Rag, Long> {
    List<Rag> findAllByOrderByPosition();
}
