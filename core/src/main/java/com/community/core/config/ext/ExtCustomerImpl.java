package com.community.core.config.ext;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class ExtCustomerImpl extends CustomerImpl implements ExtCustomer {
	@Autowired
	private static final long serialVersionUID = 1L;
	private JavaMailSender sender;

	@Override
	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("veerendra.surath034@gmail.com");
		message.setTo();
		message.setSubject("Thank you for choosing our domain");
		message.setText("Your order is confirmed");
		sender.send(message);
	}

}
