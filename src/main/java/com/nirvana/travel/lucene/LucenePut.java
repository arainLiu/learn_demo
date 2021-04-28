package com.nirvana.travel.lucene;

import com.alibaba.fastjson.JSON;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import org.apache.commons.compress.utils.Lists;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * @author arainliu
 * @date 2020/11/10
 */
public class LucenePut {

  public static void main(String[] args) throws IOException {
    ClassLoader classLoader = LucenePut.class.getClassLoader();
    String filePath = classLoader.getResource("luceneTest.json").getFile();
    System.out.println(filePath);
    String jsonStr = getJsonStr(filePath);
    //1.采集数据
    List<BookEntity> bookEntities = JSON.parseArray(jsonStr, BookEntity.class);
    //2. 创建文档对象
    List<Document> documents = Lists.newArrayList();
    for (BookEntity bookEntity : bookEntities) {
      Document document = new Document();
      //document文档中添加Field域
      document.add(new TextField("id", bookEntity.getId(), Store.YES));
      document.add(new TextField("name", bookEntity.getName(), Store.YES));
      document.add(new IntPoint("name", bookEntity.getNum()));
      document.add(new TextField("desc", bookEntity.getDesc(), Store.YES));

      documents.add(document);
    }

    System.out.println(documents);
    //3.创建Analyzer分词器,分析文档，对文档进行分词
    Analyzer analyzer = new StandardAnalyzer();
    //4. 创建Directory对象,声明索引库的位置
    Directory directory = FSDirectory.open(Paths.get("/Users/liupengyu/code/lucene"));
    // 5. 创建IndexWriteConfig对象，写入索引需要的配置 IndexWriterConfig config = new IndexWriterConfig(analyzer);
    IndexWriterConfig config = new IndexWriterConfig(analyzer);

    // 6.创建IndexWriter写入对象
    IndexWriter indexWriter = new IndexWriter(directory, config);

    // 7.写入到索引库，通过IndexWriter添加文档对象document for (Document doc : documents) {
    for (Document document : documents) {
      indexWriter.addDocument(document);
    }

    // 8.释放资源
    indexWriter.close();
  }


  private static String getJsonStr(String fileName) {
    String fileCode="";
    try {
      BufferedInputStream in = new BufferedInputStream(
        new FileInputStream(fileName));
      ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
      byte[] temp = new byte[1024];
      int size = 0;
      while ((size = in.read(temp)) != -1) {
        out.write(temp, 0, size);
      }
      in.close();

      byte[] content = out.toByteArray();
      fileCode = new String(content);

    } catch (Exception e) {
      System.out.println("fileReadeCode() Exception :" + e.getMessage());
    }
    return fileCode;
  }
}
