package com.mahendra.emaildemo.controllers;

import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/** 
 * @author mahendra shinde (MahendraShinde@synergetics-india.com)
 *
 */
@Controller
@RequestMapping("/send-email.htm")
public class MailSenderController {

	@Autowired private JavaMailSender sender;
	protected String emailFromRecipient = "<your-gmail>";
	
	@PostMapping
	public String sendEmailToClient(Model model, @RequestParam("subject") String emailSubject, @RequestParam("message") String emailMessage, @RequestParam("mailTo") String emailToRecipient) {
		 

        // Logging The Email Form Parameters For Debugging Purpose
        System.out.println("\nReceipient?= " + emailToRecipient + ", Subject?= " + emailSubject + ", Message?= " + emailMessage + "\n");
 
        sender.send(new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
 
                MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");             
                mimeMsgHelperObj.setTo(emailToRecipient);
                mimeMsgHelperObj.setFrom(emailFromRecipient );               
                mimeMsgHelperObj.setText(emailMessage);
                mimeMsgHelperObj.setSubject(emailSubject);
 
             
            }
        });
        System.out.println("\nMessage Send Successfully.... Hurrey!\n");
        model.addAttribute("msg","Mail Sent!");
        return "redirect:/home.htm";
	}
}
