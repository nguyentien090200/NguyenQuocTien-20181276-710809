package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;

/**
 * Class cung cấp phương thức gửi Request lên Server và nhận dữ liệu trả về
 * Date : 09/12/2021
 * @author PIE
 * @version 1.0
 */

public class API {
	// Nguyen Quoc Tien
	// Thuộc tính lấy thời gian theo định dạng Date Format - Năm/Tháng/Ngày
	public static DateFormat DATE_FORMATER = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	// Thuộc tính in thông tin ra Console
	private static Logger LOGGER = Utils.getLogger(Utils.class.getName());
	
	
	/**
	 * Phương thức thiết lập kết nối tới Server
	 * @param url: đường dẫn
	 * @param method: giao thức
	 * @param token: mã dùng để xác thực người dùng
	 * @return connection
	 * @throws IOException
	 */
	
	private static HttpURLConnection setupConnection(String url, String method, String token) throws IOException{
		// Nguyen Quoc Tien
		LOGGER.info("Request URL: " + url + "\n");
		URL line_api_url = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) line_api_url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod(method); 
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Authorization", "Bearer " + token);
		return conn;
	}

	
	/**
	 * Đọc phản hồi (bao gồm dữ liệu,...) trả về từ server
	 * @param Connection: Liên kết đến server hiện tại
	 * @return Thông điệp
	 * @throws IOException
	 */
	private static String readResponse(HttpURLConnection connection) throws IOException{
		BufferedReader in;
		String inputLine;
		
		if (connection.getResponseCode() / 100 == 2) {
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		} else {
			in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
		}
		
		StringBuilder response = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			response.append(inputLine);
		in.close();
		LOGGER.info("Respone Info: " + response.toString());
		return response.toString();

	}
	/**
	 * 
	 * @author PIE
	 * @param url: Đường dẫn đển Server
	 * @param token: Đoạn mã cần cung cấp để xác thực người dùng
	 * @return response: Phản hồi từ Server
	 * @throws Exception
	 */
	public static String get(String url, String token) throws Exception {
		// 		Phần 1 : Setup
		HttpURLConnection conn = setupConnection(url,"GET",token);

        // 		Phần 2 : Đọc dữ liệu trả về từ server
		String response = readResponse(conn);

		return response;
	}

	/**
	 * Phuong thuc giup goi cac api dan POST (thanh toan, ...)
	 * @author Tran The Lam
	 * @param url: duong dan toi server can request
	 * @param data: du lieu dua len server de xu ly (dang JSON)
	 * @return response: phan hoi tu server (dang String)
	 * @throws IOException
	 */
	public static String post(String url, String data, String token) throws IOException {
		//		Cho phép PATH protocol
		allowMethods("PATCH");
		
        //		Phần 1: Setup
		HttpURLConnection conn = setupConnection(url,"POST",token);

        //		Phần 2 : gửi dữ liệu
		Writer writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		writer.write(data);
		writer.close();

        //		Phần 3: đọc dữ liệu gửi về từ server
		String response = readResponse(conn);
		return response.toString();
	}

	/**
	 * Phuong thuc cho phep goi cac loai giao thuc API khac nhau nhu PATCH, PUT, ... (chi hoat dong voi Java 11)
	 * @deprecated chi hoat dong voi Java <= 11
	 * @param methods: giao thuc can cho cho phep (PATCH, PUT, ...)
	 */
	private static void allowMethods(String... methods) {
		try {
			// Nguyen Quoc Tien
			Field methodsField = HttpURLConnection.class.getDeclaredField("methods");
			methodsField.setAccessible(true);

			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(methodsField, methodsField.getModifiers() & ~Modifier.FINAL);

			String[] oldMethods = (String[]) methodsField.get(null);
			Set<String> methodsSet = new LinkedHashSet<>(Arrays.asList(oldMethods));
			methodsSet.addAll(Arrays.asList(methods));
			String[] newMethods = methodsSet.toArray(new String[0]);

			methodsField.set(null/* static field */, newMethods);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			throw new IllegalStateException(e);
		}
	}

}
