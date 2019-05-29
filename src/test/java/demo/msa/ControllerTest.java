package demo.msa;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

	@MockBean
	private IProxyService proxy;
	
	@Autowired
	private IRemoteService remoteService;
	
	@Autowired
	protected MockMvc mockMvc;
	
	@Test
	public void testController() throws Exception {
		// # 为外部依赖的代理服务打桩
		Result result = new Result();
		result.setMux(2);
		result.setAdd(3);
		when(proxy.cal(1, 2)).thenReturn(result);
		
		// # 模拟调用
		Command uriVars = new Command();
		uriVars.setA(1);
		uriVars.setB(2);
		MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.get("/cal")
										.contentType(MediaType.APPLICATION_JSON_UTF8).param("a", "1").param("b", "2"))
										.andExpect(MockMvcResultMatchers.status().isOk())
										.andDo(MockMvcResultHandlers.print())
										.andReturn();
		
		// # 检查结果
		String contentAsString = andReturn.getResponse().getContentAsString();
		Integer resp = Integer.valueOf(contentAsString);
		assertEquals(10, resp.intValue());
		
	}
	
	@Test
	public void testRemoteMethod() {
		// # 为外部依赖的代理服务打桩
		Result result = new Result();
		result.setMux(2);
		result.setAdd(3);
		when(proxy.cal(1, 2)).thenReturn(result);
		
		int cal = remoteService.cal(1, 2);
		Assert.assertEquals(10, cal);
	}
}
