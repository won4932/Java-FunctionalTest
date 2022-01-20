package com.function.functiontest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.function.functiontest.domain.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	@Autowired
	private final MemberRepository memberRepository;

	public boolean isExistEmail(String email) {
		return memberRepository.existsByEmail(email);
	}
}
