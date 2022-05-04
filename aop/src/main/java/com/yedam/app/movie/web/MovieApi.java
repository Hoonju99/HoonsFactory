package com.yedam.app.movie.web;

import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MovieApi {
   static ObjectMapper om = new ObjectMapper();
   //1위영화
   public static String firstMovie(String targetDt) {
      String name ="";
      String boxUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=" + targetDt;
      try {
      JsonNode json = om.readTree(new URL(boxUrl));
      //첫번째 영화제목 출력
      JsonNode mv = json.get("boxOfficeResult")
                         .get("dailyBoxOfficeList")
                         .get(0);
      name = mv.get("movieNm").asText();
      } catch (Exception e) {
         e.printStackTrace();
      }                   
      return name;
   }
   //영화감독
   
   //영화리스트
}