package com.nirvana.travel.lucene;

import java.io.IOException;
import java.nio.file.Paths;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * @author arainliu
 * @date 2020/11/10
 */
public class LuceneUpdate {

  public static void main(String[] args) throws IOException {

    //1.创建Analyzer分词器,分析文档，对文档进行分词
    Analyzer analyzer = new StandardAnalyzer();
    //2. 创建Directory对象,声明索引库的位置
    Directory directory = FSDirectory.open(Paths.get("/Users/liupengyu/code/lucene"));
    //3. 创建IndexWriteConfig对象，写入索引需要的配置 IndexWriterConfig config = new IndexWriterConfig(analyzer);
    IndexWriterConfig config = new IndexWriterConfig(analyzer);

    //4.创建IndexWriter写入对象
    IndexWriter indexWriter = new IndexWriter(directory, config);

    Document document = new Document();
    document.add(new TextField("id", "B1", Store.YES));
    document.add(new TextField("name", "测试修改书名", Store.YES));
    document.add(new IntPoint("name", 3));
    document.add(new TextField("desc", "测试修改描述", Store.YES));

    //5.执行更新，会把所有符合条件的Document删除，再新增
    indexWriter.updateDocument(new Term("id", "B7"),document);

    // 8.释放资源
    indexWriter.close();
    System.out.println("success");
  }
}
