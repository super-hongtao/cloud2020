import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author : HongTao
 * @version : v1.0
 * @description 生成时区时间
 * @date : 2020/7/30 23:18
 */
public class T2 {
    public static void main(String[] args) {
        //获取默认时区的时间
        ZonedDateTime zbj = ZonedDateTime.now();
        System.out.println("Asia/Shanghai："+zbj);
        //获取指定时区的时间
        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("America/New_York："+zny);
    }
}
