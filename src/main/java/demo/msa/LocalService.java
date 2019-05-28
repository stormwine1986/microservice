package demo.msa;

import org.springframework.stereotype.Service;

@Service
public class LocalService implements ILocalService {

	@Override
	public Result cal(int a, int b) {
		Result result = new Result();
		result.setAdd(a + b);
		result.setMux(a * b);
		return result;
	}

}
