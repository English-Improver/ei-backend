import com.ei.EnglishImproverApp;
import com.ei.controller.LoginController;
import com.ei.service.user.LoginService;
import com.ei.util.JWTUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = EnglishImproverApp.class)
public class LoginControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private LoginService loginService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testLoginSuccess() throws Exception {
        when(loginService.login(anyString(), anyString())).thenReturn(true);

        String token = JWTUtils.generateToken("user");
        String requestBody = "{\"username\":\"user\",\"password\":\"pass\"}";
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("登录成功"))
                .andExpect(jsonPath("$.data.token").value(token));
    }

    @Test
    public void testLoginFailure() throws Exception {
        when(loginService.login(anyString(), anyString())).thenReturn(false);

        String requestBody = "{\"username\":\"user\",\"password\":\"wrong\"}";
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.message").value("账号或密码错误"));
    }
}