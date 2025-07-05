/**
 * 个人记账系统 - 主程序入口
 *
 * 这是一个基于Java控制台的个人财务管理系统，提供完整的收支记录、
 * 账单管理、数据统计等功能。系统采用面向对象设计，代码结构清晰，
 * 注释详细，适合Java学习者参考和个人日常使用。
 *
 * 主要功能包括：
 * - 收入支出记录管理
 * - 账单分类和统计
 * - 余额计算和查询
 * - 历史记录查看
 * - 数据导入导出
 *
 * 适用场景：
 * - 个人日常财务管理
 * - 学生生活费管理
 * - 小额资金流水记录
 * - Java编程学习和实践
 *
 * @author elisemayly
 * @version 1.0
 * @since 2024
 * @description Personal Accounting System
 */
public class Main {

    /**
     * 程序主入口方法
     * 
     * 初始化记账系统并启动主程序循环。
     * 创建accounter实例并调用其主要功能方法。
     * 
     * @param args 命令行参数（本程序暂不使用）
     */
    public static void main(String[] args) {
        // 输出程序启动信息
        System.out.println("=================================");
        System.out.println("    欢迎使用个人记账系统 v1.0");
        System.out.println("    开发者: elisemayly");
        System.out.println("    功能: 个人财务管理助手");
        System.out.println("=================================");
        System.out.println();
        
        // 创建记账系统实例
        accounter accountSystem = new accounter();
        
        // 启动主程序
        try {
            accountSystem.start();
        } catch (Exception e) {
            System.err.println("程序运行出现错误: " + e.getMessage());
            System.err.println("请联系开发者 elisemayly 获取技术支持");
        }
        
        // 程序结束提示
        System.out.println();
        System.out.println("=================================");
        System.out.println("    感谢使用个人记账系统！");
        System.out.println("    期待您的再次使用");
        System.out.println("=================================");
    }
    
    /**
     * 获取程序版本信息
     * 
     * @return 版本号字符串
     */
    public static String getVersion() {
        return "1.0";
    }
    
    /**
     * 获取开发者信息
     * 
     * @return 开发者名称
     */
    public static String getDeveloper() {
        return "elisemayly";
    }
}
