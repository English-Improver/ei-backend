import com.ei.mapper.user.EIUserMapper;
import org.junit.jupiter.api.Test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class MainServiceImplTest {
   private EIUserMapper userMapper;

//    测试mybatis plus
    @Test
    public void test() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "12345";
        String encode = passwordEncoder.encode(password);
        System.out.println(encode);
    }
}
