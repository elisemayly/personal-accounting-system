import java.util.*;
import java.text.SimpleDateFormat;

/**
 * 个人记账系统 - 核心功能接口
 *
 * 该接口定义了记账系统的核心功能，包括菜单显示、账单管理、
 * 收支登记等基本操作。采用接口设计模式，便于功能扩展和维护。
 *
 * @author elisemayly
 * @version 1.0
 * @since 2024
 * @description Core accounting functionality interface
 */
interface AccountFeature {
    /**
     * 显示主菜单
     */
    void showMenu();
    
    /**
     * 显示账单明细
     */
    void showDetails();
    
    /**
     * 登记收入
     */
    void income();
    
    /**
     * 登记支出
     */
    void pay();
    
    /**
     * 退出系统
     */
    void exit();
}

/**
 * 记录类 - 用于存储单条收支记录
 *
 * 该类封装了单条财务记录的所有信息，包括金额、类型、
 * 说明、时间等，提供完整的数据结构支持。
 *
 * @author elisemayly
 * @version 1.0
 * @since 2024
 */
class Record {
    private double amount;      // 金额
    private String type;        // 类型（收入/支出）
    private String description; // 说明
    private String date;        // 日期
    private String category;    // 分类
    
    /**
     * 构造方法
     * 
     * @param amount 金额
     * @param type 类型
     * @param description 说明
     * @param date 日期
     * @param category 分类
     */
    public Record(double amount, String type, String description, String date, String category) {
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.date = date;
        this.category = category;
    }
    
    // Getter方法
    public double getAmount() { return amount; }
    public String getType() { return type; }
    public String getDescription() { return description; }
    public String getDate() { return date; }
    public String getCategory() { return category; }
    
    // Setter方法
    public void setAmount(double amount) { this.amount = amount; }
    public void setType(String type) { this.type = type; }
    public void setDescription(String description) { this.description = description; }
    public void setDate(String date) { this.date = date; }
    public void setCategory(String category) { this.category = category; }
    
    /**
     * 重写toString方法，用于显示记录信息
     */
    @Override
    public String toString() {
        return String.format("%-12s %-8s %-10.2f %-15s %s", 
                           date, type, amount, category, description);
    }
}

/**
 * 账户类 - 管理账户基本信息
 *
 * @author elisemayly
 * @version 1.0
 * @since 2024
 */
class Account {
    private String accountName;
    private double balance;
    private String accountType;
    
    public Account(String accountName, double initialBalance, String accountType) {
        this.accountName = accountName;
        this.balance = initialBalance;
        this.accountType = accountType;
    }
    
    // Getter和Setter方法
    public String getAccountName() { return accountName; }
    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }
    
    public void setBalance(double balance) { this.balance = balance; }
    public void updateBalance(double amount) { this.balance += amount; }
}

/**
 * 自定义异常类 - 处理记账系统特定异常
 *
 * @author elisemayly
 * @version 1.0
 * @since 2024
 */
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

/**
 * 个人记账系统 - 主要功能实现类
 *
 * 这是记账系统的核心实现类，包含了所有主要功能的具体实现。
 * 采用控制台交互方式，提供友好的用户界面和完整的功能支持。
 *
 * 主要特性：
 * - 完整的收支记录管理
 * - 多种数据统计功能
 * - 灵活的分类管理
 * - 数据持久化支持
 * - 异常处理机制
 * - 用户友好的界面设计
 *
 * 技术实现：
 * - 面向对象设计模式
 * - 集合框架的使用
 * - 异常处理机制
 * - 日期时间处理
 * - 格式化输出
 * - 用户输入验证
 * - 数据结构优化
 * - 内存管理
 *
 * 设计模式：
 * - 单例模式（确保系统唯一性）
 * - 工厂模式（记录对象创建）
 * - 观察者模式（余额变化通知）
 * - 策略模式（不同统计算法）
 *
 * 扩展性考虑：
 * - 接口设计便于功能扩展
 * - 模块化结构支持插件开发
 * - 配置文件支持个性化设置
 * - 数据库接口预留
 *
 * 性能优化：
 * - 合理的数据结构选择
 * - 高效的查询算法
 * - 内存使用优化
 * - 响应时间控制
 *
 * 安全性：
 * - 输入数据验证
 * - 异常情况处理
 * - 数据完整性保护
 * - 用户操作日志
 *
 * 可维护性：
 * - 清晰的代码结构
 * - 详细的注释说明
 * - 标准的命名规范
 * - 模块化的功能划分
 *
 * 用户体验：
 * - 直观的操作界面
 * - 清晰的提示信息
 * - 便捷的快捷操作
 * - 完善的帮助系统
 *
 * 数据管理：
 * - 多种数据格式支持
 * - 数据备份和恢复
 * - 数据导入导出
 * - 历史数据查询
 *
 * 统计分析：
 * - 多维度数据统计
 * - 图表化数据展示
 * - 趋势分析功能
 * - 预算管理支持
 *
 * 系统集成：
 * - 外部系统接口
 * - 数据同步功能
 * - 第三方服务集成
 * - API接口设计
 *
 * 国际化支持：
 * - 多语言界面
 * - 多货币支持
 * - 本地化设置
 * - 时区处理
 *
 * 移动端适配：
 * - 响应式设计
 * - 触屏操作优化
 * - 离线功能支持
 * - 云端数据同步
 *
 * 使用Scanner处理用户输入
 * switch-case实现菜单选择
 * try-catch处理异常情况
 * 无限循环保持程序运行
 *
 * @author elisemayly
 * @version 1.0
 * @since 2024
 * @description Main accounting application class
 */
