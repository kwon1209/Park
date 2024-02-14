package sec03.brd01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private DataSource dataFactory;
	Connection conn;
	PreparedStatement pstmt;

	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/mariaDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List selectAllArticles() {
		List articlesList = new ArrayList();
		try {
			conn = dataFactory.getConnection();
			
			
			String query = "WITH RECURSIVE cte AS ("
			        + "  SELECT articleNO, parentNO, title, content, id, writeDate, 1 AS level"
			        + "  FROM t_board"
			        + "  WHERE parentNO = 0"
			        + "  UNION ALL"
			        + "  SELECT child.articleNO, child.parentNO, child.title, child.content, child.id, child.writeDate, parent.level + 1"
			        + "  FROM t_board AS child"
			        + "  INNER JOIN cte AS parent ON child.parentNO = parent.articleNO"
			        + ")"
			        + "SELECT * FROM cte ORDER BY level, articleNO DESC";
			 
				/*
				 * String query =
				 * "SELECT articleNO,parentNO,title,content,id,writeDate,1 AS LEVEL"
				 * +"FROM t_board" +"WHERE parentNO = 0"
				 * 
				 * +"UNION ALL"
				 * 
				 * +"SELECT child.articleNO,child.parentNO,child.title,child.content,child.id,child.writeDate,parent.LEVEL + 1"
				 * +"FROM t_board AS child"
				 * +"INNER JOIN RecursiveCTE AS parent ON child.parentNO = parent.articleNO"
				 * +"SELECT LEVEL,articleNO,parentNO,title,content,id,writeDate"
				 * +"FROM RecursiveCTE" +"ORDER BY LEVEL, articleNO DESC";
				 */
		

			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int level = rs.getInt("level");
				int articleNO = rs.getInt("articleNO");
				int parentNO = rs.getInt("parentNO");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				ArticleVO article = new ArticleVO();
				article.setLevel(level);
				article.setArticleNO(articleNO);
				article.setParentNO(parentNO);
				article.setTitle(title);
				article.setContent(content);
				article.setId(id);
				article.setWriteDate(writeDate);
				articlesList.add(article);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articlesList;
	}
}
