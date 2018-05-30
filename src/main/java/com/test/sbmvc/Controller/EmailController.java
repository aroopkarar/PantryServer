package com.test.sbmvc.Controller;

import com.test.sbmvc.Service.EmailServiceImpl;
import com.test.sbmvc.Service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class EmailController{

    @Bean
    public  SimpleMailMessage templateSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(
                "This is the test email template for your email:\n%s\n");
        return message;
    }

    @Autowired
    public SimpleMailMessage template;

    @Autowired
    EmailServiceImpl mailservice;

    @Autowired
    UtilService utilService;

    @ResponseBody
    @RequestMapping("/sendmail")
    public void sendmail(@RequestParam("to") String to,@RequestParam(value="subject", defaultValue="hi") String subject)
    {
        //String text = template.getText().toString();
        String passwordText= String.valueOf(utilService.geek_Password(8));
        System.out.println("passwordText= "+passwordText);
        String otpText=String.valueOf(utilService.OTP(4));
        System.out.println("otpText= "+otpText);
        mailservice.sendSimpleMessage(to, subject, passwordText+" "+otpText);
        //utilService.sendMessage();
        String pathToAttachment = "cc";
        //mailservice.sendMessageWithAttachment(to, subject, text, pathToAttachment);
    }

    @ResponseBody
    @RequestMapping("/createJWT")
    public String createJWT(HttpServletRequest request, HttpServletResponse response)
    {
        return utilService.createJWT(null);
    }

}