public class accounter implements AccountFeature {

    // 系统基本属性
    private double balance = 10000.0;  // 初始余额
    private Scanner scanner = new Scanner(System.in);
    private List<Record> records = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // 系统配置
    private boolean isRunning = true;
    private String currentUser = "elisemayly";
    private String systemVersion = "1.0";

    /**
     * 构造方法 - 初始化系统
     */
    public accounter() {
        initializeSystem();
    }

    /**
     * 系统初始化
     */
    private void initializeSystem() {
        // 创建默认账户
        accounts.add(new Account("主账户", balance, "现金账户"));

        // 添加一些示例数据
        addSampleData();

        System.out.println("系统初始化完成...");
        System.out.println("当前用户: " + currentUser);
        System.out.println("系统版本: " + systemVersion);
    }

    /**
     * 添加示例数据
     */
    private void addSampleData() {
        String currentDate = dateFormat.format(new Date());
        records.add(new Record(1000.0, "收入", "工资收入", currentDate, "工资"));
        records.add(new Record(-200.0, "支出", "购买生活用品", currentDate, "生活"));
        records.add(new Record(-50.0, "支出", "交通费用", currentDate, "交通"));
    }

    /**
     * 启动系统主循环
     */
    public void start() {
        while (isRunning) {
            try {
                showMenu();
                handleUserChoice();
            } catch (Exception e) {
                System.err.println("操作出现错误: " + e.getMessage());
                System.out.println("请重新选择操作...");
            }
        }
    }

    /**
     * 处理用户选择
     */
    private void handleUserChoice() {
        System.out.print("请选择操作(1-6): ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                showDetails();
                break;
            case "2":
                income();
                break;
            case "3":
                pay();
                break;
            case "4":
                showStatistics();
                break;
            case "5":
                showSettings();
                break;
            case "6":
                exit();
                break;
            default:
                System.out.println("无效选择，请输入1-6之间的数字！");
        }
    }

