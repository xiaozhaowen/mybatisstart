import com.xiaozhao.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by xiaozhao on 2018/2/26.
 *
 * @author xiaozhao
 */
public class Test {
    public static void main(String[] args) {
        try {
            // 读取主配置文件
            Reader reader = Resources.getResourceAsReader("Configuration.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = factory.openSession();
            // 查询所有的用户列表
            List<User> list = sqlSession.selectList("User.queryAll");
            for (User user : list) {
                System.out.println(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
