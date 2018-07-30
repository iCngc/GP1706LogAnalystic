import com.qianfeng.analystic.model.dim.base.PlatformDimension;
import com.qianfeng.analystic.mr.service.IDimensionConvert;
import com.qianfeng.analystic.mr.service.impl.IDimensionConvertImpl;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @Auther: lyd
 * @Date: 2018/7/30 09:39
 * @Description:
 */
public class DimensionTest {
    public static void main(String[] args) {
        IDimensionConvert convert = new IDimensionConvertImpl();
        PlatformDimension pl = new PlatformDimension("www");
        try {
            System.out.println(convert.getDimensionIdByDimension(pl));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
