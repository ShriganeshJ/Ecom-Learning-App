package com.ecom.repo;

import com.ecom.pojo.AccountDataResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<AccountDataResponse,String> {
}
