package demo.msa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteService implements IRemoteService {
	
	@Autowired
	private IProxyService proxy; 
	
	@Autowired
	private ILocalService localService;

	@Override
	public int cal(int a, int b) {
		System.out.println("a = " + a + ", b = " + b);
		Result cal = proxy.cal(a, b);
		Result cal2 = localService.cal(a, b);
		
		return cal2.getAdd() + cal.getAdd() + cal2.getMux() + cal2.getMux();
	}

	public void setProxy(IProxyService proxy) {
		this.proxy = proxy;
	}

	public void setLocalService(ILocalService localService) {
		this.localService = localService;
	}
}
