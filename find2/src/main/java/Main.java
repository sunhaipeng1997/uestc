import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

/**
 * @program: uestc
 * @description:
 * @author: Sun
 * @create: 2020-11-06 15:58
 **/
public class Main {
    public static void main(String[] args) {
        HttpResponse<String> response = Unirest.post("http://eportal.uestc.edu.cn/jkdkapp/sys/lwReportEpidemicStu/api/base/getUserDetailDB.do?userType=%20STUDENT")
                .header("Cookie", "route=e3a7da32b2f8e62c5aa5e51f0d7a4589; EMAP_LANG=zh; THEME=indigo; _WEU=O2Gr_2S8gwrkCvzaScAXqitQjby4GAp1AbWtJgUJAMde4S4gdPG5pHQzXsMSbAb7qUSkCGT1AmuPun4P4XBRfRTjG6hdSJD3; UM_distinctid=172b72aa7d6405-03863fe9460dd-5d462912-240000-172b72aa7d7872; _ga=GA1.3.1214256026.1594967766; loginServiceserchVal=%u6BD5%u4E1A%u751F%u4E2D%u6587%u6210%u7EE9%u53CA%u5B66%u7C4D%u8BC1%u660E%u6863%u6848%u670D%u52A1; loginServiceroleId=all; loginServiceclassifyId=all; loginServiceSearchVal=; openLoginServicePageFlag=false; route=30dfce7b7500cd543e989b26cda7c8b4; iPlanetDirectoryPro=VLVzxYgA1bndQDsFxZki2T; MOD_AUTH_CAS=MOD_AUTH_ST-99562-03t35EhZbhtbY1oH1GV11604452686756-bLvu-cas; asessionid=21617eeb-c9ae-4dda-b6f5-584e8347bfcd; amp.locale=undefined; JSESSIONID=aPWbEKaDW9hJP8q0cS5xRabnLBLVdzQTs150N1hpqrTk6b4y5N1q!-90893721; zg_did=%7B%22did%22%3A%20%22173ea87c9426c4-04609d9b0f99ea-5d462912-240000-173ea87c9434f2%22%7D; zg_=%7B%22sid%22%3A%201604646310025%2C%22updated%22%3A%201604646310038%2C%22info%22%3A%201604285948419%2C%22superProperty%22%3A%20%22%7B%7D%22%2C%22platform%22%3A%20%22%7B%7D%22%2C%22utm%22%3A%20%22%7B%7D%22%2C%22referrerDomain%22%3A%20%22eportal.uestc.edu.cn%22%2C%22cuid%22%3A%20%22201922080813%22%2C%22zs%22%3A%200%2C%22sc%22%3A%200%2C%22firstScreen%22%3A%201604646310025%7D; _WEU=O9Gr_2S8gwrkCvzaScAXqitQjby4GAp1AbWtJgUJAMde4S4gdPG5pHQzXsMSbAb7qUSkCGT1AmuPun4P4XBRfRTjG6hdSJD3")
                .asString();
        System.out.println(response);
    }



}
