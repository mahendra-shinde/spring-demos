## SMTP(EMail) Integration with Spring WebMVC

Notes:
1. This demo uses GMail as SMTP Server (Provider)
2. Before you proceed, please create a new Google account and use following link to LOWER THE SECURITY and allow current application
  to send email from GMail.
  	
  	https://myaccount.google.com/lesssecureapps?pli=1
  	
  	Turn ON "Allow Less secure Apps"
  	
3. Open "WEB-INF/spring-servlet.xml" file and update SMTP Server settings
4. Open "MailSenderController.java" and update field "emailFromRecipient" 