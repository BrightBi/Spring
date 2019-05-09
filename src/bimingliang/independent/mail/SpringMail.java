package bimingliang.independent.mail;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SpringMail {
	
	private static final String from = "826975475@qq.com";
	private static final String to = "Mingliang.Bi@activenetwork.com";
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	// 发送简单邮件
	public void sendSimpleMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject("Test");
		message.setText("For test!");
		javaMailSender.send(message);
	}
	
	// 发送带有附件邮件
	public void sendMimeMail() {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper;
		try {
			messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(from);
			messageHelper.setTo(to);
			messageHelper.setSubject("Test");
			messageHelper.setText("For 谢谢");
			FileSystemResource doc = new FileSystemResource("/opt/测试.txt");
			// 使用MimeUtility.encodeWord()解决附件中文名乱码问题
			messageHelper.addAttachment(MimeUtility.encodeWord("测试.txt"), doc);
			javaMailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 发送HTML邮件
	public void sendHtmlMail() {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper;
		String html = "<html><head></head><body><h1>Hello 你好</h1><img src='cid:touxiang'></body></html>";
		try {
			messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(from);
			messageHelper.setTo(to);
			messageHelper.setSubject("Test");
			messageHelper.setText(html, true);
			ClassPathResource img = new ClassPathResource("touxiang.jpg");
			// addInline()第一个参数要与<img src='cid:touxiang'>中src指向的标识符一致
			messageHelper.addInline("touxiang", img);
			javaMailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
}
