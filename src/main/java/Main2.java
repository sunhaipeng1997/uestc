
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
        String s = formatter.format(date);
        System.out.println(s);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "WID= B318D45286CF0454E053D3A4C5DEE071&NEED_CHECKIN_DATE= "+s+"&DEPT_CODE= 1008&CZR= &CZZXM= &CZRQ= "+s+" 00:00:00&USER_ID= 201922080813&USER_NAME= 孙海鹏&DEPT_NAME= 计算机科学与工程学院（网络空间安全学院）&GENDER_CODE= 男&AGE= 23&PHONE_NUMBER= 18428071278&IDCARD_NO= 410122199708250090&LB= 全日制专业硕士&PERSON_TYPE_DISPLAY= 留校&PERSON_TYPE= 001&TUTOR= 吴立军&LOCATION_PROVINCE_CODE_DISPLAY= 四川省&LOCATION_PROVINCE_CODE= 510000&LOCATION_CITY_CODE_DISPLAY= 成都市&LOCATION_CITY_CODE= 510100&LOCATION_COUNTY_CODE_DISPLAY= 郫都区&LOCATION_COUNTY_CODE= 510117&LOCATION_DETAIL= 电子科技大学清水河校区&HEALTH_STATUS_CODE_DISPLAY= 正常&HEALTH_STATUS_CODE= 001&HEALTH_UNSUAL_CODE= &IS_HOT_DISPLAY= 否&IS_HOT= 0&IS_IN_HB_DISPLAY= 否&IS_IN_HB= 0&IS_HB_BACK_DISPLAY= 否&IS_HB_BACK= 0&IS_DEFINITE_DISPLAY= 否&IS_DEFINITE= 0&IS_QUARANTINE_DISPLAY= 否&IS_QUARANTINE= 0&IS_KEEP_DISPLAY= 否&IS_KEEP= 0&TEMPERATURE= &IS_SEE_DOCTOR_DISPLAY= 否&IS_SEE_DOCTOR= NO&IS_IN_SCHOOL_DISPLAY= 是&IS_IN_SCHOOL= 1&MEMBER_HEALTH_STATUS_CODE_DISPLAY= 正常&MEMBER_HEALTH_STATUS_CODE= 001&MEMBER_HEALTH_UNSUAL_CODE_DISPLAY= &MEMBER_HEALTH_UNSUAL_CODE= &REMARK= &CREATED_AT= "+s+" 00:06&SAW_DOCTOR_DESC=");
        Request request = new Request.Builder()
                .url("http://eportal.uestc.edu.cn/jkdkapp/sys/lwReportEpidemicStu/modules/dailyReport/T_REPORT_EPIDEMIC_CHECKIN_YJS_SAVE.do")
                .method("POST", body)
                .addHeader("Cookie", "route=e3a7da32b2f8e62c5aa5e51f0d7a4589; EMAP_LANG=zh; THEME=indigo; _WEU=7TNimyd6r5GrtyEBvriWe09zh3EqXSd43CX0ZLXznS0FesViMkRHZ_BEWQtsxx0h*E4zQPikEkvBxT5Uv2qoNqzyHHF5yf2wrl*eWh8cTbmayK1BANvcDr91tQTWmObWUZom72mFDgB20bheUxvRmc..; UM_distinctid=172b72aa7d6405-03863fe9460dd-5d462912-240000-172b72aa7d7872; _ga=GA1.3.1214256026.1594967766; loginServiceserchVal=%u6BD5%u4E1A%u751F%u4E2D%u6587%u6210%u7EE9%u53CA%u5B66%u7C4D%u8BC1%u660E%u6863%u6848%u670D%u52A1; loginServiceroleId=all; loginServiceclassifyId=all; loginServiceSearchVal=; openLoginServicePageFlag=false; route=30dfce7b7500cd543e989b26cda7c8b4; asessionid=4fe4253c-dd6c-40ad-ae94-75e7cb00511b; amp.locale=undefined; iPlanetDirectoryPro=2S31VhCRDzki1SxiBR7KqC; MOD_AUTH_CAS=MOD_AUTH_ST-78042-5PeZMzEbsbAAbbyJMCuS1604380054317-bLvu-cas; JSESSIONID=sw6MgNR3bALJlq1CgTdA6McsH9aK3tN2c7hAQ72qYGBybFZgxi7x!-90893721; zg_did=%7B%22did%22%3A%20%22173ea87c9426c4-04609d9b0f99ea-5d462912-240000-173ea87c9434f2%22%7D; zg_=%7B%22sid%22%3A%201604393086247%2C%22updated%22%3A%201604393099392%2C%22info%22%3A%201604285948419%2C%22superProperty%22%3A%20%22%7B%7D%22%2C%22platform%22%3A%20%22%7B%7D%22%2C%22utm%22%3A%20%22%7B%7D%22%2C%22referrerDomain%22%3A%20%22eportal.uestc.edu.cn%22%2C%22cuid%22%3A%20%22201922080813%22%2C%22zs%22%3A%200%2C%22sc%22%3A%200%2C%22firstScreen%22%3A%201604393086247%7D; _WEU=Obhb1LDIGK07F*8KVW4imA3tGeLL*VxUck8GKdUQ6iiFFZqxUX5Pqa9weft7jf2zb0Inz8eKHIHraxbsT8NEE6YqWnhT2ezThlRVSR4yyddrxv9UDIVsU0tnSh7AFYAFrRDdSRSpn3eA3VtbA4m9go..")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = client.newCall(request).execute();
        final String res = response.body().string();
        System.out.println(res);

    }
}
