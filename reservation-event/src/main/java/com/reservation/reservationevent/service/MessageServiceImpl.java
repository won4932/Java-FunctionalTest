package com.reservation.reservationevent.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.nkia.lucida.doms.common.service.MessageService;

import lombok.RequiredArgsConstructor;

@Component
@Aspect
@RequiredArgsConstructor
// @AllArgsConstructor
public class MessageServiceImpl implements MessageService {

	private final SimpMessagingTemplate simpMessagingTemplate;

	@Override
	public void afterReturning(JoinPoint joinPoint) {

	}

	// @Override
	// @AfterReturning(pointcut = "execution(* com.nkia.lucida.doms.standalone.service.TestService.update(..))")
	// public void afterReturning(JoinPoint joinPoint) {
	// 	System.out.println("After Returning!!!!!");
	//
	// 	Object[] args = joinPoint.getArgs();
	//
	// 	// System.out.println(args[0].toString());
	//
	// 	Map<String, Object> paramMap = new HashMap<>();
	//
	// 	Method method = ((org.aspectj.lang.reflect.MethodSignature) joinPoint.getSignature()).getMethod();
	//
	// 	String[] parameterNames = new org.springframework.core.StandardReflectionParameterNameDiscoverer().getParameterNames(method);
	//
	// 	for(int i=0; i<args.length; i++) {
	// 		paramMap.put(parameterNames[i], args[i]);
	// 	}
	//
	// 	System.out.println(paramMap.get("param"));
	//
	// 	// for(int i = 0; i<args.length; i++) {
	// 	// 	paramMap.put(args[i], "args" + i);
	// 	// }
	//
	// 	// System.out.println(paramMap.get("param"));
	//
	// 	System.out.println(Arrays.stream(joinPoint.getArgs()).findFirst().get());
	//
	// 	// System.out.println(Arrays.stream(joinPoint.getArgs()).collect(Collectors.toList()).stream().collect(Collectors.toMap(i -> i, e-> e)));
	//
	// 	// Map<String, String> param = Arrays
	// 	// 	.stream(joinPoint.getArgs().)
	// 	// 	.collect(Collectors.toMap()
	//
	// 	// System.out.println(joinPoint.getSignature().getClass().getPa);
	// 	simpMessagingTemplate.convertAndSend("/subscribe/sendMessage/member", "Approve Messaging...");
	// }

	@Override
	@AfterReturning(pointcut = "execution(* com.nkia.lucida.doms.standalone.service.TestService.create(..))")
	public void createMessaging() {
		simpMessagingTemplate.convertAndSend("/subscribe/sendMessage/member", "Inject Messaging...");
	}
}
