package cn.lzumi.myfavoriteanime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.commons.codec.digest.DigestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyfavoriteanimeApplicationTests {

    @Test
    public void contextLoads() {
        String s = DigestUtils.md5Hex("abc");
        System.out.println(s);
    }

}
