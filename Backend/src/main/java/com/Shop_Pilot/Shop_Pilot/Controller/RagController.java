package com.Shop_Pilot.Shop_Pilot.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shop_Pilot.Shop_Pilot.Service.RagService;
import com.Shop_Pilot.Shop_Pilot.models.Rag;

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
