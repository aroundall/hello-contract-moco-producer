package org.amuji;

import com.github.macdao.moscow.ContractAssertion;
import com.github.macdao.moscow.ContractContainer;
import com.github.macdao.moscow.property.PropertyResolverProvider;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import java.nio.file.Paths;
import java.util.Map;

public class ApiTestBase {
    private static final ContractContainer CONTAINER = new ContractContainer(Paths.get("src/test/resources/contracts"));
    @Rule
    public final TestName name = new TestName();
    @Value("${local.server.port}")
    protected int port;
    @Autowired
    private Environment environment;

    protected Map<String, String> assertContract() {
        return assertContract(name.getMethodName());
    }

    protected Map<String, String> assertContract(String description) {
        return new ContractAssertion(CONTAINER.findContracts(description))
                .setPort(port)
                .setExecutionTimeout(2000)
                .withPropertyProvider(new PropertyResolverProvider(environment))
                .assertContract();
    }
}
