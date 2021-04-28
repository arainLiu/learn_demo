package com.nirvana.travel.lucene;

import java.io.IOException;
import java.nio.file.Paths;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * @author arainliu
 * @date 2020/11/11
 */
public class LuceneSearch {

  public static void main(String[] args) throws ParseException, IOException {
    //1. 创建Query搜索对象
    //创建分词器
    Analyzer analyzer = new StandardAnalyzer();
    // 创建搜索解析器，第一个参数:默认Field域，第二个参数:分词器
    QueryParser queryParser = new QueryParser("name", analyzer);
    //创建搜索对象
    Query query = queryParser.parse("id:B1");
    //2. 创建Directory流对象,声明索引库位置
    Directory directory = FSDirectory.open(Paths.get("/Users/liupengyu/code/lucene"));
    //3. 创建索引读取对象IndexReader
    IndexReader reader = DirectoryReader.open(directory);
    //4. 创建索引搜索对象
    IndexSearcher searcher = new IndexSearcher(reader);
    //5. 使用索引搜索对象，执行搜索，返回结果集TopDocs
    //第一个参数:搜索对象，第二个参数:返回的数据条数，指定查询结果最顶部的n条数据返回
    TopDocs topDocs = searcher.search(query, 10);
    System.out.println("查询到的数据总条数是:" + topDocs.totalHits);
    // 获取查询结果集
    ScoreDoc[] docs = topDocs.scoreDocs;
    //6. 解析结果集
    for (ScoreDoc scoreDoc : docs) {
    // 获取文档
      int docID = scoreDoc.doc;
      Document doc = searcher.doc(docID);
      System.out.println("=============================");
      System.out.println("docID:" + docID);
      System.out.println("id:" + doc.get("id"));
      System.out.println("name:" + doc.get("name"));
      System.out.println("num:" + doc.get("num"));
      System.out.println("desc:" + doc.get("desc"));

    }
    reader.close();
  }
}
