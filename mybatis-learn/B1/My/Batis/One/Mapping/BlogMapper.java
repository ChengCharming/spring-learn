package My.Batis.One.Mapping;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import My.Batis.One.Pojo.Blog;
import My.Batis.One.Pojo.User;

public interface BlogMapper {
	@Select("insert into blog (userId,title,content) values(#{userId},#{title},#{content})")
	@Options(keyProperty ="id",useGeneratedKeys=true)
	void insertBlog(Blog blog);
	
	@Update("update blog set userId=#{userId},title =#{title},content =#{content} where id =#{id}")
	void updateBlog(Blog blog);
	
	@Delete("delete from blog where id =#{id}")
	void delete(int id);
	
	@Select("select * from blog")
	List<Blog> selectAll();
	
	@Select("select * from blog where id =#{id}")
	Blog selectById(int id);
	
	@Select("select * from blog where userId =#{userId}")
	List<Blog> selectAllByUserId(int userid);
	
	@Select("select * from blog where userId =#{userId}")
	@Results(value={
			@Result(property ="id",column ="id"),
			@Result(property ="userId",column ="userId"),
			@Result(property ="title",column ="title"),
			@Result(property ="content",column ="content"),
			@Result(property ="author",column ="userId",javaType =User.class,
			many=@Many(select ="My.Batis.One.Mapping.userMapper.selectById")),
	})
	List<Blog> selectById2(int id);
	
	
	
}
