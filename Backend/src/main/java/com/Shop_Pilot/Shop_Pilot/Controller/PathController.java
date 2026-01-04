package com.Shop_Pilot.Shop_Pilot.Controller;

import java.util.List;
import java.util.Map;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
=======
>>>>>>> 47dceb3195e302200452e27fca3fa60c95fb6d3a
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shop_Pilot.Shop_Pilot.Service.PathService;

<<<<<<< HEAD
@CrossOrigin(origins = "http://localhost:3000") 
=======
>>>>>>> 47dceb3195e302200452e27fca3fa60c95fb6d3a
@RestController
@RequestMapping("/api/path")
public class PathController {

    private final PathService pathService;

    public PathController(PathService pathService) {
        this.pathService = pathService;
    }

    @GetMapping   // GET /api/path
    public String home() {
        return "Shop Pilot API is running!";
    }

    @PostMapping  // POST /api/path
    public Map<String, Object> getShortestPath(@RequestBody List<String> items) {
        List<String> path = pathService.findShortestPath(items);
        return Map.of(
            "requestedItems", items,
            "shortestPath", path
        );
    }
}
