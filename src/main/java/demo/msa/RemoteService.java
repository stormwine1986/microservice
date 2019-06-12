package demo.msa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteService implements IRemoteService {
	
	
	private final IProxyService proxy; 
	
	
	private final ILocalService localService;
	
	@Autowired
	public RemoteService(IProxyService proxy, ILocalService localService) {
		this.proxy = proxy;
		this.localService = localService;
	}

	@Override
	public int cal(int a, int b) {
		System.out.println("a = " + a + ", b = " + b);
		Result cal = proxy.cal(a, b);
		Result cal2 = localService.cal(a, b);
		
		return cal2.getAdd() + cal.getAdd() + cal2.getMux() + cal2.getMux();
	}
}
