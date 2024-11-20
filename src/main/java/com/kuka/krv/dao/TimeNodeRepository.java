package com.kuka.krv.dao;

import com.kuka.krv.entity.TimeNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TimeNodeRepository extends JpaRepository<TimeNode, Long> {
    List<TimeNode> findAllBySubId(Long subId);

    @Modifying
    @Transactional
    @Query("DELETE FROM TimeNode t WHERE t.subId = :subId")
    int deleteUsersBySubId(Long subId);
}
