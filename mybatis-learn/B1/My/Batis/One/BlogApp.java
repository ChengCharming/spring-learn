package My.Batis.One;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import My.Batis.One.Mapping.BlogMapper;
import My.Batis.One.Pojo.Blog;

public class BlogApp {
	
	
	public static void main (String args[]) {
	SqlSession session = SessionManager.getInstance().getSession();
	BlogMapper blogMapper =session.getMapper(BlogMapper.class);

//	Blog b1=new Blog();
//	b1.setContent("content 2");
//	b1.setUserId(1);
//	b1.setTitle("title 2");
//	blogMapper.insertBlog(b1);	
//	Blog b = blogMapper.selectById2(3);

	List<Blog> blogs= blogMapper.selectById2(1);
	
	for(Blog bs:blogs) {
		System.out.println(bs.getTitle());
		System.out.println(bs.getAuthor().getId());
	}
	
	session.commit();
	session.close();
	}
}
