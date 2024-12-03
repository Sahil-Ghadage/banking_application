package com.sahilg.banking.loans.repository;

import com.sahilg.banking.loans.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoansRepository extends JpaRepository<Loans,Long> {

    Optional<Loans> findByMobileNumber(String mobileNumber);

    Optional<Loans> findByLoanNumber(String loanNumber);
}