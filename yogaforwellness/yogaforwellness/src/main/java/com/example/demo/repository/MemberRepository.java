// src/main/java/com/example/demo/repository/MemberRepository.java

package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Member;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByName(String name);

    List<Member> findByEmail(String email);



}