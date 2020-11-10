
import okhttp3.*;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: uestc
 * @description:
 * @author: Sun
 * @create: 2020-11-03 10:35
 **/
public class Main {


    public static void main(String[] args) throws IOException {
        String weu = "_WEU=tvaFSSth7Z4GTZdwnaY5geYR7WvtRpgK3GivTL9rjWv7KTMwOluCzp224gCfT9nrsnWzAEXCwGh4docWe2X4rpRxHvuZ4*eN; path=/jkdkapp/";
        String cookie = "route=e3a7da32b2f8e62c5aa5e51f0d7a4589; EMAP_LANG=zh; THEME=indigo; "+weu+"; UM_distinctid=172b72aa7d6405-03863fe9460dd-5d462912-240000-172b72aa7d7872; _ga=GA1.3.1214256026.1594967766; loginServiceserchVal=%u6BD5%u4E1A%u751F%u4E2D%u6587%u6210%u7EE9%u53CA%u5B66%u7C4D%u8BC1%u660E%u6863%u6848%u670D%u52A1; loginServiceroleId=all; loginServiceclassifyId=all; loginServiceSearchVal=; openLoginServicePageFlag=false; route=30dfce7b7500cd543e989b26cda7c8b4; iPlanetDirectoryPro=VLVzxYgA1bndQDsFxZki2T; MOD_AUTH_CAS=MOD_AUTH_ST-99562-03t35EhZbhtbY1oH1GV11604452686756-bLvu-cas; asessionid=21617eeb-c9ae-4dda-b6f5-584e8347bfcd; amp.locale=undefined; JSESSIONID=aPWbEKaDW9hJP8q0cS5xRabnLBLVdzQTs150N1hpqrTk6b4y5N1q!-90893721; zg_did=%7B%22did%22%3A%20%22173ea87c9426c4-04609d9b0f99ea-5d462912-240000-173ea87c9434f2%22%7D; zg_=%7B%22sid%22%3A%201604643059623%2C%22updated%22%3A%201604643059634%2C%22info%22%3A%201604285948419%2C%22superProperty%22%3A%20%22%7B%7D%22%2C%22platform%22%3A%20%22%7B%7D%22%2C%22utm%22%3A%20%22%7B%7D%22%2C%22referrerDomain%22%3A%20%22eportal.uestc.edu.cn%22%2C%22cuid%22%3A%20%22201922080813%22%2C%22zs%22%3A%200%2C%22sc%22%3A%200%2C%22firstScreen%22%3A%201604643059623%7D";
//cookie存储

        OkHttpClient client = new OkHttpClient().newBuilder()
//                .cookieJar(new CookieJar()
//                {//这里可以做cookie传递，保存等操作
//                    private ConcurrentHashMap<String, List<Cookie>> cookieStore = new ConcurrentHashMap<String,List<Cookie>>();
//                    @Override
//                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies)
//                    {//可以做保存cookies操作
//                        cookieStore.put(url.host(), cookies);
//                    }
//
//                    @Override
//                    public List<Cookie> loadForRequest(HttpUrl url)
//                    {//加载新的cookies
//                        List<Cookie> cookies = cookieStore.get(url.host());
//                        return cookies != null ? cookies : new ArrayList<Cookie>();
//                    }
//                })
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("http://eportal.uestc.edu.cn/jkdkapp/sys/lwReportEpidemicStu/api/base/getUserDetailDB.do?userType= STUDENT")
                .method("POST", body)
                .addHeader("Cookie",cookie )
                .build();
        Response response = client.newCall(request).execute();
        Headers headers =response.headers();//// response为okhttp请求后的响应
        List cookies = headers.values("Set-Cookie");
        if (cookies.size()!=0){
            weu = (String)cookies.get(cookies.size()-1);
        }

        System.out.println(weu);
//        String session = (String) cookies.get(0);
        final String res = response.body().string();
        System.out.println(res);




        Request request2 = new Request.Builder()
                .url("http://eportal.uestc.edu.cn/jkdkapp/sys/lwReportEpidemicStu/configSet/noraml/getRouteConfig.do?v=09380716052498341")
                .method("GET", null)
                .addHeader("Cookie", "route=9033f4b796549dbf89d99e33b6a7a00a; EMAP_LANG=zh; THEME=indigo; _WEU=TPvr9c6ZcrzSPccm*rvVlMKbCcZ_SFAbUVwXRoe9cK7Q*bezAxBAg3F*q9hnewBF_cAfgf4JeQUQvW3TPBgZNiWdcLt6Q8FVrcD4nyVVZNYf8yfU0UXer8FbjzwlLuLF; UM_distinctid=172b72aa7d6405-03863fe9460dd-5d462912-240000-172b72aa7d7872; _ga=GA1.3.1214256026.1594967766; loginServiceserchVal=%u6BD5%u4E1A%u751F%u4E2D%u6587%u6210%u7EE9%u53CA%u5B66%u7C4D%u8BC1%u660E%u6863%u6848%u670D%u52A1; loginServiceroleId=all; loginServiceclassifyId=all; loginServiceSearchVal=; openLoginServicePageFlag=false; zg_did=%7B%22did%22%3A%20%22173ea87c9426c4-04609d9b0f99ea-5d462912-240000-173ea87c9434f2%22%7D; zg_=%7B%22sid%22%3A%201604711761169%2C%22updated%22%3A%201604711761174%2C%22info%22%3A%201604285948419%2C%22superProperty%22%3A%20%22%7B%7D%22%2C%22platform%22%3A%20%22%7B%7D%22%2C%22utm%22%3A%20%22%7B%7D%22%2C%22referrerDomain%22%3A%20%22eportal.uestc.edu.cn%22%2C%22cuid%22%3A%20%22201922080813%22%2C%22zs%22%3A%200%2C%22sc%22%3A%200%2C%22firstScreen%22%3A%201604711761169%7D; iPlanetDirectoryPro=CzvTCiFfqKcp9ySHDNgy4s; MOD_AUTH_CAS=MOD_AUTH_ST-275686-07UW14NCWVkrnpatxcep1604978305071-jO2w-cas; route=07f03ed1ed6e496f5392b5b234387177; asessionid=6a58df19-d028-43d4-85b6-8790267c202e; amp.locale=undefined; JSESSIONID=rtSwKcHp5TaHV2U3xldcp_iBqz5h3Cj0CpRaBXU4r_f9hXXnIFwi!939769185; _WEU=3AY8v6IR93pVQAgjwVwafGLBf5EKsaqrO0EbmLA_9WrRnWMvWJEcXHE35bmfOOws86YjryZgYLIlCbUNI39A5OfnAOhTsI_uj7gVs2W6KwjnNMhrgkh*fqPM75DIknIHg8jJSPYRpEGmfF8PaA*0*j..")
                .build();
        Response response2 = client.newCall(request2).execute();
        Headers headers2 =response2.headers();//// response为okhttp请求后的响应
        List cookies2 = headers2.values("Set-Cookie");
        if (cookies2.size()!=0){
            weu = (String)cookies2.get(cookies2.size()-1);
        }

        System.out.println(weu);
//        String session = (String) cookies.get(0);
        final String res2 = response.body().string();
        System.out.println(res2);

    }
}
