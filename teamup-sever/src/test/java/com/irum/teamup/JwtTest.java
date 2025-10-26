package com.irum.teamup;

import com.irum.teamup.config.JwtProperties;
import com.irum.teamup.utils.JwtTool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class JwtTest {

    @Autowired
    private JwtTool jwtTool;

    @Autowired
    private JwtProperties jwtProperties;

    @Test
    public void createJwtTest() {

        String token = jwtTool.createToken(1L, jwtProperties.getTokenTTL());
        System.out.println(token);
    }

    @Test
    public void parseJwtTest() {

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyIjoxLCJleHAiOjE3NjE0NjQ2NTd9.av8UDXg6YnJcKj9hbpaXUOOo4e5H4A_UvpQ0a76rmk48XbHswfpPmllIOeeDSlgXK6Ny7Sbut6pwHh6CTHrvPnVvq1LpyZx-ue9aYJGJWJC5U6B8zb2ZFxsB-R4tVly-Fzs-H50pf7zGYIrLIZlTFViqZEfEjf8FvVvQEkU-3hLyeUlvoR33GTw6MoRCosc2-DRdMkHV44Ua_NLgEfY6I_0_rS1tRU9EO3mpXhNx7GVts5WWjuZHv8cdbvqW2uSHvC8fZMNlbqicR2pvIRkToaTYQ-t-OpWdlFexIcme_o-aTJRPTXa_t2k7q-MbyGIZWlY0gc9Mj3Z4sRpPJayypQ";

        Long userId = jwtTool.parseToken(token);
        System.out.println(userId);

    }


}
