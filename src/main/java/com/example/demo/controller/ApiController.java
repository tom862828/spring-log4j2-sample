package com.example.demo.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.vo.ApiVO;

@RestController
@RequestMapping("/api")
public class ApiController{
	private static final Logger Log = LoggerFactory.getLogger(ApiController.class);
	
	@RequestMapping(value = "/v1/{name}", method = RequestMethod.GET, produces = "application/json")
	public ApiVO getWebApiInJSON(@RequestBody @PathVariable String name) throws Exception{
		
		ApiVO apiVO = new ApiVO();
		try {
			apiVO.setName(name);
			apiVO.setStatus("200");
		}catch (Exception e) {
			// TODO: handle exception
			Log.error("Exception: "+e.getMessage());
			apiVO.setName(name);
			apiVO.setStatus("500");
			return apiVO;
		}
		return apiVO;
	}
}
