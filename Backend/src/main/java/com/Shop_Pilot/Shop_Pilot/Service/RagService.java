package com.Shop_Pilot.Shop_Pilot.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Shop_Pilot.Shop_Pilot.Repositories.RagRepository;
import com.Shop_Pilot.Shop_Pilot.models.Rag;

@Service
@Transactional(readOnly = true)
public class RagService {

    private final RagRepository ragRepository;

    public RagService(RagRepository ragRepository) {
        this.ragRepository = ragRepository;
    }

    public List<Rag> findAllRags() {
        return ragRepository.findAllByOrderByPosition();
    }
}
