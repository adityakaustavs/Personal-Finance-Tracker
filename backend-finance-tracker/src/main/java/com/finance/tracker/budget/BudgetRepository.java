package com.finance.tracker.budget;
import java.util.*; import org.springframework.data.jpa.repository.JpaRepository;
public interface BudgetRepository extends JpaRepository<Budget,Long> { List<Budget> findByUserIdAndMonthAndYearOrderByCategory(Long userId,int month,int year); Optional<Budget> findByUserIdAndCategoryIgnoreCaseAndMonthAndYear(Long userId,String category,int month,int year); Optional<Budget> findByIdAndUserId(Long id,Long userId); }
