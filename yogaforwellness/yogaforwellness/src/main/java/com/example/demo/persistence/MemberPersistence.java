package com.example.demo.persistence;

import org.springframework.stereotype.Component;

import com.example.demo.model.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Component
public class MemberPersistence {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    public Member getMemberFromUserName(String userName){
        String query1 = "SELECT m FROM Member m JOIN MemberAuth ma on m.id = ma.memberId WHERE ma.username = :username";
        TypedQuery<Member> query = entityManager.createQuery(query1, Member.class);
        query.setParameter("username", userName);

        return query.getResultStream().findFirst().orElse(null);



    }

}
