package com.nirvana.travel.leetcode.l_280_trie;

/**
 * @author arainliu
 * @date 2021/6/29
 */
public class Trie {

  private Trie[] children;

  private Boolean isEnd;

  /** Initialize your data structure here. */
  public Trie() {
    children = new Trie[26];
    isEnd = false;
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    if (word == null || word.length() == 0) {
      return;
    }

    Trie node= this;
    for (int i = 0; i < word.length(); i ++) {
      char ch = word.charAt(i);
      int index = ch - 'a';
      if (node.children == null) {
        node.children[index] = new Trie();
      }
      node = node.children[index];
    }

    node.isEnd = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    Trie trie = searchPrefix(word);
    return trie != null && trie.isEnd;
  }

  public Trie searchPrefix(String prefix) {
    if (prefix == null || prefix.length() == 0) {
      return null;
    }

    Trie node = this;
    for (int i = 0; i < prefix.length(); i ++) {
      int index = prefix.charAt(i) - 'a';
      if (node.children[i] == null) {
        return null;
      }
      node = node.children[index];
    }

    return node;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    return searchPrefix(prefix) != null;
  }

}
