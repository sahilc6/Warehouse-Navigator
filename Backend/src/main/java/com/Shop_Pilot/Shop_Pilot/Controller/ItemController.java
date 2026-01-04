package com.Shop_Pilot.Shop_Pilot.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
=======
>>>>>>> 47dceb3195e302200452e27fca3fa60c95fb6d3a
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Shop_Pilot.Shop_Pilot.Repositories.ItemRepository;
import com.Shop_Pilot.Shop_Pilot.models.Item;

<<<<<<< HEAD
@CrossOrigin(origins = "http://localhost:3000")   // <-- add this
=======
>>>>>>> 47dceb3195e302200452e27fca3fa60c95fb6d3a
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/search")
    public List<Map<String, String>> searchItems(@RequestParam String q) {
        List<Item> items = itemRepository.findByNameStartingWithIgnoreCase(q);
        return items.stream()
<<<<<<< HEAD
                .map(item -> Map.of("name", item.getName()))
                .collect(Collectors.toList());
=======
            .map(item -> Map.of("name", item.getName()))
            .collect(Collectors.toList());
>>>>>>> 47dceb3195e302200452e27fca3fa60c95fb6d3a
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
