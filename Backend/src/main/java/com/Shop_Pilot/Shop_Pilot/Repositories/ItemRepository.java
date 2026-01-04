package com.Shop_Pilot.Shop_Pilot.Repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Shop_Pilot.Shop_Pilot.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

    // Fetch items whose names start with the given prefix (case-insensitive)
    List<Item> findByNameStartingWithIgnoreCase(String prefix);

    // Existing methods...
    List<Item> findByNameIn(Collection<String> names);

    @Query("SELECT i FROM Item i WHERE LOWER(i.name) IN :names")
    List<Item> findByNameInIgnoreCase(@Param("names") Collection<String> lowerNames);

    List<Item> findByNameContainingIgnoreCase(String name);
}
