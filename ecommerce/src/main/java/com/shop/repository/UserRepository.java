package com.shop.repository;

import com.shop.domain.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE UserEntity u SET u.enabled = false WHERE u.id = :id")
    void softDeleteById(Long id);

    List<UserEntity> findAllByEnabledTrue();

    Optional<UserEntity> findById(Integer userId);
    Optional<UserEntity> findByEmailAndEnabledIsTrue(String email);
    Optional<UserEntity> findByEmail(String email);
}
