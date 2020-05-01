package cn.manager.util;

import cn.manager.entity.Voca;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class VocaReader {

    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("C:\\Users\\Ramble\\Desktop\\English\\大学英语B级常用短语.doc等2个文件\\大学英语B级词汇表_带音标.txt"));
        List<Voca> vocaList = new ArrayList<>(8000);

        lines.forEach(s -> {
            if (s.contains("[")) {
                String[] res = s.split("\\[");
                String[] res1 = res[1].split("]");
                String content = res[0];
                String phonetic = res1[0];
                String chinese = null;
                try {
                    chinese = res1[1];
                } catch (Exception e) {
                    System.out.println(content);
                }

                Voca v = new Voca();
                v.setContent(content);
                v.setPhonetic(phonetic);
                v.setChinese(chinese);

                vocaList.add(v);
            }
        });

        System.out.println(vocaList.size());
    }
}
