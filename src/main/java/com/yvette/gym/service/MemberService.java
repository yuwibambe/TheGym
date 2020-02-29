package com.yvette.gym.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yvette.gym.domain.Member;
import com.yvette.gym.repository.IMemberRepository;

@Service
public class MemberService {

	@Autowired
	private IMemberRepository iMemberRepository;
	
	public Member saveMember(Member member) {
		Member savedMember = null;
		
		Member existingMember = iMemberRepository.findByUsername(member.getUsername());
		
		if(existingMember!=null) {
			BeanUtils.copyProperties(existingMember, member);
			savedMember = iMemberRepository.save(existingMember);
		}
		
		savedMember = iMemberRepository.save(member);
		
		return savedMember;
	}
	
	public Member getMember(String username) {
		Member member = iMemberRepository.findByUsername(username);
		
		return member;
	}
}
