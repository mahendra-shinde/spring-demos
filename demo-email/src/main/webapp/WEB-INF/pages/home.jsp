<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
<h2 style="color:green">${param.msg }</h2>

<h2>Spring MVC Email Example</h2>
            <form id="emailFrm" method="post" action="send-email.htm" >
                <table id="emailTable" border="0" width="80%">
                    <tr>
                        <td>Email To: </td>
                        <td><input id="receiver" type="text" name="mailTo" size="80" /></td>
                    </tr>
                    <tr>
                        <td>Subject: </td>
                        <td><input id="subject" type="text" name="subject" size="80" /></td>
                    </tr>
                    <tr>
                        <td>Message: </td>
                        <td><textarea id="message" cols="50" rows="10" name="message"></textarea></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input id="sendBtn" type="submit" value="Send Email" /></td>
                    </tr>
                </table>
            </form>
</body>
</html>