package script;

import java.util.Map;
import java.util.Set;

import service.DataProcess;
import util.FileTool;


/**
 *   //对测试集文件进行map
 *
 */
public class MakeTestSet {
	public static void main(String[] args) throws Exception {
		//String inputDir = "data/fresh_comp_offline/";
		//String outputDir = "data/fresh_comp_offline/sample/";
		//String inputDir = "data/fresh_comp_offline/sample/";
		//String outputDir = "data/fresh_comp_offline/sample/out/";
//		String inputDir = args[0];
//		String outputDir = args[1];
		//String userPath = inputDir + "tianchi_fresh_comp_train_user.csv";


//		String inputPath = inputDir + args[2];
//		String outputPath = outputDir + args[3];

		String inputPath = "data/test.csv";
		String outputPath = "data/xuhongcao/scoretest.txt";

		Map<String, Set<String>> map = FileTool.loadTestUser(inputPath, false, ",");
		FileTool.initWriter1(outputPath);
		DataProcess.output(map);
		map.clear();
		FileTool.closeWriter1();
	}
}