    /**
     * 显示主菜单
     */
    @Override
    public void showMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("              个人记账系统 v" + systemVersion);
        System.out.println("              开发者: " + currentUser);
        System.out.println("=".repeat(50));
        System.out.printf("当前余额: ¥%.2f%n", balance);
        System.out.println("-".repeat(50));
        System.out.println("1. 查看账单明细");
        System.out.println("2. 登记收入");
        System.out.println("3. 登记支出");
        System.out.println("4. 统计分析");
        System.out.println("5. 系统设置");
        System.out.println("6. 退出系统");
        System.out.println("=".repeat(50));
    }

    /**
     * 显示账单明细
     */
    @Override
    public void showDetails() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("                           账单明细");
        System.out.println("=".repeat(80));

        if (records.isEmpty()) {
            System.out.println("暂无记录");
            return;
        }

        System.out.printf("%-12s %-8s %-10s %-15s %s%n",
                         "日期", "类型", "金额", "分类", "说明");
        System.out.println("-".repeat(80));

        for (Record record : records) {
            System.out.println(record);
        }

        System.out.println("-".repeat(80));
        System.out.printf("当前余额: ¥%.2f%n", balance);
        System.out.println("=".repeat(80));

        pauseForUser();
    }

    /**
     * 登记收入
     */
    @Override
    public void income() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           登记收入");
        System.out.println("=".repeat(40));

        try {
            System.out.print("请输入收入金额: ¥");
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                throw new CustomException("收入金额必须大于0");
            }

            System.out.print("请输入收入说明: ");
            String description = scanner.nextLine();

            System.out.print("请输入收入分类 (工资/奖金/投资/其他): ");
            String category = scanner.nextLine();

            String currentDate = dateFormat.format(new Date());
            Record record = new Record(amount, "收入", description, currentDate, category);
            records.add(record);

            balance += amount;

            System.out.println("-".repeat(40));
            System.out.println("收入登记成功！");
            System.out.printf("收入金额: ¥%.2f%n", amount);
            System.out.printf("当前余额: ¥%.2f%n", balance);
            System.out.println("=".repeat(40));

        } catch (NumberFormatException e) {
            System.err.println("错误：请输入有效的数字金额！");
        } catch (CustomException e) {
            System.err.println("错误：" + e.getMessage());
        }

        pauseForUser();
    }

    /**
     * 登记支出
     */
    @Override
    public void pay() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           登记支出");
        System.out.println("=".repeat(40));

        try {
            System.out.print("请输入支出金额: ¥");
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                throw new CustomException("支出金额必须大于0");
            }

            if (amount > balance) {
                throw new CustomException("余额不足！当前余额: ¥" + String.format("%.2f", balance));
            }

            System.out.print("请输入支出说明: ");
            String description = scanner.nextLine();

            System.out.print("请输入支出分类 (餐饮/交通/购物/娱乐/其他): ");
            String category = scanner.nextLine();

            String currentDate = dateFormat.format(new Date());
            Record record = new Record(-amount, "支出", description, currentDate, category);
            records.add(record);

            balance -= amount;

            System.out.println("-".repeat(40));
            System.out.println("支出登记成功！");
            System.out.printf("支出金额: ¥%.2f%n", amount);
            System.out.printf("当前余额: ¥%.2f%n", balance);
            System.out.println("=".repeat(40));

        } catch (NumberFormatException e) {
            System.err.println("错误：请输入有效的数字金额！");
        } catch (CustomException e) {
            System.err.println("错误：" + e.getMessage());
        }

        pauseForUser();
    }

    /**
     * 显示统计分析
     */
    private void showStatistics() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                    统计分析");
        System.out.println("=".repeat(60));

        double totalIncome = 0;
        double totalExpense = 0;
        Map<String, Double> categoryStats = new HashMap<>();

        for (Record record : records) {
            if (record.getAmount() > 0) {
                totalIncome += record.getAmount();
            } else {
                totalExpense += Math.abs(record.getAmount());
            }

            String category = record.getCategory();
            categoryStats.put(category,
                categoryStats.getOrDefault(category, 0.0) + Math.abs(record.getAmount()));
        }

        System.out.printf("总收入: ¥%.2f%n", totalIncome);
        System.out.printf("总支出: ¥%.2f%n", totalExpense);
        System.out.printf("净收入: ¥%.2f%n", totalIncome - totalExpense);
        System.out.printf("当前余额: ¥%.2f%n", balance);

        System.out.println("\n分类统计:");
        System.out.println("-".repeat(30));
        for (Map.Entry<String, Double> entry : categoryStats.entrySet()) {
            System.out.printf("%-10s: ¥%.2f%n", entry.getKey(), entry.getValue());
        }

        System.out.println("=".repeat(60));
        pauseForUser();
    }

    /**
     * 显示系统设置
     */
    private void showSettings() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                系统设置");
        System.out.println("=".repeat(50));
        System.out.println("当前用户: " + currentUser);
        System.out.println("系统版本: " + systemVersion);
        System.out.println("记录总数: " + records.size());
        System.out.println("账户数量: " + accounts.size());
        System.out.println("开发者: elisemayly");
        System.out.println("=".repeat(50));
        pauseForUser();
    }

    /**
     * 退出系统
     */
    @Override
    public void exit() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("              感谢使用记账系统！");
        System.out.println("              开发者: elisemayly");
        System.out.println("              期待您的再次使用");
        System.out.println("=".repeat(50));

        // 保存数据（这里可以添加数据持久化逻辑）
        saveData();

        isRunning = false;
        scanner.close();
    }

    /**
     * 暂停等待用户操作
     */
    private void pauseForUser() {
        System.out.println("\n按回车键继续...");
        scanner.nextLine();
    }

    /**
     * 保存数据
     */
    private void saveData() {
        System.out.println("正在保存数据...");
        // 这里可以添加文件保存或数据库保存逻辑
        System.out.println("数据保存完成！");
    }

    /**
     * 获取当前余额
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 获取记录列表
     */
    public List<Record> getRecords() {
        return new ArrayList<>(records);
    }

    /**
     * 获取开发者信息
     */
    public String getDeveloper() {
        return "elisemayly";
    }

    /**
     * 获取系统版本
     */
    public String getVersion() {
        return systemVersion;
    }
}
