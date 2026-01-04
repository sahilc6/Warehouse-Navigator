package com.Shop_Pilot.Shop_Pilot.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Shop_Pilot.Shop_Pilot.Repositories.ItemRepository;
import com.Shop_Pilot.Shop_Pilot.models.Item;


@CrossOrigin(origins = "http://localhost:3000")   // <-- add this

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
                .map(item -> Map.of("name", item.getName()))
                .collect(Collectors.toList());

    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
