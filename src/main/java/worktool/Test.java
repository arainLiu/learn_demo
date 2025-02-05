package worktool;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author arainliu
 * @date 2024/11/8
 */
public class Test {

    public static void main(String[] args) {

        List<String> keys = Arrays.asList("startLat", "startLon", "startShortAddr", "startCityCode", "startCityName",
                "endLat", "endLon", "endShortAddr", "endCityCode", "endCityName");

        for (String key : keys) {

        }

        //代码中配置
        List<String> listOld = Lists.newArrayList("104_17873","1001_18100","1001_17361","1001_18099","1001_17409","3435_18060","3435_16919","3435_17707","3435_17706","2840_17501","1001_17732","1001_17735","1001_17734","1001_17721","1001_17733","1001_17719","1001_17720","1245_17859","103_16929","1238_17864","1238_17863","3435_17708","2840_14221","2840_14220","2840_14218","2840_11939"





        );

        //配置文件中配置
        List<String> listNew = Lists.newArrayList("2840_11939","104_17873","1001_17409","3435_17708","3435_17707","3435_17706","1245_17859","1001_18100","103_16929","1001_18099","1001_17815","1001_17817","1001_17816","1001_17819","1001_17818","1001_17719","1001_17721","1001_17720","1001_17735","1001_17732","1001_17734","1001_17733","3435_18060","2840_14218","2840_14221","2840_14220","2840_17501","1238_17864","1238_17863","1001_17361","3435_16919"


        );

        final List<String> c1 = listOld.stream().filter(x -> !listNew.contains(x)).collect(Collectors.toList());
        final List<String> c2 = listNew.stream().filter(x -> !listOld.contains(x)).collect(Collectors.toList());

        System.out.println("第1个列表剩余：" + c1);
        System.out.println("第2个列表剩余：" + c2);

    }
}
