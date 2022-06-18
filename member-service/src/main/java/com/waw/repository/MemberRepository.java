package com.waw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waw.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

}
