package main.java.generator;

import main.java.constant.*;
import main.java.content.platform.BasePlatform;
import main.java.content.platform.FakePlatform;
import main.java.content.platform.NormalPlatform;
import main.java.content.platform.SpikePlatform;

/**
 * 平台生成器，用于随机生成不同类型的平台。
 */
public class PlatformGenerator {

    /**
     * 随机创建一个平台。
     *
     * @return 随机生成的平台。
     */
    public static BasePlatform build() {
        BasePlatform platform = null;
        // 获取在合适范围的随机 x 坐标
        int x = CommonUtils.nextInt(EntityConstant.WALL_LENGTH,
                FrameConstant.FRAME_WIDTH - EntityConstant.WALL_LENGTH - PlatformConstant.WIDTH - 24 * 11);
        // 随机选择平台类型
        PlatformType type = choosePlatformType();
        // 生成平台
        switch (type) {
            case FAKE:
                platform = new FakePlatform(x, FrameConstant.FRAME_HEIGHT);
                PropGenerator.build(platform);
                break;
            case SPIKE:
                platform = new SpikePlatform(x, FrameConstant.FRAME_HEIGHT);
                break;
            case NORMAL:
                platform = new NormalPlatform(x, FrameConstant.FRAME_HEIGHT);
                PropGenerator.build(platform);
                break;
        }
        PlatformConstant.PLATFORM_COUNT++;
        return platform;
    }

    /**
     * 采用随机数选择平台类型。
     *
     * @return 随机的平台类型。
     */
    public static PlatformType choosePlatformType() {
        int i = CommonUtils.nextInt(0, 100);
        if (i < 50) {
            return PlatformType.NORMAL;
        } else if (i < 80) {
            return PlatformType.FAKE;
        } else {
            return PlatformType.SPIKE;
        }
    }
}
