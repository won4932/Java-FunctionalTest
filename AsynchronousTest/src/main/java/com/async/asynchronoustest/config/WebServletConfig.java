package com.async.asynchronoustest.config;

import java.io.IOException;

// @WebServlet(urlPatterns = {"/async"}, asyncSupported = true)
// public class WebServletConfig extends HttpServlet {
//
// 	@Override
// 	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 		System.out.println("################ deGet Start !");
// 		final AsyncContext asyncContext = req.startAsync(req, resp);
//
// 		asyncContext.setTimeout(5000);
// 		asyncContext.addListener(new AsyncListener() {
// 			@Override
// 			public void onComplete(AsyncEvent event) throws IOException {
// 				System.out.println("Event Complete: " + event);
// 			}
//
// 			@Override
// 			public void onTimeout(AsyncEvent event) throws IOException {
// 				System.out.println("Event Timeout : " + event);
// 			}
//
// 			@Override
// 			public void onError(AsyncEvent event) throws IOException {
// 				System.out.println("Event Error : " + event);
// 			}
//
// 			@Override
// 			public void onStartAsync(AsyncEvent event) throws IOException {
// 				System.out.println("Event Start : " + event);
// 			}
// 		});
//
// 		asyncContext.start(() -> System.out.println("lambda"));
//
// 		try{
// 			Thread.sleep(3000);
// 		}catch (InterruptedException e) {
// 			e.printStackTrace();
// 		}
//
// 		asyncContext.complete();
// 	}
//
// 	@Override
// 	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 		super.doPost(req, resp);
// 	}
// }
