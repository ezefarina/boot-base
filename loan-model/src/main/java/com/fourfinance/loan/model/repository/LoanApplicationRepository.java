package com.fourfinance.loan.model.repository;

import com.fourfinance.loan.model.entity.LoanApplication;
import org.joda.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long>, BaseRepository {

  @Query("select a from LoanApplication a where ip=:ip and datetime between :start and :end")
  List<LoanApplication> findByIpAndDatetimeToday(@Param("ip") String ip, @Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

}
