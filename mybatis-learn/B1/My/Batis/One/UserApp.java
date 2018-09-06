package My.Batis.One;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import My.Batis.One.Pojo.User;
import My.Batis.One.Pojo.User2;

public class UserApp {
	public static void main(String args[]) {

		SqlSession session =SessionManager.getInstance().getSession();
		
		if (session != null) {
			System.out.println("创建连接成功！");
		}

		String sql1 = "My.Batis.One.Mapping.userMapper.insertOne";
		String sql2 = "My.Batis.One.Mapping.userMapper.insertOneWithoutId";
		String sql3 = "My.Batis.One.Mapping.userMapper.updateUser";
		String sql4 = "My.Batis.One.Mapping.userMapper.deleteUser";
		String sql5 = "My.Batis.One.Mapping.userMapper.selectById";
		String sql6 = "My.Batis.One.Mapping.userMapper.selectById2";

		User user= session.selectOne(sql6, 1);
		System.out.println(user.getBlogs().size());
		session.commit();
		session.close();

	}
}
