package com.nirvana.travel.javabase.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author liupengyu10336@hellobike.com
 * @date 2021/3/27
 */
public class TimeClient {

  public static void main(String[] args) {
    int port = 8080;
    Socket socket = null;
    BufferedReader in = null;
    PrintWriter out = null;
    try {
      while (true) {
        socket = new Socket("127.0.0.1", port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Query Time Order");
        System.out.println("Send order 2 server succeed.");
        String resp = in.readLine();
        System.out.println("Now is : " + resp);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

      try {
        in.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

      out.close();
      out = null;
    }
  }

}
