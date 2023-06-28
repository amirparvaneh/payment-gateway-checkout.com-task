package com.checkout.paymentgateway.repository;

import com.checkout.paymentgateway.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepo extends JpaRepository<Request, Long> {

    @Query("select re from Request re where re.shopper = :shopperId")
    Request findRequestByShopper(@Param("shopperId")Long shopperId);
}
