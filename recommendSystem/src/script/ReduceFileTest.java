package script;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import entity.User;
import service.DataProcess;
import util.FileTool;


/**
 * 生产权重文件,并根据权重排序
 */
public class ReduceFileTest {
    public static void main(String[] args) throws Exception {
        String inputDir = "data/xuhongcao2/";
        String outputDir = "data/xuhongcao2/sort/";


        //String inputDir = "data/fresh_comp_offline/sample/";
        //String outputDir = "data/fresh_comp_offline/sample/out/";
//		String inputDir = args[0];
//		String outputDir = args[1];
        //String userPath = inputDir + "tianchi_fresh_comp_train_user.csv";
        //String itemPath = inputDir + args[2];
        //String userPath = inputDir + args[3];
        long start = System.currentTimeMillis();
        List<String> pathList = FileTool.traverseFolder(inputDir);
        for (String path : pathList) {

            if (path.contains(".txt")||path.contains("sort")) {
                System.out.println(path);
                continue;
            }

            List<User> userList = FileTool.readFileOne(inputDir + path, false, "\t", "user");

            List<User> list = DataProcess.reduceUserByItem(userList);

            userList.clear();


            File dir=new File(outputDir);
            if(dir.exists()){
                dir.mkdir();
            }



            FileTool.initWriter1(outputDir + path);
            Collections.sort(list);
            DataProcess.outputUser(list);

            FileTool.closeWriter1();
            list.clear();
        }

        long end = System.currentTimeMillis();

        System.out.println("======userId done============" + (start - end) / 1000);
    }
}
