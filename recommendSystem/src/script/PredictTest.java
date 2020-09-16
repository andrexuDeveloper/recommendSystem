package script;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import service.DataProcess;
import util.FileTool;
import entity.Score;


public class PredictTest {
	public static void main(String[] args) throws Exception {
		String inputDir = "data/xuhongcao/";
		//String outputDir = "data/fresh_comp_offline/sample/";
		//String inputDir = "data/fresh_comp_offline/sample/";
		//String outputDir = "data/fresh_comp_offline/sample/out/";
//		String inputDir = args[0];
		String outputDir = "data/xuhongcao/predict/";
		//String userPath = inputDir + "tianchi_fresh_comp_train_user.csv";

		String inputPath = inputDir + "score";

		String outputPath = outputDir + "predict.txt";


        //生产的userId
		String userDir = "data/xuhongcao/sort/";
		
		Map<String, List<Score>> scoreMap = FileTool.loadScoreMap(inputPath, false, "\t");
		DataProcess.sortScoreMap(scoreMap);
		/**
		 * 取排序后的权重，文件
		 */
		List<String> fileNameList = FileTool.traverseFolder(userDir);


		Map<String, Set<String>> predictMap = DataProcess.predict(scoreMap, fileNameList, userDir, 5, 5);
		FileTool.initWriter1(outputPath);

		DataProcess.outputRecommendList(predictMap);
		FileTool.closeWriter1();
		scoreMap.clear();
	}
}
