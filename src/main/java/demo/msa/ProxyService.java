package demo.msa;

import org.springframework.stereotype.Service;

@Service
public class ProxyService implements IProxyService {

	@Override
	public Result cal(int a, int b) {
		throw new RuntimeException("");
	}

}
