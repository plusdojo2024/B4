package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class api {
    public static void main(String[] args) {
    	String fromAddress = "愛知県名古屋市東区赤塚町２８";
    	String toAddress = "愛知県名古屋市中区栄3丁目5-12";
//    	String fromAddress = args[0];
//    	String toAddress = args[1];
    	api ap = new api();
    	System.out.println(ap.naviApi(ap.latApi(fromAddress),ap.latApi(toAddress)));
    }
	public double[] latApi(String address){
		double[] latLon = new double[2];
        try {
            // APIのエンドポイントとパラメータを設定
            String apiUrl = "https://msearch.gsi.go.jp/address-search/AddressSearch?q=" + java.net.URLEncoder.encode(address, "UTF-8");

            // URLを作成し接続
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            // レスポンスを取得
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            conn.disconnect();

            // JSON解析
            JSONArray jsonArray = new JSONArray(sb.toString());
            if (jsonArray.length() > 0) {
                JSONObject geometry = jsonArray.getJSONObject(0).getJSONObject("geometry");
                JSONArray coordinates = geometry.getJSONArray("coordinates");
                latLon[0] = coordinates.getDouble(0);
                latLon[1] = coordinates.getDouble(1);
//                System.out.println("緯度: " + latLon[1] + ", 経度: " + latLon[0]);
            } else {
//                System.out.println("住所が見つかりませんでした。");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return latLon;
        //経度、緯度の順番で保存
    }

	public int naviApi(double[] from,double[] to) {
        int travelTime = 0;
        List<Integer> timeList = new ArrayList<Integer>();

		try {
	        // APIのエンドポイントとパラメータを設定
	        String apiUrl = "https://navitime-route-totalnavi.p.rapidapi.com/route_transit" +
	                "?rapidapi-key=ccde11bc55mshaf92fe34f51d7fap1b08ddjsn440af22a0c7d" +
	                "&start={\"lat\":"+ from[1] +",\"lon\":"+ from[0] +",\"name\":\"YSLソリューション\"}" +
	                "&goal={\"lat\":"+ to[1] +",\"lon\":"+ to[0] +",\"name\":\"SEプラス\"}" +
	                "&unuse=domestic_flight.sleeper_ultraexpress.shuttle_bus" +
	                "&use_car=false" +
	                "&goal_time=2024-06-19T17:50:00";
	        // URLを作成し接続
	        URL url = new URL(apiUrl);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");

	        // レスポンスを取得
	        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	        StringBuilder sb = new StringBuilder();
	        String output;
	        while ((output = br.readLine()) != null) {
	            sb.append(output);
	        }
	        conn.disconnect();

	        // JSON解析
	        JSONObject jsonResponse = new JSONObject(sb.toString());
	        JSONArray items = jsonResponse.getJSONArray("items");

	        // 各ルートの情報を取り出して表示
	        for (int i = 0; i < items.length(); i++) {
	            JSONObject item = items.getJSONObject(i);
	            JSONObject summary = item.getJSONObject("summary");

	            // ルート番号
	            String routeNumber = summary.getString("no");

	            // 出発点情報
	            JSONObject start = summary.getJSONObject("start");
	            String startName = start.getString("name");
	            double startLat = start.getJSONObject("coord").getDouble("lat");
	            double startLon = start.getJSONObject("coord").getDouble("lon");

	            // 到着点情報
	            JSONObject goal = summary.getJSONObject("goal");
	            String goalName = goal.getString("name");
	            double goalLat = goal.getJSONObject("coord").getDouble("lat");
	            double goalLon = goal.getJSONObject("coord").getDouble("lon");

	            // 移動情報
	            JSONObject move = summary.getJSONObject("move");
	            int transitCount = move.getInt("transit_count");
	            int walkDistance = move.getInt("walk_distance");
	            double fare = move.getJSONObject("fare").getDouble("unit_0");
	            String fromTime = move.getString("from_time");
	            String toTime = move.getString("to_time");
	            int time = move.getInt("time");
	            int distance = move.getInt("distance");

	            // 結果の表示
//	            System.out.println("Route " + routeNumber + ":");
//	            System.out.println("  Start: " + startName + " (Lat: " + startLat + ", Lon: " + startLon + ")");
//	            System.out.println("  Goal: " + goalName + " (Lat: " + goalLat + ", Lon: " + goalLon + ")");
//	            System.out.println("  Transit Count: " + transitCount);
//	            System.out.println("  Walk Distance: " + walkDistance + " meters");
//	            System.out.println("  Fare: " + fare + " yen");
//	            System.out.println("  From Time: " + fromTime);
//	            System.out.println("  To Time: " + toTime);
//	            System.out.println("  Travel Time: " + time + " minutes");
//	            System.out.println("  Distance: " + distance + " meters");
//	            System.out.println();

	            timeList.add(time);
	            travelTime = timeList.get(0);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
//        確認用
//        for(int i = 0; i < timeList.size() ; i++) {
//        	System.out.println(timeList.get(i));
//        }
        return travelTime;
	}


}
