package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findByStockCodeAndStockDateBetween(String stockCode, LocalDate startDate, LocalDate endDate);

    List<Stock> findByStockCodeAndStockCloseGreaterThan(String stockCode, BigDecimal stockClose);

    List<Stock> findTop3ByOrderByStockVolumeDesc();

    List<Stock> findTop3ByStockCodeOrderByStockCloseAsc(String stockCode);

}
