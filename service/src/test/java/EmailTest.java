import com.ei.EnglishImproverApp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.logging.Logger;

/**
 * @author yitiansong
 * 2024/5/30
 */
@SpringBootTest(classes = {EnglishImproverApp.class})
public class EmailTest {

    private final Logger logger = Logger.getLogger(EmailTest.class.getName());
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String from;
    @Test
    public void testEmail() {
        logger.info("开始测试邮件发送");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("nihao");
        message.setFrom(from);
        message.setText("wobuhao");

        message.setTo("yitiansong4@gmail.com");
        // send 10 times
        for (int i = 0; i < 10; i++) {
            mailSender.send(message);
        }
        mailSender.send(message);
        logger.info("邮件发送成功");
    }
}
