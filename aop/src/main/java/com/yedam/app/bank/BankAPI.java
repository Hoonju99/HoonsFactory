package com.yedam.app.bank;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BankAPI {
	
	static String use_org_code="M202200738";
	static String oob_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJNMjAyMjAwNzM4Iiwic2NvcGUiOlsib29iIl0sImlzcyI6Imh0dHBzOi8vd3d3Lm9wZW5iYW5raW5nLm9yLmtyIiwiZXhwIjoxNjU4MTkwMTI4LCJqdGkiOiJmNTExNTJlYS1hMWQ3LTQ5NWQtOWU4Mi0yZGEyNGQyNmFlZWYifQ.Liekv5bQ8lTVt0A8k__FezOwlHAGeF7SIQQGE95uq5s";
	
	
	private static String getSequence() {
		long t = System.nanoTime();
		String result = String.valueOf(t);
		result = result.substring(result.length()-9);
		return result;
	}
	
	private static String getDate() {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		Date date = new Date();
		result = sdf.format(date);
		return result;
	}
	
	
	
	
	
	
	public static List<AccountVO> getAccountList(BankVO vo) {
		String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/list";
		
		String param = "user_seq_no=" + vo.getUserSeqNo(); // System.currentTimeMillis()
				param +="&include_cancel_yn="+"Y";
				param +="&sort_order="+"D";
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization","Bearer "+vo.getAccessToken());
		
        HttpEntity<MultiValueMap<String, String>> request = 
        		new HttpEntity<MultiValueMap<String, String>>( null, headers);  
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AccountList> response = restTemplate.exchange(reqURL + "?" + param,
				        									HttpMethod.GET,
														    request, AccountList.class);
        
        //System.out.println(reqURL + "?" + param);
        System.out.println(response.getBody());
        return response.getBody().getRes_list();
//        try {
//        	JsonNode json= objectMapper.readTree(response.getBody());
//        	json = json.get("res_lis");
//        	String str = objectMapper.writeValueAsString(json);
//        	AccountVO[] arr = objectMapper.readValue(str, AccountVO[].class);
//        	System.out.println(arr);
//        }catch (Exception e) {
//        	e.printStackTrace();
//        } 
//       //ObjectMapper
//        str -> jsonNode(readtree)
//        "res_list" ?????? -> jsonString ->AccountVO[] ->List<VO>
//		return null;
	}
	
	
	public static TokenVO getToken(String authCode) {
		;
		return null;
	}
	
	public static long getBalanceInfo(BankVO vo) {
		long balance = 0;
		
		String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/balance/fin_num";
		
		String param = "bank_tran_id="+ use_org_code + "U" + getSequence(); // System.currentTimeMillis()
				param +="&tran_dtime=" + getDate();
				param +="&fintech_use_num=" + vo.getFintechUseNum();
				
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization","Bearer "+vo.getAccessToken());
		
        HttpEntity<MultiValueMap<String, String>> request = 
        		new HttpEntity<MultiValueMap<String, String>>( null, headers);
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.exchange(reqURL + "?" + param,
				        									HttpMethod.GET,
														    request,
														    Map.class );
     
        Map map = response.getBody();
		return Long.valueOf((String)map.get("balance_amt"));
	}
	

	
	
	public static String getRealName() {
		String reqUrl = "https://testapi.openbanking.or.kr/v2.0/inquiry/real_name";
		Map<String, String> param = new HashMap<>();
		param.put("bank_tran_id", "M202200738U" + getSequence() );
		param.put("bank_code_std", "097");
		param.put("account_num", "1234567890123456");
		param.put("account_holder_info_type", " ");
		param.put("account_holder_info", "900614");
		param.put("tran_dtime", getDate());
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonValue = "";
		try {
			jsonValue = objectMapper.writeValueAsString(param);
			System.out.println(jsonValue);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json; charset=UTF-8");
		headers.set("Authorization","Bearer "+ oob_token);
		
		
        HttpEntity<String> request = new HttpEntity<String>(jsonValue, headers);
        
        RestTemplate restTemplate = new RestTemplate();
        Map response = restTemplate.postForObject(reqUrl, request, Map.class);
        String realName = (String) response.get("account_holder_name");
        
		
		return realName;
	}
	
		public static Map getTransaction(BankVO vo) {
		
		String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/transaction_list/fin_num";
		//???????????? settig
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("bank_tran_id", "M202200738U" + getSequence());
		map.add("fintech_use_num", vo.getFintechUseNum());
		map.add("inquiry_type", "A");
		map.add("inquiry_base", "D");
		map.add("from_date", "20190101");
		map.add("to_date", "20220420");
		map.add("sort_order", "D");
		map.add("tran_dtime", getDate());
		
		//MultiValueMap => queryString?????? ??????
		URI uri = UriComponentsBuilder.fromUriString(reqURL).queryParams(map).build().encode().toUri();
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization","Bearer "+vo.getAccessToken());
		
//		String param = "bank_tran_id="+ use_org_code + "U" + getSequence();
//		param +="&tran_dtime=" + getDate();
//		param +="&fintech_use_num=" + vo.getFintechUseNum();
		
		
		HttpEntity<MultiValueMap<String, String>> request = 
				new HttpEntity<MultiValueMap<String, String>>( map, headers);
		
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> response = restTemplate.exchange(uri, HttpMethod.GET, request, Map.class);
		
		return response.getBody();
	
		//String param = 				;
		//headr setting
		
		//request ??????(??????????????? ????????? ????????????)
		//RestTemplate??? ???????????? request??? ????????? response?????? json????????? ????????? ??????
		
	}
	
		public static Map updateInfo(BankVO vo) {
			String reqUrl = "https://testapi.openbanking.or.kr/v2.0/account/update_info";
			
			Map<String, String> param = new HashMap<>();
			
			param.put("account_alias", vo.getAccount_alias());
			param.put("fintech_use_num", vo.getFintechUseNum());
			
			
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonValue = "";
			try {
				jsonValue = objectMapper.writeValueAsString(param);
				System.out.println(jsonValue);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization","Bearer "+ vo.getAccessToken());
			
			
	        HttpEntity<String> request = new HttpEntity<String>(jsonValue, headers);
	        
	        RestTemplate restTemplate = new RestTemplate();
	        Map response = restTemplate.postForObject(reqUrl, request, Map.class);
	        System.out.println(response);
	        //String  = (String) response.get("account_alias");
	        
			
			return response;
			
			
		}
		
	
}
