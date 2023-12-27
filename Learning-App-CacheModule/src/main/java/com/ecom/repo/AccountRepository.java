package com.ecom.repo;

import com.ecom.pojo.CurrencyTrade;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<CurrencyTrade,String> {
}
