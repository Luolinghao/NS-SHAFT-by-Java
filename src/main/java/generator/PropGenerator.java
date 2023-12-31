package main.java.generator;

import main.java.constant.*;
import main.java.content.platform.BasePlatform;
import main.java.content.substance.*;
import main.java.content.substance.LifePotion;
import main.java.content.substance.Shield;
import main.java.service.Service;

import java.util.Random;

/**
 * 道具生成器
 * <p>负责道具生成相关功能逻辑的实现</p>
 */
public class PropGenerator {
    /**
     * 随机生成道具类型的对象
     * <p>默认道具在平台上生成并跟随平台移动</p>
     * @param platform 道具生成的平台
     */
    public static void build(BasePlatform platform) {

        //获取平台的坐标
        int y = platform.getY();
        int x = platform.getX();
        //选择平台上方随机位置
        int buildX = CommonUtils.nextInt(x,x + PlatformConstant.WIDTH - PropConstant.PROP_WIDTH);
        int buildY = y - PropConstant.PROP_HEIGHT;
        //随机获取生成道具的类型
        PropType type = choosePropType();
        Prop prop = null;
        //根据对应类型生成道具对象
        if(type!=null){
            switch (type) {
                case COIN :
                    prop = new Coin(buildX,buildY);
                    prop.moveWithPlatform(platform);
                    platform.setProp(prop);
                    break;
                case LIFE_POTION:
                    prop = new LifePotion(buildX,buildY);
                    prop.moveWithPlatform(platform);
                    platform.setProp(prop);
                    break;
                case SHIELD:
                    prop = new Shield(buildX,buildY);
                    prop.moveWithPlatform(platform);
                    platform.setProp(prop);
                    break;
            }
            //将生成的道具加入物质服务中进行相关维护
            Service.substance.add(prop);
        }

    }

    /**
     * 采用随机数选择道具类型
     * @return 随机的道具类型
     */
    public static PropType choosePropType() {
        Random random = new Random();
        int i = random.nextInt(6);
        PropType type = null;
        if(i==0){
            type = PropType.COIN;
        }
        else if(i==1){
            type = PropType.LIFE_POTION;
        }
        else if(i==2){
            type = PropType.SHIELD;
        }

        return  type;
    }
}
