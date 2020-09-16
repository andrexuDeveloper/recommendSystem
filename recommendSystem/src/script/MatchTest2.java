package script;

import java.util.List;
import java.util.Map;

import service.DataProcess;
import util.FileTool;


/**
 *  //将预测列表与测试集进行匹配，计算预测准确率及召回率
 *  precision=20.0,recall=0.9727626459143969,f1=1.8552875695732838
 */
public class MatchTest2 {

	public static void main(String[] args) throws Exception {
//		String inputDir = args[0];
//		String inputPath1 = inputDir + args[1];
//		String userDir = args[2];

//		String inputDir = args[0];
		String inputPath1 = "data/xuhongcao/predict.txt";
		String userDir = "data/xuhongcao/sort/";

		Map<String, List<String>> predictMap = FileTool.loadPredictData(inputPath1, false, ",");
		int predictN = FileTool.count;
		System.out.println(predictN);
		FileTool.count = 0;
		Map<String, List<String>> referenceMap = FileTool.loadTestData(predictMap, userDir, false, "\t");
		int referenceN = FileTool.count;
		System.out.println(referenceN);
		DataProcess.prediction(predictMap, predictN, referenceMap, referenceN);
	}

}
