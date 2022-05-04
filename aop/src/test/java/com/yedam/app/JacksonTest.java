package com.yedam.app;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.app.notice.vo.NoticeVO;

public class JacksonTest {

	static ObjectMapper om;

	@BeforeClass
	public static void init() {
		om = new ObjectMapper();
	}

	@Test
	public void readTreeTest2() throws MalformedURLException, IOException {
		String infoUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd=20220416";
		RestTemplate restTemplate = new RestTemplate();
		JsonNode json = restTemplate.getForObject(infoUrl, JsonNode.class);
		
		
		//결과 조회
		json = json.get("movieInfoResult").get("movieInfo");
		
		//vo 로 변환
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MovieInfoVO mvInfo = om.treeToValue(json, MovieInfoVO.class);
	
		// 첫번쩌 감독 출력
		System.out.println(mvInfo);
	}

	@Test
	public void readTreeTest() throws MalformedURLException, IOException  {
		String boxUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101";
		RestTemplate restTemplate = new RestTemplate();
		JsonNode json = restTemplate.getForObject(boxUrl, JsonNode.class);
		
		//첫번째 영화제목 출력
		JsonNode mvlist = json.get("boxOfficeResult").get("dailyBoxOfficeList");
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MovieVO[] arr = om.treeToValue(mvlist, MovieVO[].class);
		
		List<MovieVO> list = Arrays.asList(arr);
		System.out.println(list.get(0).getMocieNm());
				
		//JsonNode json = om.readTree(new URL(boxUrl));
		
		//System.out.println(mv.get("movieNm")+ ":" + mv.get("movieCd"));
		
		
	}

	@Test
	public void reaTest() throws JsonMappingException, JsonProcessingException {
		String str = "{\"id\":0,\"title\":\"제목\",\"content\":\"내용\",\"wdate\":null,\"hit\":0}\r\n";
		NoticeVO vo = om.readValue(str, NoticeVO.class);
		assertEquals(vo.getTitle(), "제목");

	}

	@Test
	public void writeTest() throws JsonProcessingException {
		NoticeVO vo = NoticeVO.builder().title("제목").content("내용").build();

		String str = om.writeValueAsString(vo);
		System.out.println(str);

	}
}
