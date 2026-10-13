一、实验目的
1. 掌握 Android 中常用布局方式的使用方法，理解不同布局的适用场景。
2. 熟练使用 LinearLayout（线性布局） 、 TableLayout（表格布局） 、 ConstraintLayout（约束布局） 构建界面。
3. 理解layout_weight权重分配、gravity对齐、约束链（Chain）等核心属性的作用。
4. 学会通过 XML 布局文件与 Activity 的setContentView()关联，完成界面加载。

二、实验内容与实现
 
 实验 1：线性布局（4×4 网格）
在 activity_linear.xml 中，使用一个垂直方向的LinearLayout 作为根容器，内部嵌套 4 个水平方向的LinearLayout ，每行放置 4 个TextView ，形成 4×4 的网格。
关键技术点：
 子视图设置layout_width="0dp" 并配合layout_weight="1"，使每行 4 个文本框 等分屏幕宽度 ；
 使用`gravity="center"` 使文字居中，background="@android:drawable/box"添加边框效果。

实验 2：表格布局（菜单快捷键列表）
在 activity_table.xml 中，使用TableLayout 配合多个`TableRow` 实现了一个类似"文件菜单"的快捷键列表（Open/Save/Save As/Import/Export/Quit 及对应快捷键）。
关键技术点：
 每个TableRow代表一行，行内左列通过layout_weight="1"拉伸填满剩余空间，右列快捷键自然右对齐；
 TableLayout自动按列对齐，无需逐行手动设置宽度。

实验 3：约束布局（计算器界面）
在 activity_calc.xml 中，使用`ConstraintLayout` 实现计算器界面：顶部为输入提示TextView 和显示结果的EditText ，下方为 4×4 按钮阵列（数字 0–9、小数点及 +、−、×、÷、= 运算符）。
关键技术点：
 每个按钮layout_width="0dp"（match constraints），通过layout_constraintStart_toStartOf /layout_constraintEnd_toStartOf 等属性 两两相互约束形成约束链 ，使每行 4 个按钮等宽分布；
 行与行之间通过layout_constraintTop_toBottomOf 纵向串联，整个键盘不依赖嵌套布局，层级扁平。

 实验 4：约束布局（太空旅行界面）
在 activity_space.xml 中，使用ConstraintLayout 实现了一个较复杂的"太空航班预订"界面，包含：
 顶部三个带图标的标签（Space Stations / Flights / Rovers），图标与文字垂直居中对齐；
 左右两个绿色方块（DCA、MARS）分别贴靠父布局两端，中间放置双向箭头图片并同时约束左右方块实现水平居中；
 橙色SwitchCompat （One Way）开关与"1 Traveller"文本；
火箭、星球图片装饰；
底部DEPART 按钮通过layout_constraintBottom_toBottomOf="parent" 固定在屏幕底部。
关键技术点：
- 综合运用相对定位、基线/边缘对齐、margin 微调，验证了 ConstraintLayout 在 扁平层级下实现复杂界面 的能力；
- 使用`backgroundTint` 修改按钮颜色，保持原生按钮样式的同时自定义配色。

 四、遇到的问题与解决
1. 权重不生效 ：实验 1 中最初给子视图设置了wrap_content 宽度导致layout_weight 分配不均，改为layout_width="0dp" 后权重才按预期等分。理解了"使用权重时对应方向尺寸应设为 0dp"的规范。
2. 约束缺失报错 ：实验 3 中按钮只设置了水平约束未设置垂直约束，预览时报"缺少约束"警告且运行时控件堆叠在左上角。补齐每个控件水平、垂直两个方向的约束后解决。
3. 层叠层级问题 ：实验 4 若用 LinearLayout 嵌套实现会层级过深，改用 ConstraintLayout 单层实现，体会到约束布局减少嵌套、提升绘制性能的优势。
 
 五、实验心得
通过本次实验，掌握了 Android 三种主流布局的特点：
LinearLayout 简单直观、适合规则排列，配合权重可实现比例分配，但复杂界面需要多层嵌套；
TableLayout 适合行列对齐的表格类信息展示；
ConstraintLayout 功能最强，通过约束关系可在扁平层级下实现复杂界面，是实际开发中的首选。
同时熟悉了layout_weight 、gravity 、constraintXxx_toYyyOf 等常用属性，加深了对"0dp 在权重和约束中表示按比例分配空间"这一用法的理解，为后续 Android 应用开发打下了布局基础。
