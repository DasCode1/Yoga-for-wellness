// src/main/java/com/example/demo/service/MemberService.java

package com.example.demo.service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Member;
import com.example.demo.persistence.MemberPersistence;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.Exception.PasswordMisMatchException;
import com.example.demo.service.Exception.UserNameNotFoundException;
import com.example.demo.util.JwtToken;

import jakarta.transaction.Transactional;


@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberPersistence memberPersistence;


    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    @Transactional
    public Member createMember(Member member) {
       // System.out.println(member.getMemberAuth().getUsername());
       
        memberRepository.save(member);
        if(member.getMemberAuth().getMemberId()==null){
            member.getMemberAuth().setMemberId(member.getId());
       }
       return member;

    }

    public Member updateMember(Long id, Member memberDetails) {
        Member member = memberRepository.findById(id).orElseThrow();
        member.setName(memberDetails.getName());
        member.setEmail(memberDetails.getEmail());
        member.setPhone(memberDetails.getPhone());
        return memberRepository.save(member);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
    public String login(String userName, String password) throws UserNameNotFoundException,PasswordMisMatchException{
        String token = "";
        // TODO Auto-generated method stub
        if(validateCredentials(userName,password)){
                    JwtToken jwtToken = new JwtToken();
                    token = jwtToken.generateToken(userName);
                }

                return token;
               
            }

        
            private boolean validateCredentials(String userName, String password) throws UserNameNotFoundException,PasswordMisMatchException{
                Member user=memberPersistence.getMemberFromUserName(userName);

                if(user!=null){
                    Member currentUser = user;
                    byte[] login_password = Base64.getEncoder().encode(password.getBytes());
                    if(Arrays.equals(login_password,currentUser.getMemberAuth().getEncodedPassword())){
                        return true;
                    }else{
                        throw new PasswordMisMatchException();
                    }
                } else{
                    throw new UserNameNotFoundException();
                }
              




            }

    }
