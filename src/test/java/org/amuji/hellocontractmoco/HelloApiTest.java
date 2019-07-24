package org.amuji.hellocontractmoco;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloApiTest extends ApiTestBase {

    @Test
    public void request_hello_should_response_the_sentence() {
        assertContract();
    }
}
