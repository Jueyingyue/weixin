/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : weixin

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 06/09/2025 22:55:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for test_result
-- ----------------------------
DROP TABLE IF EXISTS `test_result`;
CREATE TABLE `test_result`  (
  `max_score` int NOT NULL COMMENT '结果最大分数范围',
  `min_score` int NOT NULL COMMENT '结果最小分数范围',
  `result_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '结果描述',
  `result_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '结果类型',
  `biz_type_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '业务类型代码',
  `biz_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '1-第一板块 2-第二版块 3-第三版块',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '详细解读报告详细解读报告',
  `reasoning_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '推理内容',
  PRIMARY KEY (`biz_type`, `biz_type_code`, `max_score`, `min_score`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_result
-- ----------------------------
INSERT INTO `test_result` VALUES (3, 0, '你的得分较低，表明你在追求成就、设定目标与努力达成方面的倾向较弱，更倾向于随遇而安，对成果的追求不明显。', '心理测试结果', 'AchievingType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (6, 4, '你的得分处于中等偏低范围，说明你有一定的自我要求，但动力、目标感与执行力仍有较大提升空间。', '心理测试结果', 'AchievingType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (9, 7, '你的得分处于中等偏高水平，表明你有较强的成就动机，愿意为目标付出努力，并在很多方面展现出追求卓越的特质。', '心理测试结果', 'AchievingType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (12, 10, '你的得分很高，表明你具有非常典型的成就型人格，目标明确、行动力强、追求卓越，是高度自我驱动的成就追求者。', '心理测试结果', 'AchievingType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (2, 0, '你的得分较低，表明你在活力、社交与行动力等活跃型特质上表现较弱，更偏向安静或内向型。', '心理测试结果', 'ActiveType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (4, 3, '你的得分处于中等偏低范围，说明你有一定的活跃倾向，但整体上仍较为内敛或温和。', '心理测试结果', 'ActiveType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (7, 5, '你的得分处于中等偏高水平，表明你具有较强的活力与社交主动性，喜欢与人互动和行动。', '心理测试结果', 'ActiveType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (10, 8, '你的得分很高，表明你具有典型的活跃型人格，充满能量、热爱社交、行动迅速且乐于带动他人。', '心理测试结果', 'ActiveType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (3, 0, '你的得分较低，表明你在创造力、艺术感知和个性化表达方面的倾向较弱，更偏向于逻辑和实用导向。', '心理测试结果', 'ArtisticType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (6, 4, '你的得分处于中等偏低范围，说明你有一定的艺术兴趣，但创造力和情感表达仍有一定提升空间。', '心理测试结果', 'ArtisticType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (9, 7, '你的得分处于中等偏高水平，表明你具有较强的艺术感知力与创造力，喜欢通过非传统方式表达自我。', '心理测试结果', 'ArtisticType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (12, 10, '你的得分很高，表明你具有典型的艺术型人格，富有创造力、情感丰富，对美与个性表达有深刻追求。', '心理测试结果', 'ArtisticType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (2, 0, '你的得分较低，表明你在学习、思考与探索方面的倾向较弱，更偏向于直观和经验导向。', '心理测试结果', 'IntellectualType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (4, 3, '你的得分处于中等偏低范围，说明你有一定的好奇心，但深入思考与学习热情仍有提升空间。', '心理测试结果', 'IntellectualType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (7, 5, '你的得分处于中等偏高水平，表明你具有较强的求知欲与思维深度，喜欢探索和理解事物背后的逻辑。', '心理测试结果', 'IntellectualType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (10, 8, '你的得分很高，表明你具有显著的智慧型人格特质，热爱学习、善于思考，追求知识与真理。', '心理测试结果', 'IntellectualType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (2, 0, '你的得分较低，表明你在领导力、决策与影响力等领袖型特质上表现较弱，更倾向于跟随或配合他人。', '心理测试结果', 'LeaderType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (4, 3, '你的得分处于中等偏低范围，说明你有一定的领导潜力，但整体领导力、决策力与影响力仍有提升空间。', '心理测试结果', 'LeaderType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (7, 5, '你的得分处于中等偏高水平，表明你具有较强的领导意愿与部分核心能力，能够承担一定的领导角色。', '心理测试结果', 'LeaderType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (10, 8, '你的得分很高，表明你具有典型的领袖型人格，具备决策力、影响力、目标感与责任感，是天生的领导者。', '心理测试结果', 'LeaderType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (3, 0, '你的得分较低，表明你在日常生活中较少主动关心他人，更倾向于关注自己的需求。利他行为较少，可能较注重自我边界。', '全爱型人格倾向结果', 'LovingType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (6, 4, '你的得分处于中等偏低范围，说明你有一定的利他倾向，但大多数时候还是会优先考虑自己。帮助他人往往是有条件的，或基于特定情境。', '全爱型人格倾向结果', 'LovingType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (9, 7, '你的得分处于中等偏高水平，表明你比较关心他人的感受和需求，常常愿意主动提供帮助。具有一定的全爱型特质，能关注周围人的情绪。', '全爱型人格倾向结果', 'LovingType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (12, 10, '你的得分很高，表明你非常关心他人，常常优先考虑别人的需求，乐于助人且富有同理心。你具有典型的全爱型人格倾向，是温暖和体贴的人。', '全爱型人格倾向结果', 'LovingType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (2, 0, '你的得分较低，表明你在信任、承诺与责任等忠诚型特质上表现较弱，更偏向于灵活或独立导向。', '心理测试结果', 'LoyalType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (4, 3, '你的得分处于中等偏低范围，说明你有一定的忠诚倾向，但在责任与信任的稳定性上仍有提升空间。', '心理测试结果', 'LoyalType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (7, 5, '你的得分处于中等偏高水平，表明你具有较好的忠诚特质，重视承诺、信任与团队关系。', '心理测试结果', 'LoyalType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (10, 8, '你的得分很高，表明你具有典型的忠诚型人格，非常重视信任、责任与人际关系中的可靠性。', '心理测试结果', 'LoyalType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (2, 0, '你的得分较低，表明你在温和、包容与避免冲突等和平型特质上表现较弱，更倾向于竞争或直接表达。', '心理测试结果', 'PeaceType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (4, 3, '你的得分处于中等偏低范围，说明你有一定的和平倾向，但在面对冲突或压力时仍可能不够平和。', '心理测试结果', 'PeaceType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (7, 5, '你的得分处于中等偏高水平，表明你具有较好的平和心态与包容性，能够维护和谐的人际关系。', '心理测试结果', 'PeaceType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (10, 8, '你的得分很高，表明你具有典型的和平型人格，非常注重和谐、稳定与包容，善于化解矛盾。', '心理测试结果', 'PeaceType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (15, 0, '您的得分暂未匹配到标准区间，如有可能请确认分数是否正确，或再次尝试测试。', '分数不在评估范围内', 'PerfectType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (15, 30, '您的心态非常灵活，能轻松接受「足够好」的状态，不容易被细节束缚，这是一种非常健康的心态。', '完美倾向很弱', 'PerfectType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (45, 31, '您注重做事的质量，但也能够兼顾效率，能在“追求更好”和“适时完成”之间找到不错的平衡。', '轻微完美倾向', 'PerfectType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (60, 45, '您对自己的要求比较高，可能会因为一些小失误感到焦虑。建议适当放松标准，接纳不完美的可能性。', '中度完美倾向', 'PerfectType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (75, 61, '您追求极致与卓越，对细节非常关注，但可能容易因“不完美”产生较大压力。建议多关注情绪管理，允许自己适度放松。', '高度完美倾向', 'PerfectType', '1', NULL, NULL);
INSERT INTO `test_result` VALUES (10, 5, '您的得分表明您在面对压力时容易感到焦虑和紧张，情绪管理较弱，属于压力易感型。', '压力易感型', 'AgreeablenessType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (15, 11, '您的得分表明您对压力有一定反应，但能尝试采取一些方法调节，属于压力敏感型。', '压力敏感型', 'AgreeablenessType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (20, 16, '您的得分表明您能较好地应对压力，有主动调节的意识和行为，属于压力适应型。', '压力适应型', 'AgreeablenessType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (25, 21, '您的得分表明您面对压力时心态积极，能将压力转化为动力，具备优秀的压力管理能力。', '压力驾驭型', 'AgreeablenessType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (5, 1, '您倾向于追求原则、秩序与责任，对自己和他人都较为严格，属于完美型（类型1）。', '完美型', 'BileType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (10, 6, '您关注他人需求，乐于付出与支持，以帮助他人为乐，属于助人型（类型2）。', '助人型', 'BileType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (15, 11, '您追求成功与认可，有较强的目标感与表现欲，属于成就型（类型3）。', '成就型', 'BileType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (20, 16, '您渴望独特与自我表达，情感丰富且追求真实，属于艺术型（类型4）。', '艺术型', 'BileType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (25, 21, '您喜欢思考、观察与探索内心世界，重视知识与独立，属于观察型（类型5）。', '观察型', 'BileType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (30, 26, '您重视安全与信任，害怕被背叛，常希望获得保障，属于忠诚型（类型6）。', '忠诚型', 'BileType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (35, 31, '您追求快乐、自由与新奇，乐观开朗，讨厌束缚，属于活跃型（类型7）。', '活跃型', 'BileType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (40, 36, '您具有领导气质，追求控制与影响力，独立自主，属于领袖型（类型8）。', '领袖型', 'BileType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (45, 41, '您追求和谐、避免冲突，适应力强，善于调解，属于和平型（类型9）。', '和平型', 'BileType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (10, 5, '您的得分表明您在情绪管理和人际敏感度方面还有较大提升空间，建议加强自我觉察与沟通练习。', '情商待提升型', 'EmotionalType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (15, 11, '您的得分表明您具备基本的人际交往能力，但在情绪调节和同理心方面仍有进步空间。', '一般适应型', 'EmotionalType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (20, 16, '您的得分表明您情绪较为稳定，能够较好理解他人，人际关系处理能力较为成熟。', '情商良好型', 'EmotionalType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (25, 21, '您的得分表明您具有很高的情商，在情绪管理、同理心和人际沟通方面表现优秀。', '情商优秀型', 'EmotionalType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (15, 10, '您的焦虑水平很低，情绪状态较为平和，属于无焦虑范围。', '无焦虑', 'ExtraversionType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (25, 16, '您可能存在轻度的焦虑情绪，偶尔感到紧张或担忧，属于轻度焦虑。', '轻度焦虑', 'ExtraversionType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (35, 26, '您的焦虑感受较为明显，可能影响日常生活，建议关注情绪调节与放松。', '中度焦虑', 'ExtraversionType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (40, 36, '您的焦虑水平较高，建议您及时寻求专业心理支持与帮助。', '重度焦虑', 'ExtraversionType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (10, 5, '您的得分表明您更注重恋爱中的现实条件与理性判断，属于理性现实型恋爱风格。', '理性现实型', 'ExtrovertType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (15, 11, '您的得分表明您的恋爱态度较为平衡，既重感情也考虑现实，属于平衡温和型。', '平衡温和型', 'ExtrovertType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (20, 16, '您的得分表明您倾向于追求浪漫与激情，重视情感深度与恋爱体验，属于浪漫激情型。', '浪漫激情型', 'ExtrovertType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (25, 21, '您的得分表明您可能对伴侣有较强的占有欲或奉献精神，情感投入深，属于占有奉献型。', '占有奉献型', 'ExtrovertType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (10, 5, '您的得分表明您对未来没有特别明确的规划，更倾向于顺其自然、灵活应对，属于随遇而安型。', '随遇而安型', 'futurePrediction', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (15, 11, '您的得分表明您对未来存在一定担忧，容易感到不安或不确定，属于焦虑不确定型。', '焦虑不确定型', 'futurePrediction', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (20, 16, '您的得分表明您对未来有适度规划，同时也能根据实际情况作出调整，属于现实灵活型。', '现实灵活型', 'futurePrediction', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (25, 21, '您的得分表明您对未来充满信心，有清晰的目标和积极的行动力，属于乐观规划型。', '乐观规划型', 'futurePrediction', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (10, 0, '您当前的幸福感较低，建议关注生活中的积极面，多与亲友交流，培养兴趣爱好。', '低幸福感', 'happiness', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (20, 11, '您当前的幸福感处于中等水平，生活中有喜有忧，仍有提升空间。', '中等幸福感', 'happiness', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (25, 21, '恭喜！您当前的幸福感较高，说明您对生活整体较为满意，继续保持哦！', '高幸福感', 'happiness', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (10, 5, '您的得分表明您较难准确识别他人的情绪状态，对非语言情绪线索不够敏感，情绪识别能力有待提升。', '情绪识别较弱型', 'IntrovertType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (15, 11, '您的得分表明您能识别一些基本的情绪信号，但对复杂或隐含的情绪表达识别能力一般。', '情绪识别一般型', 'IntrovertType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (20, 16, '您的得分表明您能较准确地识别他人的情绪，包括面部表情、语气和肢体语言等情绪线索。', '情绪识别良好型', 'IntrovertType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (25, 21, '您的得分表明您对他人情绪变化非常敏感，能精准识别各种情绪表达与潜在情绪状态。', '情绪识别优秀型', 'IntrovertType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (10, 5, '您的得分表明您在恋爱中倾向于保持独立与距离，不轻易依赖伴侣，属于回避疏离型依恋。', '回避疏离型', 'MelancholicType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (15, 11, '您的得分表明您能够在恋爱中建立稳定、信任的关系，既不焦虑也不疏远，属于安全稳定型依恋。', '安全稳定型', 'MelancholicType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (20, 16, '您的得分表明您渴望亲密关系，但常担心不被接纳，对伴侣的反应较为敏感，属于焦虑渴求型依恋。', '焦虑渴求型', 'MelancholicType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (25, 21, '您的得分表明您对伴侣有很强的情感依赖，渴望时刻紧密联系，属于高度依恋型依恋风格。', '高度依恋型', 'MelancholicType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (19, 10, '您的得分表明您目前无明显抑郁情绪，情绪状态基本正常。', '无明显抑郁', 'OpennessType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (29, 20, '您的得分提示可能存在轻度抑郁情绪，建议您关注情绪变化，适当调节。', '轻度抑郁', 'OpennessType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (39, 30, '您的得分表明抑郁情绪较为明显，建议您寻求专业心理咨询或支持。', '中度抑郁', 'OpennessType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (50, 40, '您的得分提示存在较严重的抑郁情绪倾向，强烈建议您尽快寻求心理或医疗帮助。', '重度抑郁倾向', 'OpennessType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (20, 10, '您的得分表明您性格较为内敛、谨慎，情绪稳定但可能对外界变化反应较慢，属于内向谨慎型。', '内向谨慎型', 'PhlegmaticType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (30, 21, '您的得分表明您的性格较为平衡，情绪稳定，人际交往与行为方式适中，属于平衡稳定型。', '平衡稳定型', 'PhlegmaticType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (40, 31, '您的得分表明您可能较为外向、好奇，情感丰富，喜欢探索新事物，属于外向开放型。', '外向开放型', 'PhlegmaticType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (50, 41, '您的得分表明您情绪体验深刻，思维活跃，对外界反应敏锐，个性鲜明且强烈，属于高敏感活跃型。', '高敏感活跃型', 'PhlegmaticType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (10, 5, '您的得分表明您情绪容易波动，遇到问题时容易冲动，情绪管理能力有待加强。', '情绪易失控型', 'RationalType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (15, 11, '您的得分表明您能在一定程度上控制情绪，但在压力情境下情绪管理仍需提升。', '情绪管理一般型', 'RationalType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (20, 16, '您的得分表明您情绪较为稳定，能理性面对挑战，具备良好的情绪调节与控制能力。', '情绪稳定型', 'RationalType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (25, 21, '您的得分表明您拥有出色的情绪管理能力，能冷静、有效地处理各种情绪问题。', '情绪掌控型', 'RationalType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (10, 5, '您的得分表明您性格温和、适应力强，倾向配合与支持他人，属于稳健型（S型）性格。', '稳健型', 'SanguineType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (15, 11, '您的得分表明您外向热情，乐于表达、擅长与人交往，属于表达型（I型）性格。', '表达型', 'SanguineType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (20, 16, '您的得分表明您注重细节、规则和准确性，偏向理性分析，属于谨慎型（C型）性格。', '谨慎型', 'SanguineType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (25, 21, '您的得分表明您目标感强、决策果断、喜欢掌控，属于支配型（D型）性格。', '支配型', 'SanguineType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (10, 5, '您的得分表明您较难理解他人的感受，缺乏情感共鸣与换位思考的能力，同理心有待提升。', '同理心较弱型', 'WillpowerType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (15, 11, '您的得分表明您能部分理解他人的情绪，但在情感共鸣和主动关心方面仍有提升空间。', '同理心一般型', 'WillpowerType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (20, 16, '您的得分表明您能较准确地感知他人情绪，愿意站在他人角度思考问题，同理心表现良好。', '同理心良好型', 'WillpowerType', '3', NULL, NULL);
INSERT INTO `test_result` VALUES (25, 21, '您的得分表明您对他人情绪高度敏感，善于换位思考，具备很强的共情能力与关怀意识。', '同理心优秀型', 'WillpowerType', '3', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
