package com.business.card.appcapability;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BusinessCardDataRepository extends MongoRepository<BusinessCardData, String> {
    @Query("{'owner_id': ?0,'status': ?1}")
    public List<BusinessCardData> getByOwnerIdAndStaus(String owner_id, String status);
    @Query("{'card_id': ?0}")
    public BusinessCardData findByCardId(String card_id);
}
