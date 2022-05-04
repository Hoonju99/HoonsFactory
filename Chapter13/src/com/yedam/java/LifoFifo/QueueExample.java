package com.yedam.java.LifoFifo;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<Message>();
	
		messageQueue.offer(new Message("sendMail", "홍길동"));
		messageQueue.offer(new Message("sendSMS", "신용권"));
		messageQueue.offer(new Message("sendkakaotalk", "홍두께"));
		
		while(!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch(message.command) {
			case "sendMail":
				System.out.println(message.to + " 님에게 메일을 보냈습니다.");
				break;
			case "sendSMS":
				System.out.println(message.to + " 님에게 SMS을 보냈습니다.");
				break;
			case "sendkakaotalk":
				System.out.println(message.to + " 님에게 카카오톡을 보냈습니다.");
				break;
				
			}
		}
		
	}

}
