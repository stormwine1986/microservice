package demo.msa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * mockito单元测试的一般思路
 * 
 * 对被测试类的单个方法进行测试，当遇到依赖的外部资源时，对外部资源进行打桩、模拟。
 * 从而达到对该方法的逻辑正确性进行测试的目的。例如我们需要测试一个Spring @service A，
 * 他可能使用Autowired注解注入了外部的服务B，
 * 那么我可以使用Mockito的@Mock注解来对B进行Mock，使用Mockito.when(B.method())方法进行打桩，
 * 当测试程序执行到B.method()时就不再进入B中而是返回一个我们预先设定好的值或者行为。
 * 
 * @author pjia
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTest {
	
	@Autowired
	private ILocalService localService;
	
	@InjectMocks
	private IRemoteService remoteService = new RemoteService();
	
	@Mock
	private IProxyService proxy;
	
	@Mock
	private ILocalService localServiceMock;
	
	@Before
    public void setUp() {
		Result result = new Result();
		result.setMux(2);
		result.setAdd(3);
		when(proxy.cal(1, 2)).thenReturn(result);
		when(localServiceMock.cal(1, 2)).thenReturn(result);
	}
	
	@Test
	public void testLocalMethod() {
		Result cal = localService.cal(1, 2);
		assertEquals(2, cal.getMux());
		assertEquals(3, cal.getAdd());
		fail();
	}
	
	@Test
	public void testRemoteMethod() {
		int cal = remoteService.cal(1, 2);
		Assert.assertEquals(10, cal);
	}
}
