package com.lagou.test;

import com.lagou.domain.Article;
import com.lagou.mapper.ArticleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {
    public static void main(String[] args) throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlmapconfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);


        List<Article> article = mapper.findArticle();

        for (Article article1 : article) {

            System.out.println(article1);
        }

    }
}
