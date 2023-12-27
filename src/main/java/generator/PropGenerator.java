package main.java.generator;

import main.java.constant.*;
import main.java.content.platform.BasePlatform;
import main.java.content.substance.Coin;
import main.java.content.substance.Prop;
import main.java.service.Service;

public class PropGenerator {
    public static void build(BasePlatform platform) {

        int y = platform.getY();
        int x = platform.getX();

        int buildX = CommonUtils.nextInt(x,x + PlatformConstant.WIDTH - PropConstant.PROP_WIDTH);
        int buildY = y - PropConstant.PROP_HEIGHT;

        PropType type = choosePropType();
        Prop prop = null;

        switch (type) {
            case COIN :
                prop = new Coin(buildX,buildY);
                prop.moveWithPlatform(platform);
                platform.setProp(prop);
                break;
        }

        Service.substance.add(prop);
    }

    /**
     * 采用随机数选择道具类型
     * @return 随机的道具类型
     */
    public static PropType choosePropType() {
        //int i = CommonUtils.nextInt(0,PropType.values().length);
        return PropType.COIN;
    }
}
