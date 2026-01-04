package com.Shop_Pilot.Shop_Pilot.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Shop_Pilot.Shop_Pilot.Repositories.ItemRepository;
import com.Shop_Pilot.Shop_Pilot.Repositories.RagRepository;
import com.Shop_Pilot.Shop_Pilot.models.Item;

@Service
public class PathService {

    private final RagRepository ragRepo;
    private final ItemRepository itemRepo;

    public PathService(RagRepository ragRepo, ItemRepository itemRepo) {
        this.ragRepo = ragRepo;
        this.itemRepo = itemRepo;
    }

    public List<String> findShortestPath(List<String> requestedItems) {
        if (requestedItems == null || requestedItems.isEmpty()) {
            return List.of();
        }

        // Convert requested items to lowercase for case-insensitive match
        List<String> lowerNames = requestedItems.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        // Fetch items that match requested names
        List<Item> foundItems = itemRepo.findByNameInIgnoreCase(lowerNames);

        // Collect unique racks with items and sort them by rack position
        List<String> racksInOrder = foundItems.stream()
                .map(Item::getRag)
                .distinct()
                .sorted(Comparator.comparingInt(rag -> rag.getPosition()))
                .map(rag -> rag.getName())
                .collect(Collectors.toList());

        return racksInOrder;
    }
}
