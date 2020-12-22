package com.moneylion.usermanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

public interface UserRepository extends JpaRepository<User, Long> {
     @Query("SELECT t.enable FROM User t WHERE t.email = ?1 AND t.featureName = ?2")
     String findEnableByEmailAndFeatureName(String email, String featureName);

    @Transactional
  @Modifying
    @Query("UPDATE User u set u.enable = ?1 where u.email = ?2 AND u.featureName = ?3")
    void updateByEmailAndFeatureName(boolean enable, String email, String featureName);
}