package bimingliang.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SendMessageServiceImplement implements SendMessageService {

	private JmsTemplate jmsTemplate;
	
	@Override
	public void sendMessage(String destination, final String message) {
		// JmsTemplate的send方法可以传一个目的地的字符串，表示将消息发送到这个目的地
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException{
				return session.createObjectMessage(message);
			}
		});
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
}
