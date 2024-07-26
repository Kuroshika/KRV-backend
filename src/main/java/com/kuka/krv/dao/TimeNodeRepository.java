package com.kuka.krv.dao;

import com.kuka.krv.entity.TimeNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeNodeRepository extends JpaRepository<TimeNode, Long> {
    List<TimeNode> findAllBySubId(Long subId);
}
