
import okhttp3.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: uestc
 * @description:
 * @author: Sun
 * @create: 2020-11-03 10:35
 **/
public class Main2 {


    private static String getCookie() throws FileNotFoundException {
        File file = new File("weu.txt");
        if(file.isFile() && file.exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuffer sb = new StringBuffer();
                String text = null;
                while((text = bufferedReader.readLine()) != null){
                    sb.append(text);
                }
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        String cookie = getCookie();
        System.out.println(cookie);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String s = formatter.format(date);
        System.out.println(s);



        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");

        RequestBody body = RequestBody.create(mediaType, "WID=&CZZ=&CZZXM=&CZRQ=&USER_ID=201922080813&USER_NAME=孙海鹏&DEPT_CODE=1008&DEPT_NAME=计算机科学与工程学院（网络空间安全学院）&NEED_DATE=" + s + "&DAY_TIME_DISPLAY=早上&DAY_TIME=1&TEMPERATURE=36&CREATED_AT=" + s + " 00:06");
        Request request = new Request.Builder()
                .url("http://eportal.uestc.edu.cn/jkdkapp/sys/lwReportEpidemicStu/modules/tempReport/T_REPORT_TEMPERATURE_YJS_SAVE.do")
                .method("POST", body)
                .addHeader("Cookie", cookie)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = client.newCall(request).execute();
        final String res = response.body().string();
        System.out.println(res);

        OkHttpClient client2 = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType2 = MediaType.parse("application/x-www-form-urlencoded");

        RequestBody body2 = RequestBody.create(mediaType2, "WID=&CZZ=&CZZXM=&CZRQ=&USER_ID=201922080813&USER_NAME=孙海鹏&DEPT_CODE=1008&DEPT_NAME=计算机科学与工程学院（网络空间安全学院）&NEED_DATE=" + s + "&DAY_TIME_DISPLAY=中午&DAY_TIME=2&TEMPERATURE=36&CREATED_AT=" + s + " 00:10");
        Request request2 = new Request.Builder()
                .url("http://eportal.uestc.edu.cn/jkdkapp/sys/lwReportEpidemicStu/modules/tempReport/T_REPORT_TEMPERATURE_YJS_SAVE.do")
                .method("POST", body2)
                .addHeader("Cookie", cookie)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response2 = client2.newCall(request2).execute();
        final String res2 = response2.body().string();
        System.out.println(res2);

        OkHttpClient client3 = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType3 = MediaType.parse("application/x-www-form-urlencoded");

        RequestBody body3 = RequestBody.create(mediaType3, "WID=&CZZ=&CZZXM=&CZRQ=&USER_ID=201922080813&USER_NAME=孙海鹏&DEPT_CODE=1008&DEPT_NAME=计算机科学与工程学院（网络空间安全学院）&NEED_DATE=" + s + "&DAY_TIME_DISPLAY=晚上&DAY_TIME=3&TEMPERATURE=36&CREATED_AT=" + s + " 00:10");
        Request request3 = new Request.Builder()
                .url("http://eportal.uestc.edu.cn/jkdkapp/sys/lwReportEpidemicStu/modules/tempReport/T_REPORT_TEMPERATURE_YJS_SAVE.do")
                .method("POST", body3)
                .addHeader("Cookie", cookie)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response3 = client3.newCall(request3).execute();
        final String res3 = response3.body().string();
        System.out.println(res3);

    }
}
