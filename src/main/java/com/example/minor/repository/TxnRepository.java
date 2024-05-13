package com.example.minor.repository;

import com.example.minor.models.Txn;
import com.example.minor.models.TxnStatus;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TxnRepository extends JpaRepository<Txn,Integer> {

    public Txn findByStudent_ContactAndBook_BookNoAndTxnStatusOrderByCreatedOnDesc(String studentContact,
                                                                                   String bookNo,
                                                                                   TxnStatus status);
    @Transactional
    @Modifying
    @Query(value="update txn set created_on=\"2024-06-13 01:21:00.994000\" where id=2" ,nativeQuery = true)
    public void updateTxnCreatedOn();

}
