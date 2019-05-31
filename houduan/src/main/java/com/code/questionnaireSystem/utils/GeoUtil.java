package com.code.questionnaireSystem.utils;

import java.io.File;
import java.net.InetAddress;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Subdivision;

public class GeoUtil {
	public static void main(String[] args) throws Exception {

		System.out.println(GeoUtil.Geoprovince(GeoUtil.getResponse("106.91.20.144")).getNames().get("zh-CN"));

	}

	public static CityResponse getResponse(String ip) throws Exception {
		String devFile = "E:/CODE/Questionnaire-system/material/GeoLite2-City.mmdb";
		// String prodFile = "/home/www/GeoLite2-City.mmdb";
		File database = new File(devFile);
		// 读取数据库内容
		DatabaseReader reader = new DatabaseReader.Builder(database).build();
		InetAddress ipAddress = InetAddress.getByName(ip);
		// 获取查询结果
		CityResponse response = reader.city(ipAddress);
		return response;
	}

	/**
	 * 获取国家
	 * 
	 * @param response
	 * @return
	 */
	public static Country GeoCountry(CityResponse response) {
		Country country = response.getCountry();
		return country;
	}

	/**
	 * 获取省份
	 * 
	 * @param response
	 * @return
	 */
	public static Subdivision Geoprovince(CityResponse response) {
		Subdivision subdivision = response.getMostSpecificSubdivision();
		return subdivision;
	}

	/**
	 * 获取城市
	 * 
	 * @param response
	 * @return
	 */
	public static City GeoCity(CityResponse response) {
		City city = response.getCity();
		return city;
	}

}
