package com.java.test.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : heibai
 * @description : 转换图片地址为github地址工具类
 */
public class ChangeImageUrl {

    public static void main(String[] args) throws Exception {

        if (args.length < 1) {
            System.out.println("请传递路径");
            return;
        }

        String dir = args[0];

        String preUrl = "https://github.com/heibaiying/LearningNotes/blob/master/picture/";
        String regex = "(!\\[(\\S*)]\\(D:\\\\LearningNotes\\\\picture\\\\(\\S*)\\)[^(</br>)]*?)";
        String regexRemove = "</br>.*https://github.com/heibaiying/LearningNotes/blob/master/picture.*</br>";

        List<String> filesList = getAllFile(dir, new ArrayList<>());
        for (String filePath : filesList) {
            changeImageUrl(filePath, preUrl, regex, regexRemove);
        }
        System.out.println("图片地址转换成功！");
    }


    private static void changeImageUrl(String filePath, String preUrl, String oldImageUrlRegex, String regexRemove) throws IOException {

        FileReader reader = new FileReader(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = new char[1024 * 1024];
        int read = 0;
        while ((read = reader.read(chars)) != -1) {
            stringBuilder.append(new String(chars, 0, read));
        }
        reader.close();
        String content = stringBuilder.toString();
        String newContent = content.replaceAll(regexRemove, "")
                .replaceAll(oldImageUrlRegex, String.format("$1</br>![$2](%s$3)</br>", preUrl));
        FileWriter fileWriter = new FileWriter(new File(filePath));
        fileWriter.write(newContent);
        fileWriter.flush();

    }

    private static List<String> getAllFile(String dir, List<String> filesList) {
        File file = new File(dir);
        //如果是文件 则不遍历
        if (file.isFile() && file.getName().endsWith(".md")) {
            filesList.add(file.getAbsolutePath());
        }
        //如果是文件夹 则遍历下面的所有文件
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory() && !f.getName().startsWith(".")) {
                    getAllFile(f.getAbsolutePath(), filesList);
                } else if (f.getName().endsWith(".md")) {
                    filesList.add(f.getAbsolutePath());
                }
            }
        }
        return filesList;
    }

}
