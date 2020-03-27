//package com.xiaowu.aysnlog.config;//package com.xiaowu.aysnlog.config;
////
////import com.xiaowu.aysnlog.entity.Email;
////import org.springframework.beans.factory.annotation.Value;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.mail.SimpleMailMessage;
////import org.springframework.mail.javamail.JavaMailSenderImpl;
////
////import java.util.Properties;
////
////@Configuration
////public class EmailConfig {
////    @Value("${stmp.host}")
////    private String host;
////    @Value("${stmp.account}")
////    private String account;
////    @Value("${stmp.password}")
////    private String password;
////
////    @Value("${mail.smtp.auth}")
////    private String isAuth;
////    @Value("${mail.smtp.timeout}")
////    private String outTime;
////
////    @Bean(name = "JavaMailSenderImpl")
////    public JavaMailSenderImpl getMailSender() {
////        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
////        javaMailSender.setHost(host);
////        javaMailSender.setUsername(account);
////        javaMailSender.setPassword(password);
////        Properties properties = new Properties();
////        properties.put("mail.smtp.auth", isAuth);
////        properties.put("mail.smtp.timeout", outTime);
////        javaMailSender.setJavaMailProperties(properties);
////        return javaMailSender;
////    }
////
////    public void sendSimpleMail(Email email) {
////        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
////        simpleMailMessage.setFrom(account);
////        String receiver = email.getReceiver();
////        String receivers[] = receiver.split(";");
////        simpleMailMessage.setTo(receivers);
////        simpleMailMessage.setSubject(email.getSubject());
////        simpleMailMessage.setText(email.getContent());
////        getMailSender().send(simpleMailMessage);
////    }
////}
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
//import java.util.Properties;
//
//@Configuration
//@PropertySource(value = {"classpath:application.yaml"})
//public class EmailConfig {
//    @Autowired
//    private Environment env;
//
//    @Bean(name = "mailSender")
//    public JavaMailSender mailSender() {
//        // 创建邮件发送器, 主要提供了邮件发送接口、透明创建Java Mail的MimeMessage、及邮件发送的配置
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        // 如果为普通邮箱, 非ssl认证等
//        mailSender.setHost(env.getProperty("mail.host").trim());
//        mailSender.setPort(Integer.parseInt(env.getProperty("mail.port").trim()));
//        mailSender.setUsername(env.getProperty("mail.username").trim());
//        mailSender.setPassword(env.getProperty("mail.password").trim());
//        mailSender.setDefaultEncoding("utf-8");
//        // 配置邮件服务器
//        Properties props = new Properties();
//        // 让服务器进行认证,认证用户名和密码是否正确
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.timeout", "25000");
//        mailSender.setJavaMailProperties(props);
//        return mailSender;
//    }
//}