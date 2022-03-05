package com.function.functiontest.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.function.functiontest.domain.MemberRepository;

class MemberServiceTest {
	@MockBean
	private MemberService memberService;

	private final MemberRepository memberRepository = mock(MemberRepository.class);

	@BeforeEach
	void stubbing() {
		// Mocking할 메서드 : memberRepository.existsByEmail
		// Param : any(String.class)
		// 반환 값 : willReturn(false)
		given(memberRepository.existsByEmail(any(String.class)))
			.willReturn(false);
		// when(memberRepository.co)
	}

}