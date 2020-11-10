
import okhttp3.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: uestc
 * @description:
 * @author: Sun
 * @create: 2020-11-03 10:35
 **/
public class Main2 {


    public static void main(String[] args) throws IOException {

        String cookie = "route=e3a7da32b2f8e62c5aa5e51f0d7a4589; EMAP_LANG=zh; THEME=indigo; _WEU=XulKGjzMY5AweaJAw27Jl2IJpN39OH1weHGbgz9vdnnX4h_z7fFS4oXFh__q3mjqzNR_oQ54ajIGIpOSzKaTw5*6a5ti5Ml9*y*x4SvYg7ebg5wIS5YSS_Y6H4Ptp2gEVx9lOhZUy1*VrM_UmiG7Cc..; UM_distinctid=172b72aa7d6405-03863fe9460dd-5d462912-240000-172b72aa7d7872; _ga=GA1.3.1214256026.1594967766; loginServiceserchVal=%u6BD5%u4E1A%u751F%u4E2D%u6587%u6210%u7EE9%u53CA%u5B66%u7C4D%u8BC1%u660E%u6863%u6848%u670D%u52A1; loginServiceroleId=all; loginServiceclassifyId=all; loginServiceSearchVal=; openLoginServicePageFlag=false; route=30dfce7b7500cd543e989b26cda7c8b4; iPlanetDirectoryPro=VLVzxYgA1bndQDsFxZki2T; MOD_AUTH_CAS=MOD_AUTH_ST-99562-03t35EhZbhtbY1oH1GV11604452686756-bLvu-cas; asessionid=4c4027cd-c914-45ba-9b46-45164444e8e7; amp.locale=undefined; JSESSIONID=4CSWWTyVNEEV9ZnePOSyaewQl1hk-YGun1_xdARsaqiM_-QrPALZ!-90893721; zg_did=%7B%22did%22%3A%20%22173ea87c9426c4-04609d9b0f99ea-5d462912-240000-173ea87c9434f2%22%7D; zg_=%7B%22sid%22%3A%201604545233178%2C%22updated%22%3A%201604545233189%2C%22info%22%3A%201604285948419%2C%22superProperty%22%3A%20%22%7B%7D%22%2C%22platform%22%3A%20%22%7B%7D%22%2C%22utm%22%3A%20%22%7B%7D%22%2C%22referrerDomain%22%3A%20%22eportal.uestc.edu.cn%22%2C%22cuid%22%3A%20%22201922080813%22%2C%22zs%22%3A%200%2C%22sc%22%3A%200%2C%22firstScreen%22%3A%201604545233178%7D";
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
        System.out.println(res);
        String wid = res.substring(92, 124);
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
