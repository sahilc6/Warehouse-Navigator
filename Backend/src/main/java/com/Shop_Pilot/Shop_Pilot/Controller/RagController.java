package com.Shop_Pilot.Shop_Pilot.Controller;

import java.util.List;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
=======
>>>>>>> 47dceb3195e302200452e27fca3fa60c95fb6d3a
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shop_Pilot.Shop_Pilot.Service.RagService;
import com.Shop_Pilot.Shop_Pilot.models.Rag;

<<<<<<< HEAD
@CrossOrigin(origins = "http://localhost:3000") 
=======
>>>>>>> 47dceb3195e302200452e27fca3fa60c95fb6d3a
@RestController
@RequestMapping("/api/rags")
public class RagController {

    private final RagService ragService;

    public RagController(RagService ragService) {
        this.ragService = ragService;
    }

    @GetMapping  // GET /api/rags
    public List<Rag> getAllRags() {
        return ragService.findAllRags();
    }
}
