
import okhttp3.*;

import javax.sound.midi.Soundbank;
import java.io.*;
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

    private static String filePath = "weu.txt";

    private static void saveAsFileWriter(String content) {
        FileWriter fwriter = null;
        try {
            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            fwriter = new FileWriter(filePath);
            fwriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
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


        String weu = "_WEU=0S9oCubHt4v1MYHuKYwblAKkPW9LzoPS1T67zJUAkakanjHV6JL7YU2KjEu*kMuSnqc0nPqEH8Va5BGXbB68vJomLTRkTEq5OA4YznAuFvDxobxLm_PaIPQwmx*jajsv;";
        String  cookie = "route=e3a7da32b2f8e62c5aa5e51f0d7a4589; EMAP_LANG=zh; THEME=indigo; "+weu+"; _ga=GA1.3.1214256026.1594967766; loginServiceserchVal=%u6BD5%u4E1A%u751F%u4E2D%u6587%u6210%u7EE9%u53CA%u5B66%u7C4D%u8BC1%u660E%u6863%u6848%u670D%u52A1; loginServiceclassifyId=all; loginServiceroleId=all; loginServiceSearchVal=; openLoginServicePageFlag=false; UM_distinctid=1766074cd72284-009e5c59f663b2-c791039-240000-1766074cd73b7a; route=07f03ed1ed6e496f5392b5b234387177; iPlanetDirectoryPro=tNwevBlIw10IhDBlWkf7AA; MOD_AUTH_CAS=MOD_AUTH_ST-630492-a6qH1J5jiM0DOgQvOlMH1609722387770-9BDc-cas; asessionid=fe9c55ca-91a0-4f37-91c2-a98931976caf; amp.locale=undefined; JSESSIONID=a8PK7sG1wBw3dqTNKybTrg2zlnVxJE5JB-VdjQfasgIAWdg_I4SE!321840131; zg_did=%7B%22did%22%3A%20%22173ea87c9426c4-04609d9b0f99ea-5d462912-240000-173ea87c9434f2%22%7D; zg_=%7B%22sid%22%3A%201609722439558%2C%22updated%22%3A%201609722439564%2C%22info%22%3A%201609722439563%2C%22superProperty%22%3A%20%22%7B%7D%22%2C%22platform%22%3A%20%22%7B%7D%22%2C%22utm%22%3A%20%22%7B%7D%22%2C%22referrerDomain%22%3A%20%22eportal.uestc.edu.cn%22%2C%22cuid%22%3A%20%22201922080813%22%2C%22zs%22%3A%200%2C%22sc%22%3A%200%2C%22firstScreen%22%3A%201609722439558%7D";

        //cookie存储

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("http://eportal.uestc.edu.cn/jkdkapp/sys/lwReportEpidemicStu/api/base/getUserDetailDB.do?userType= STUDENT")
                .method("POST", body)
                .addHeader("Cookie", cookie)
                .build();
        Response response = client.newCall(request).execute();
        Headers headers = response.headers();//// response为okhttp请求后的响应
        List cookies = headers.values("Set-Cookie");
        if (cookies.size() != 0) {
            weu = (String) cookies.get(cookies.size() - 1);
        }
        System.out.println(weu);
//        String session = (String) cookies.get(0);
        final String res = response.body().string();
        System.out.println(res);
        cookie = "route=e3a7da32b2f8e62c5aa5e51f0d7a4589; EMAP_LANG=zh; THEME=indigo; "+weu+"; _ga=GA1.3.1214256026.1594967766; loginServiceserchVal=%u6BD5%u4E1A%u751F%u4E2D%u6587%u6210%u7EE9%u53CA%u5B66%u7C4D%u8BC1%u660E%u6863%u6848%u670D%u52A1; loginServiceclassifyId=all; loginServiceroleId=all; loginServiceSearchVal=; openLoginServicePageFlag=false; UM_distinctid=1766074cd72284-009e5c59f663b2-c791039-240000-1766074cd73b7a; route=07f03ed1ed6e496f5392b5b234387177; iPlanetDirectoryPro=tNwevBlIw10IhDBlWkf7AA; MOD_AUTH_CAS=MOD_AUTH_ST-630492-a6qH1J5jiM0DOgQvOlMH1609722387770-9BDc-cas; asessionid=fe9c55ca-91a0-4f37-91c2-a98931976caf; amp.locale=undefined; JSESSIONID=a8PK7sG1wBw3dqTNKybTrg2zlnVxJE5JB-VdjQfasgIAWdg_I4SE!321840131; zg_did=%7B%22did%22%3A%20%22173ea87c9426c4-04609d9b0f99ea-5d462912-240000-173ea87c9434f2%22%7D; zg_=%7B%22sid%22%3A%201609722439558%2C%22updated%22%3A%201609722439564%2C%22info%22%3A%201609722439563%2C%22superProperty%22%3A%20%22%7B%7D%22%2C%22platform%22%3A%20%22%7B%7D%22%2C%22utm%22%3A%20%22%7B%7D%22%2C%22referrerDomain%22%3A%20%22eportal.uestc.edu.cn%22%2C%22cuid%22%3A%20%22201922080813%22%2C%22zs%22%3A%200%2C%22sc%22%3A%200%2C%22firstScreen%22%3A%201609722439558%7D";

        Request request2 = new Request.Builder()
                .url("http://eportal.uestc.edu.cn/jkdkapp/sys/lwReportEpidemicStu/configSet/noraml/getRouteConfig.do?v=09380716052498341")
                .method("GET", null)
                .addHeader("Cookie", cookie)
                .build();
        Response response2 = client.newCall(request2).execute();
        Headers headers2 = response2.headers();//// response为okhttp请求后的响应
        List cookies2 = headers2.values("Set-Cookie");
        if (cookies2.size() != 0) {
            weu = (String) cookies2.get(cookies2.size() - 1);
        }
        cookie = "route=e3a7da32b2f8e62c5aa5e51f0d7a4589; EMAP_LANG=zh; THEME=indigo; "+weu+"; _ga=GA1.3.1214256026.1594967766; loginServiceserchVal=%u6BD5%u4E1A%u751F%u4E2D%u6587%u6210%u7EE9%u53CA%u5B66%u7C4D%u8BC1%u660E%u6863%u6848%u670D%u52A1; loginServiceclassifyId=all; loginServiceroleId=all; loginServiceSearchVal=; openLoginServicePageFlag=false; UM_distinctid=1766074cd72284-009e5c59f663b2-c791039-240000-1766074cd73b7a; route=07f03ed1ed6e496f5392b5b234387177; iPlanetDirectoryPro=tNwevBlIw10IhDBlWkf7AA; MOD_AUTH_CAS=MOD_AUTH_ST-630492-a6qH1J5jiM0DOgQvOlMH1609722387770-9BDc-cas; asessionid=fe9c55ca-91a0-4f37-91c2-a98931976caf; amp.locale=undefined; JSESSIONID=a8PK7sG1wBw3dqTNKybTrg2zlnVxJE5JB-VdjQfasgIAWdg_I4SE!321840131; zg_did=%7B%22did%22%3A%20%22173ea87c9426c4-04609d9b0f99ea-5d462912-240000-173ea87c9434f2%22%7D; zg_=%7B%22sid%22%3A%201609722439558%2C%22updated%22%3A%201609722439564%2C%22info%22%3A%201609722439563%2C%22superProperty%22%3A%20%22%7B%7D%22%2C%22platform%22%3A%20%22%7B%7D%22%2C%22utm%22%3A%20%22%7B%7D%22%2C%22referrerDomain%22%3A%20%22eportal.uestc.edu.cn%22%2C%22cuid%22%3A%20%22201922080813%22%2C%22zs%22%3A%200%2C%22sc%22%3A%200%2C%22firstScreen%22%3A%201609722439558%7D";
        System.out.println(weu);
        saveAsFileWriter(cookie);
//        String session = (String) cookies.get(0);
        final String res2 = response2.body().string();
        System.out.println(res2);

    }
}
