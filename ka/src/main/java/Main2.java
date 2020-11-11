

import com.alibaba.fastjson.JSONObject;
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

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "pageNumber=1&pageSize=10&USER_ID=201922080813");
        Request request = new Request.Builder()
                .url("http://eportal.uestc.edu.cn/jkdkapp/sys/lwReportEpidemicStu/modules/dailyReport/getMyTodayReportWid.do")
                .method("POST", body)
                .addHeader("Accept", " application/json, text/javascript, */*; q=0.01")
                .addHeader("Accept-Encoding", " gzip, deflate")
                .addHeader("Accept-Language", " zh-CN,zh;q=0.9")
                .addHeader("Connection", " keep-alive")
                .addHeader("Content-Length", " 45")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Cookie", cookie)
                .addHeader("Host", " eportal.uestc.edu.cn")
                .addHeader("Origin", " http://eportal.uestc.edu.cn")
                .addHeader("Referer", " http://eportal.uestc.edu.cn/jkdkapp/sys/lwReportEpidemicStu/index.do?t_s=1604468004376&amp_sec_version_=1&gid_=MFlLV0dZT3pwTGRNenczQVJXSWtzUFhZS284V3pzSEpWUDcrV3RESGZQSlZSc2piTy94VmtNcjZPbEh1TFpuRitOTTJRajVnUlhlN2NGSmNIc0lTd2c9PQ&EMAP_LANG=zh&THEME=indigo")
                .addHeader("User-Agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.111 Safari/537.36")
                .addHeader("X-Requested-With", " XMLHttpRequest")
                .build();
        Response response = client.newCall(request).execute();
        final String res = response.body().string();
        JSONObject jsonObject = JSONObject.parseObject(res);
        String wid = jsonObject.getJSONObject("datas").getJSONObject("getMyTodayReportWid").getJSONArray("rows").getJSONObject(0).get("WID").toString();


        System.out.println(res);
//        String wid = res.substring(92, 124);
        System.out.println(wid);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String s = formatter.format(date);
        System.out.println(s);
        OkHttpClient client2 = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType2 = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body2 = RequestBody.create(mediaType2, "WID= "+wid+"&NEED_CHECKIN_DATE= " + s + "&DEPT_CODE= 1008&CZR= &CZZXM= &CZRQ= " + s + " 00:00:00&USER_ID= 201922080813&USER_NAME= 孙海鹏&DEPT_NAME= 计算机科学与工程学院（网络空间安全学院）&GENDER_CODE= 男&AGE= 23&PHONE_NUMBER= 18428071278&IDCARD_NO= 410122199708250090&LB= 全日制专业硕士&PERSON_TYPE_DISPLAY= 留校&PERSON_TYPE= 001&TUTOR= 吴立军&LOCATION_PROVINCE_CODE_DISPLAY= 四川省&LOCATION_PROVINCE_CODE= 510000&LOCATION_CITY_CODE_DISPLAY= 成都市&LOCATION_CITY_CODE= 510100&LOCATION_COUNTY_CODE_DISPLAY= 郫都区&LOCATION_COUNTY_CODE= 510117&LOCATION_DETAIL= 电子科技大学清水河校区&HEALTH_STATUS_CODE_DISPLAY= 正常&HEALTH_STATUS_CODE= 001&HEALTH_UNSUAL_CODE= &IS_HOT_DISPLAY= 否&IS_HOT= 0&IS_IN_HB_DISPLAY= 否&IS_IN_HB= 0&IS_HB_BACK_DISPLAY= 否&IS_HB_BACK= 0&IS_DEFINITE_DISPLAY= 否&IS_DEFINITE= 0&IS_QUARANTINE_DISPLAY= 否&IS_QUARANTINE= 0&IS_KEEP_DISPLAY= 否&IS_KEEP= 0&TEMPERATURE= &IS_SEE_DOCTOR_DISPLAY= 否&IS_SEE_DOCTOR= NO&IS_IN_SCHOOL_DISPLAY= 是&IS_IN_SCHOOL= 1&MEMBER_HEALTH_STATUS_CODE_DISPLAY= 正常&MEMBER_HEALTH_STATUS_CODE= 001&MEMBER_HEALTH_UNSUAL_CODE_DISPLAY= &MEMBER_HEALTH_UNSUAL_CODE= &REMARK= &CREATED_AT= " + s + " 00:07&SAW_DOCTOR_DESC=");
        Request request2 = new Request.Builder()
                .url("http://eportal.uestc.edu.cn/jkdkapp/sys/lwReportEpidemicStu/modules/dailyReport/T_REPORT_EPIDEMIC_CHECKIN_YJS_SAVE.do")
                .method("POST", body2)
                .addHeader("Cookie", cookie)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response2 = client2.newCall(request2).execute();
        final String res3 = response2.body().string();
        System.out.println(res3);

    }
}
