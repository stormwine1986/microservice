package demo.msa;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class MockitoTest {
	
	@Test
	public void test() {
		RemoteService remoteService = new RemoteService();
		LocalService localService = Mockito.mock(LocalService.class);
		ProxyService proxyService = Mockito.mock(ProxyService.class);
		
		remoteService.setLocalService(localService);
		remoteService.setProxy(proxyService);
		
		Result result = new Result();
		result.setAdd(3);
		result.setMux(2);
		Mockito.when(localService.cal(1, 2)).thenReturn(result);
		
		Mockito.when(proxyService.cal(1, 2)).thenReturn(result);
		
		int cal = remoteService.cal(1, 2);
		
		System.out.println(cal);
		
		Assert.assertTrue(true);
	}
}
