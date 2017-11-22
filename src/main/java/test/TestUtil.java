package test;

import org.junit.jupiter.api.Test;
import ssh.product.util.logger.LogUtil;

public class TestUtil {

    @Test
    public void logTest(){
        LogUtil.info("测试");
    }

   /* @BeforeClass
    public static void before() {

        System.out.println("全局测试开始");
    }

    @AfterClass
    public static void after() {
        System.out.println("全局测试结束");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("开始一个测试");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("结束一个测试");
    }
*/
}
