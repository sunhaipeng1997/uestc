
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

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String cookie = "route=e3a7da32b2f8e62c5aa5e51f0d7a4589; EMAP_LANG=zh; THEME=indigo; _WEU=F5ZdnU0AhbpSSA27LC00IN_AUcZ9IxXzPgFP0DpBRbQNMRqfaxxiBhJ0Xwgh5UFFy_ejuV3WTjnL5m4q1KzRYUdSTdbdxrC51GN8vezLh*QmQQqI3m88JMU3GXb9*3E4x9T4eqQXBFL1sOqABY_dsS..; UM_distinctid=172b72aa7d6405-03863fe9460dd-5d462912-240000-172b72aa7d7872; _ga=GA1.3.1214256026.1594967766; loginServiceserchVal=%u6BD5%u4E1A%u751F%u4E2D%u6587%u6210%u7EE9%u53CA%u5B66%u7C4D%u8BC1%u660E%u6863%u6848%u670D%u52A1; loginServiceroleId=all; loginServiceclassifyId=all; loginServiceSearchVal=; openLoginServicePageFlag=false; route=30dfce7b7500cd543e989b26cda7c8b4; iPlanetDirectoryPro=VLVzxYgA1bndQDsFxZki2T; MOD_AUTH_CAS=MOD_AUTH_ST-99562-03t35EhZbhtbY1oH1GV11604452686756-bLvu-cas; asessionid=21617eeb-c9ae-4dda-b6f5-584e8347bfcd; amp.locale=undefined; JSESSIONID=aPWbEKaDW9hJP8q0cS5xRabnLBLVdzQTs150N1hpqrTk6b4y5N1q!-90893721; zg_did=%7B%22did%22%3A%20%22173ea87c9426c4-04609d9b0f99ea-5d462912-240000-173ea87c9434f2%22%7D; zg_=%7B%22sid%22%3A%201604627813073%2C%22updated%22%3A%201604627941528%2C%22info%22%3A%201604285948419%2C%22superProperty%22%3A%20%22%7B%7D%22%2C%22platform%22%3A%20%22%7B%7D%22%2C%22utm%22%3A%20%22%7B%7D%22%2C%22referrerDomain%22%3A%20%22eportal.uestc.edu.cn%22%2C%22cuid%22%3A%20%22201922080813%22%2C%22zs%22%3A%200%2C%22sc%22%3A%200%2C%22firstScreen%22%3A%201604627813073%7D";
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
        System.out.println(res2);

    }
}
