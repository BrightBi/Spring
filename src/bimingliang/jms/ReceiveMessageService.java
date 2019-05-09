package bimingliang.jms;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.springframework.jms.core.JmsTemplate;

public class ReceiveMessageService {
	
	private JmsTemplate jmsTemplate;
	
	public String receiveMessage(String destination) {
		String result = "";
		ObjectMessage objectMessage = null;
		/*
		 * JmsTemplate的receive方法可以传一个目的地的字符串，
		 * 表示从这个目的地取消息
		 */
		objectMessage = (ObjectMessage) jmsTemplate.receive(destination);
		try {
			result = (String) objectMessage.getObject();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return result;
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
}
